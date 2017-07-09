package com.ul.core.spring.datasource;

import java.lang.annotation.*;

/**
 * 指定数据源，用于Mybatis Mapper接口与方法
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource  {

    String value() default "";

    String desc() default "";
}
