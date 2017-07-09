package com.ul.core.spring.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Spring动态数据源管理
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        try {
            return contextHolder.get();
        } finally {
            contextHolder.remove();
        }
    }

    /**
     * 通过AOP配置动态数据源
     */
    public void beforeMethod(JoinPoint joinPoint){
        DataSource dataSource;
        Signature signature = joinPoint.getSignature();

        //检查类注解
        @SuppressWarnings("unchecked")
        Annotation annotation = signature.getDeclaringType().getAnnotation(DataSource.class);
        if(annotation!=null&&DataSource.class.equals(annotation.annotationType())){
            dataSource = (DataSource)annotation;
            if(dataSource==null||StringUtils.isEmpty(dataSource.value())){
                //检查方法注解
                Method method = ((MethodSignature) signature).getMethod();
                dataSource = method.getAnnotation(DataSource.class);
            }
            if(dataSource!=null&&!StringUtils.isEmpty(dataSource.value())){
                contextHolder.set(dataSource.value());
            }
        }
        //没有匹配到注解，使用默认数据源

        //System.out.println("当前使用的DataSource="+dataSource.value());
    }
}
