package com.springboot.webapplication.client;

import com.springboot.webapplication.View.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurityConfigurerAdapter {
    UserDao clientService;
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        super.configure(http);
        // allow access to the login view
        setLoginView(http, LoginView.class);
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new InMemoryUserDetailsManager(
                User.withUsername("user")
                        .password("{noop}user")
                        .roles("ADMIN")
                        .build()
        );
    }
}
