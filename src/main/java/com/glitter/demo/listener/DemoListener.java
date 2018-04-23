package com.glitter.demo.listener;



import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2018/4/23.
 */
public class DemoListener implements ServletContextListener {




    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String projectName = String.valueOf(servletContextEvent.getServletContext().getInitParameter("projectName"));
        System.out.println(projectName);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}