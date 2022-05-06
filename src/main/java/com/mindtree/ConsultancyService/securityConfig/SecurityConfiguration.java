package com.mindtree.ConsultancyService.securityConfig;
import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.authorizeRequests().antMatchers("authUser").permitAll();
        http.authorizeRequests().antMatchers("/employees").fullyAuthenticated();
        http.authorizeRequests().antMatchers("/employees/**").fullyAuthenticated();
        http.authorizeRequests().antMatchers("/employer").fullyAuthenticated();
        http.authorizeRequests().antMatchers("/employer/**").fullyAuthenticated();
        http.httpBasic();
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//    	auth.inMemoryAuthentication()
//    	    .withUser("Anuj")
//    	        .password("123aj321");
//    	        
//    }
}