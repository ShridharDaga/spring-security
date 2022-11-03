package com.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

    // add a reference to our security data source
    @Autowired
    private DataSource securityDataSource;

    public DemoSecurityConfig(DataSource theSecurityDataSource) {
        securityDataSource = theSecurityDataSource;
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        return new JdbcUserDetailsManager(securityDataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeRequests(configure ->
                        configure
                                .antMatchers("/").hasRole("EMPLOYEE")
                                .antMatchers("/leaders/**").hasRole("MANAGER")
                                .antMatchers("/systems/**").hasRole("ADMIN"))

                .formLogin(configure ->
                        configure
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll())

                .logout(configure -> configure.permitAll())

                .exceptionHandling(configure -> configure.accessDeniedPage("/access-denied"))

                .build();
    }
}
