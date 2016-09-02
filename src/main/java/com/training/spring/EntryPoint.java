package com.training.spring;

import com.training.spring.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by oleksandr.
 */
public class EntryPoint {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring.xml");
        HelloWorld helloBean = ctx.getBean(HelloWorld.class);
        helloBean.sayHello();
    }
}
