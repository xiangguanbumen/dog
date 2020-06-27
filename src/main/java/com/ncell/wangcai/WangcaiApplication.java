package com.ncell.wangcai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author anliwei
 *
 * exclude= {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class}
 */
@MapperScan("com.ncell.wangcai.mapper")
@SpringBootApplication()
public class WangcaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WangcaiApplication.class, args);
    }

}
