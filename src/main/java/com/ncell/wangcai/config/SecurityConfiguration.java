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
                .password("{noop}123")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user").password("{noop}123")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/convert/doc").permitAll()
                .antMatchers("/myadmin").permitAll()
                //.antMatchers("/myadmin/**").hasRole("ADMIN")
                //.antMatchers("/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        http.formLogin();
        http.logout().logoutSuccessUrl("/");
        http.rememberMe();

        // 关闭CSRF跨域
        http.csrf().disable();
    }
}
