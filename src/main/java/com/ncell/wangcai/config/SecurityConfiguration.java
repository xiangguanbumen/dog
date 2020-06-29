package com.ncell.wangcai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author anliwei
 * @Date 2020/6/28 16:07
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                // 管理员，同事具有 ADMIN,USER权限，可以访问所有资源
                .withUser("admin")
                .password("{noop}123456")
                .roles("ADMIN", "USER")
                .and()
                // 普通用户，只能访问 /product/**
                .withUser("user").password("{noop}123456")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/*").hasRole("USER")
               // .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
        // 关闭CSRF跨域
        http.csrf().disable();
    }
}
