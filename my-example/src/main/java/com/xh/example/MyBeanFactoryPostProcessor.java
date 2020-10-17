package com.xh.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author Xiong Hao
 * @date 2020/10/17
 */
public class MyBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private static final Log log = LogFactory.getLog((MyBeanFactoryPostProcessor.class));

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("my postProcessBeanFactory....");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info("my postProcessBeanDefinitionRegistry....");
    }
}
