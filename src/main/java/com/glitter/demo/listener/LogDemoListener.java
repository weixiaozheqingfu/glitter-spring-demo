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
public class LogDemoListener implements ServletContextListener {
//  private static final Logger logger = LogManager.getLogger(DemoListener.class);

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // TODO 怎么打印出特定包的日志  比如mybatis日志，比如数据库日志。

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String projectName = String.valueOf(servletContextEvent.getServletContext().getInitParameter("projectName"));
        System.out.println(projectName);
        logger.debug("===========================debug================================");
        logger.info("===========================info================================");
        logger.warn("===========================warn================================");
        logger.error("===========================error================================");
//      logger.fatal("===========================fatal================================");

//      for遍历1000000条日志打印，来观察异步日志的输出情况，可与同步日志输出情况做对比。
//      只是在文件中打印日志，异步日志耗时约112毫秒，同步日志输出约耗时530毫秒。如果同时放开控制台打印日志，异步日志耗时约112毫秒，同步日志输出约耗时13秒。
//      Long begin = System.currentTimeMillis();
//      for(int i=0;i<100000;i++){
//          logger.error("==========================="+i+"================================");
//      }
//      Long end = System.currentTimeMillis();
//      Long timeConsuming = end -begin;
//      logger.error("总耗时："+timeConsuming+"毫秒");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}