package com.lsl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


/**
 * 这个类相当于原来的spring中的applicationservlet.xml\
 * 配置数据库连接池，事务管理器，业务bean...
 */
@Configuration
@ComponentScan(basePackages = "com.lsl",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {

}
