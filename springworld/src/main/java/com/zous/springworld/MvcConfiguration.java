package com.zous.springworld;

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

}
