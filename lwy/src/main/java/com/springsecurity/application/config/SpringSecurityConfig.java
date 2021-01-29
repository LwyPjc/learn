package com.springsecurity.application.config;

import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()  //通过'/'访问的不需要认证
                .anyRequest().authenticated()
                .and()
                .logout().permitAll()  //允许登出
                .and()
                .formLogin();  //允许通过表单登录

        //关闭默认csrf认证
        http.csrf().disable();
    }
}
