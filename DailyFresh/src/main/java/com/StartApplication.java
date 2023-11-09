package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * SpringBoot启动类
 */
@MapperScan("com.neusoft.fresh.dao")
@SpringBootApplication(scanBasePackages = "com")
public class StartApplication extends SpringBootServletInitializer {
	
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) { 
        return application.sources(StartApplication.class);  
    }  	
	 
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
