package com.ul.server;

import org.apache.catalina.Host;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * 嵌入式Tomcat，单个项目配置
 */
public class EmbedTomcatHttpSingle {

    /**
     * 配置项
     */
    static final int PORT = 8090;                                    //端口号
    static final String BASE_DIR = System.getProperty("user.dir");   //Tomcat信息目录


    public static void main(String[] args) throws Exception {
        System.out.println("BASE_DIR="+BASE_DIR);
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);
        tomcat.setBaseDir(BASE_DIR);

        Host host = tomcat.getHost();
        host.setAutoDeploy(true);
        host.setAppBase("webapps");

        tomcat.start();
        tomcat.getServer().await();
    }

}
