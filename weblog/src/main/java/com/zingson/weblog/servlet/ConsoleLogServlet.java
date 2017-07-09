package com.zingson.weblog.servlet;

import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 网页控制台查询日志
 * type   类型   不可为空
 * date   日期   不指定默认当前
 * hour   时间   24小时制，默认当前小时
 * value  值     类型对应的待查询值
 */
@WebServlet("/weblog")
public class ConsoleLogServlet  extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<String> results = searchLogResults(request);
        response.getWriter().print(consoleContent(results));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().print(consoleView());
    }

    /**
     * 日志搜索结果集
     * @return
     */
    private List<String> searchLogResults(HttpServletRequest request) throws IOException {
        List<String> rs = new ArrayList<>();

        String type = request.getParameter("t");
        String date = request.getParameter("d");
        String hour = request.getParameter("h");
        String value = request.getParameter("v");

        String systemPath = request.getServletContext().getRealPath("/");
        System.out.println("systemPath="+systemPath);

        String logFile = "waimai"+File.separator;
        if(date!=null){ logFile += date+File.separator; }
        if(hour!=null){
            logFile += "wm-"+hour+".log";
        }else{
            //递归遍历目录
        }

        File file = new File(new File(systemPath).getParentFile().getParent()+File.separator+"logs",logFile);
        System.out.println("search LogFile:"+file.getPath());
        if (file.isFile()) {
            List<String> list = FileUtils.readLines(file);
            list.forEach((v)->{
                if(v.indexOf(value)>0){
                    rs.add(v);
                }
            });
        }
        return rs;
    }

    /**
     * 搜索结果输出
     * @param results
     * @return
     */
    private String consoleContent(List<String> results){
        StringBuffer sb = new StringBuffer();
        if(results!=null){
            results.forEach((v)->{
                sb.append("<p class='log-line'>");
                sb.append(v);
                sb.append("</p>");
            });
        }
        return (sb.length()>0?sb:sb.append("无搜索结果..."))
                .append("<style>p{color: #28b8bf;font-size: 12px;margin: 0;line-height: 18px;}</style>")
                .toString();
    }

    /**
     * 页面显示内容
     */
    private String consoleView(){

        StringBuffer sb = new StringBuffer();
        sb.append("<title>日志查询</title>");
        sb.append("<style>*{margin: 0px;padding: 0px;} body{background-color: #000;color: #bb991b;} input{background-color: #000;border: 1px solid #53651d;color: #fff;} .result{height: 800px;}</style>");
        sb.append("<div class='content'>");
        sb.append("<div class='query'>");
        sb.append("<form action='#' method='POST' target='iframe_view'>");
        sb.append("类型：<input type='text' name='t'/>");
        sb.append("<input type='text' name='v' value='搜索的内容'/>");
        sb.append("日期：<input type='text' name='d'/>");
        sb.append("时间：<input type='text' name='h'/>");
        sb.append("<input type='submit' value='查询'/>");
        sb.append("</form>");
        sb.append("</div>");
        sb.append("<div class='result'>");
        sb.append("<iframe name='iframe_view' id='iframe_view' width='100%' height='100%' frameborder='0' marginheight=0 marginwidth=0></iframe>");
        sb.append("");
        sb.append("</div>");
        sb.append("</div>");
        return sb.toString();
    }
}