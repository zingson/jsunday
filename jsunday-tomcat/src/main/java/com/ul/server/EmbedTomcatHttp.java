package com.ul.server;


import org.apache.catalina.Host;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * 嵌入Tomcat Http服务
 */
public class EmbedTomcatHttp {

    static final int port = 9080;
    static final String docBase = System.getProperty("user.dir");

    public static void main(String[] args) throws Exception {
        System.out.println("docBase="+docBase);
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        Connector connector = tomcat.getConnector();
        //Tomcat信息目录
        tomcat.setBaseDir(docBase);

        Host host = tomcat.getHost();
        //自动部署
        host.setAutoDeploy(true);
        //项目所在目录
        host.setAppBase("webapps");

        StandardContext context = new StandardContext();
        context.setPath("/book");
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);

        //tomcat.addServlet(contextPath, "homeServlet", new HomeServlet());
        //context.addServletMappingDecoded("/home", "homeServlet");

        //tomcat.addWebapp("/",new File(webappDirLocation).getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await();
    }
}
