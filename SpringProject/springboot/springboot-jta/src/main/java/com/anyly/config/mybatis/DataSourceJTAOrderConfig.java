package com.anyly.config.mybatis;
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.anyly.order.mapper", sqlSessionTemplateRef = "jtaOrderSqlSessionTemplate")
public class DataSourceJTAOrderConfig {
    @Bean(name = "dataSourceJTAOrder")
    public DataSource user1DataSource() throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl("jdbc:mysql://150.109.38.149:3306/jta-order");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword("oj2twpqwelmw");
        mysqlXADataSource.setUser("root");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName("dataSourceJTAOrderDataSource");
        xaDataSource.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
        xaDataSource.setMinPoolSize(3);
        xaDataSource.setMaxPoolSize(25);
        xaDataSource.setMaxLifetime(20000);
        xaDataSource.setBorrowConnectionTimeout(60);
        xaDataSource.setLoginTimeout(30);
        xaDataSource.setMaintenanceInterval(60);
        xaDataSource.setMaxIdleTime(60);
        xaDataSource.setTestQuery("select 1");
        return xaDataSource;
    }
    @Bean(name="jtaOrderSqlSessionFactory")
    public SqlSessionFactory jtaOrderSqlSessionFactory(@Qualifier("dataSourceJTAOrder") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration =  new org.apache.ibatis.session.Configuration();
        configuration.setCallSettersOnNulls(true);
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name="jtaOrderSqlSessionTemplate")
    public SqlSessionTemplate jtaIncomeSqlSessionTemplate(@Qualifier("jtaOrderSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}