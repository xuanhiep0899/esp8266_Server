package com.EspServer.Esp.security;

import com.EspServer.Esp.entities.RoleName;
import com.EspServer.Esp.jwt.AuthTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthTokenFilter authTokenFilter;

    public WebSecurityConfig(AuthTokenFilter authTokenFilter) {
        this.authTokenFilter = authTokenFilter;
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()
                .antMatchers("/","/login").permitAll()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/employees").permitAll()
                .antMatchers(HttpMethod.POST, "/api/account/create-account").permitAll()
                .antMatchers("/api/account/***").authenticated()
                .antMatchers("/api/account/update-account/**").authenticated()
                .antMatchers("api/employee/**").authenticated()
                .and()
                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .defaultSuccessUrl("/api/employees")
                .and()
                .logout();
    }

}
