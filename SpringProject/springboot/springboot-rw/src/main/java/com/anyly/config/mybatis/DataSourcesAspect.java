package com.anyly.config.mybatis;

import com.anyly.emun.DatabaseType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

/**
 * @author anyly
 * 动态数据源
 */
@Aspect
@Component
public class DataSourcesAspect {
    Logger logger = Logger.getLogger(this.getClass());
    @Pointcut("@annotation(com.anyly.annotation.DataSourceSwitch)")
    public void dataSourceSwitch(){}

    @Before("dataSourceSwitch()")
    public void deBefore(JoinPoint joinPoint) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.orderDateSource);
        logger.info("================================deBefore");
    }

}
