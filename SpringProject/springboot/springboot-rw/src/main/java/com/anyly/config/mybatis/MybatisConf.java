package com.anyly.config.mybatis;
import com.alibaba.druid.pool.DruidDataSource;
import com.anyly.emun.DatabaseType;
import com.anyly.interceptor.mybatis.BatisInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lishengrong
 */
@Configuration
public class MybatisConf {
    /**
     * 读数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix="spring.datasource-order")
    public DataSource orderDateSource() {
        return new DruidDataSource();
    }

    /**
     * 写数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix="spring.datasource-user")
    public DataSource userDateSource() {
        return new DruidDataSource();
    }

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("orderDateSource") DataSource orderDateSource, @Qualifier("userDateSource") DataSource userDateSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        targetDataSources.put(DatabaseType.orderDateSource, orderDateSource);
        targetDataSources.put(DatabaseType.userDateSource, userDateSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        // 该方法是AbstractRoutingDataSource的方法
        dataSource.setTargetDataSources(targetDataSources);
        // 默认的datasource设置为myTestDbDataSource
        dataSource.setDefaultTargetDataSource(userDateSource);
        return dataSource;
    }

    /**
     * 提供SqlSeesion
     * @param dynamicDataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource  dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{new BatisInterceptor()});
        // 指定数据源(这个必须有，否则报错)
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        org.apache.ibatis.session.Configuration configuration =  new org.apache.ibatis.session.Configuration();
        configuration.setCallSettersOnNulls(true);
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
        try {
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Bean(name = "sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    /**
     * 事务管理
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(userDateSource());
    }

}
