package de.odalinho.async.config;

import lombok.val;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.Executors;

@Configuration
public class PublishingConfiguration {
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        val defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public ApplicationEventMulticaster applicationEventMulticaster() {
        val eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(Executors.newFixedThreadPool(5));
        return eventMulticaster;
    }
}
