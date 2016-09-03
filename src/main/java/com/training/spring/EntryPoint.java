package com.training.spring;

import com.training.spring.bean.log.api.LoggerManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by oleksandr.
 */
public class EntryPoint {


    private ApplicationContext ctx;

    private void iterateLogger(LoggerManager loggerManager){
        for(int i = 0; i < 5; i++){
            if(i%2 == 0){
                loggerManager.error("Error occurred");
            } else if (i%3 == 0){
                loggerManager.warn("Warning!");
            }
            else {
                loggerManager.info("Some information");
            }
        }
    }
    public static void main(String[] args) {
        /*
        //say hello
        HelloWorld helloBean = ctx.getBean(HelloWorld.class);
        helloBean.sayHello();
        */

        //Event logger example
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EntryPoint entryPoint = new EntryPoint();
        LoggerManager loggerManager = (LoggerManager) ctx.getBean("loggerManager");
        entryPoint.iterateLogger(loggerManager);


    }
}
