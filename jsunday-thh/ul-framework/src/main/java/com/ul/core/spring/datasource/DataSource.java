package com.ul.core.spring.datasource;

import java.lang.annotation.*;

/**
 * 指定数据源，用于Mybatis Mapper接口
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    String value() default "";

    String desc() default "";
}
