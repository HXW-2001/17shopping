package com.hhsj.Shopping;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by xtnloveyou on 2019/7/22.
 */
@Configuration
public class images implements WebMvcConfigurer{

    public void addResourceHandlers(ResourceHandlerRegistry resourceChainRegistration){
//        resourceChainRegistration.addResourceHandler("/images/**").addResourceLocations("file:/项目/Shopping2/src/main/resources/static/images/");
    }
}
