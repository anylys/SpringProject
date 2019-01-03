package com.anyly.config.mybatis;

import org.jboss.logging.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author anyly
 * 继承mybatis 数据源路由
 */
public class DynamicDataSource  extends AbstractRoutingDataSource {
    Logger logger = Logger.getLogger(this.getClass());
    @Override
    protected Object determineCurrentLookupKey() {
        if(DatabaseContextHolder.getDatabaseType() ==null){
            logger.info("默认的数据源=:userDateSource");
        }else{
            logger.info("determineCurrentLookupKey:"+DatabaseContextHolder.getDatabaseType());
        }
        return DatabaseContextHolder.getDatabaseType();
    }
}
