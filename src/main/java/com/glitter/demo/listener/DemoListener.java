package com.glitter.demo.listener;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2018/4/23.
 */
public class DemoListener implements ServletContextListener {
//  private static final Logger logger = LogManager.getLogger(DemoListener.class);

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // TODO 怎么打印出特定包的日志  比如mybatis日志，比如数据库日志。

    // TODO 可以for遍历10000条日志打印，来观察异步日志的输出情况，可与同步日志输出情况做对比。

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String projectName = String.valueOf(servletContextEvent.getServletContext().getInitParameter("projectName"));
        System.out.println(projectName);
        logger.debug("===========================debug================================");
        logger.info("===========================info================================");
        logger.warn("===========================warn================================");
        logger.error("===========================error================================");
//      logger.fatal("===========================fatal================================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}