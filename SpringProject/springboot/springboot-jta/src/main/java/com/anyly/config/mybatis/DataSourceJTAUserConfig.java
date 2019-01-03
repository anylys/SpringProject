package com.anyly.config.mybatis;

import javax.sql.DataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import java.sql.SQLException;
/**
 * @author lishengrong
 */
@Configuration
@MapperScan(basePackages = "com.anyly.user.mapper", sqlSessionTemplateRef = "jtaUserSqlSessionTemplate")
public class DataSourceJTAUserConfig {


    @Bean(name = "dataSourceJTAUser")
    public DataSource dataSourceJTAUser()  throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl("jdbc:mysql://120.78.160.41:3306/jta-user");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword("anyly1027827");
        mysqlXADataSource.setUser("root");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName("dataSourceJTAUserDataSource");
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

    @Bean(name="jtaUserSqlSessionFactory")
    public SqlSessionFactory jtaUserSqlSessionFactory(@Qualifier("dataSourceJTAUser") DataSource dataSource)
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

    @Bean(name="jtaUserSqlSessionTemplate")
    public SqlSessionTemplate jtaUserSqlSessionTemplate(
            @Qualifier("jtaUserSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}