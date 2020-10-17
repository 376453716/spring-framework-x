package com.xh.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author Xiong Hao
 * @date 2020/3/17
 */
@Service
@Configuration
@ComponentScan("com.xh.example")
public class ExampleApp {

    private static Log log = LogFactory.getLog(ExampleApp.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
        context.register(MyService.class);
        context.register(ExampleApp.class);
        context.refresh();
        log.info(context.getBean(ExampleApp.class));
        log.info(context.getBean(MyService.class).getMyRepository());
    }
}
