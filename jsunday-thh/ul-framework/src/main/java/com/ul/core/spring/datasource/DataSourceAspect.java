package com.ul.core.spring.datasource;

import org.aspectj.lang.JoinPoint;
import org.springframework.util.StringUtils;


/**
 * 动态数据源切换实现
 */
public class DataSourceAspect {

    public void beforeMethod(JoinPoint joinPoint){
        Class clazz = joinPoint.getSignature().getDeclaringType();
        DataSource dataSource = (DataSource) clazz.getAnnotation(DataSource.class);
        if(dataSource!=null&&!StringUtils.isEmpty(dataSource.value())){
            DynamicDataSource.setDbType(dataSource.value());
        }

        //System.out.println("当前使用的DataSource="+dataSource.value());
    }

}
