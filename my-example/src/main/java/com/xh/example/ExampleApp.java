package com.xh.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xiong Hao
 * @date 2020/3/17
 */
@Service
@Configuration
@ComponentScan("com.xh.example")
public class ExampleApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ExampleApp.class);
		System.out.println(context.getBean(ExampleApp.class));
		System.out.println(context.getBean(MyService.class).getMyRepository());
	}
}
