package com.ul.core.spring;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

/**
 * 加载配合文件，替代配置 <context:property-placeholder location="classpath:db.properties"/>
 *
 */
public class PropertyConfig extends PropertyPlaceholderConfigurer {

    public static final String DB1 = "db2";
    public static final String DB2 = "db2";

    private static Properties properties;

    public static Properties getProperties(){
        return properties;
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

    public static void set(String key,String value){
        properties.setProperty(key,value);
    }

    /**
     * 启动加载
     */
    public void init(){
        try {
            Resource resource = new ClassPathResource("db.properties");
            //Resource resource2 =  new FileSystemResource("E:\\IdeaProjects\\jsunday\\jsunday-thh\\ul-framework\\src\\main\\resources\\db.properties");

            //加载项目下配置文件,这里不用spring xml文件加载，便于配置文件目录修改
            super.setLocations(resource);
            properties = super.mergeProperties();

            logger.info("Load configuration file success "+resource.getFile().getPath());
        } catch (IOException e) {
            logger.error("*** 加载properties配置文件失败......");
            e.printStackTrace();
        }
    }



}
