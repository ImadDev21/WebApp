package com.springboot.webapplication.todo;
//import com.springboot.webapplication.controller.*;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.spring.annotation.EnableVaadin;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = "com.springboot.webapplication.client")
@EntityScan(basePackages = "com.springboot.webapplication.client")
@EnableJpaRepositories(basePackages = "com.springboot.webapplication.client")
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
@EnableVaadin({"com.springboot.webapplication.View"})
public class TodoApplication /*extends SpringBootServletInitializer implements AppShellConfigurator*/ {
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
	
}
