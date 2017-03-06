package com.zous.springworld;

import com.zous.springworld.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhuoxiuwu on 2017/3/6.
 */
@Configuration
@ComponentScan(basePackages="com.zous.springworld")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
    @Bean
    public UserDao getUserDao(){
        return new UserDao();
    }
}
