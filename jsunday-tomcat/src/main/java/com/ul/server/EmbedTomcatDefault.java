package com.ul.server;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.JreMemoryLeakPreventionListener;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.ThreadLocalLeakPreventionListener;
import org.apache.catalina.mbeans.GlobalResourcesLifecycleListener;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.startup.VersionLoggerListener;

import java.io.File;


/**
 * 默认端口 8080
 *
 */
public class EmbedTomcatDefault {

    //如webapps
    static final String BASE_DIR = System.getProperty("user.dir") + File.separator + "jsunday-tomcat"+ File.separator;

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(BASE_DIR);
        //Server>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Server server = tomcat.getServer();

        System.out.println("Server.CatalinaHome="+server.getCatalinaHome().getPath());
        System.out.println("Server.CatalinaBase="+server.getCatalinaBase().getPath());
        System.out.println("Server.Port="+server.getPort());
        System.out.println("Server.Address="+server.getAddress());
        System.out.println("Server.Shutdown="+server.getShutdown());

        server.addLifecycleListener(new VersionLoggerListener());
        server.addLifecycleListener(new AprLifecycleListener());
        server.addLifecycleListener(new JreMemoryLeakPreventionListener());
        server.addLifecycleListener(new GlobalResourcesLifecycleListener());
        server.addLifecycleListener(new ThreadLocalLeakPreventionListener());

        Service service = tomcat.getService();


        //Host>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Host host = tomcat.getHost();
        host.setAutoDeploy(true);
        host.setAppBase(BASE_DIR+"build");

        System.out.println("Host.AppBase="+host.getAppBase());

        //Engine>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Engine engine = tomcat.getEngine();

        //Connector>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Connector connector = tomcat.getConnector();

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        //第一个参数对应Context配置的path,表示tomcat上下文，用hostname:port加上contextPath访问，
        tomcat.addWebapp("", BASE_DIR+"/src/main/webapp");

        tomcat.start();
        tomcat.getServer().await();
    }

}
