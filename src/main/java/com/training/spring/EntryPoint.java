package com.training.spring;

import com.training.spring.bean.Event;
import com.training.spring.bean.HelloWorld;
import com.training.spring.bean.log.LoggerManager;
import com.training.spring.bean.log.api.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by oleksandr.
 */
public class EntryPoint {
    public static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    private static void iterateLogger(EventLogger loggerManager){
        for(int i = 0; i < 5; i++){
            Event event = ctx.getBean(Event.class);
            event.setMessage("Some custom message #" + i);
            loggerManager.log(event);
        }
    }
    public static void main(String[] args) {
        //say hello
        HelloWorld helloBean = ctx.getBean(HelloWorld.class);
        helloBean.sayHello();


        //Event logger example
        EventLogger loggerManager = (LoggerManager) ctx.getBean("loggerManager");
        iterateLogger(loggerManager);

    }
}
