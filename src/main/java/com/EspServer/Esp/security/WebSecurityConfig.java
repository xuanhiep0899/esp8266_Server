package com.EspServer.Esp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/","/login").permitAll()
                .antMatchers(HttpMethod.POST, "/account/**").permitAll()
                .antMatchers(HttpMethod.POST, "/account/").permitAll()
//                .antMatchers(HttpMethod.POST, "/account/abc").permitAll()
                .antMatchers("/employee/create-employee").hasRole("ADMIN")
                .antMatchers("/employee").hasAnyRole("ADMIN", "EMPLOYEE");
    }
}
