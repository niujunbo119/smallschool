//拦截器配置
package com.smallschool.controller.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration，标明了该类是一个配置类并且会将该类作为一个SpringBean添加到IOC容器内
@Configuration
public class config extends WebMvcConfigurerAdapter {
    @Bean
    public WebMvcConfigurerAdapter WebMvcAutoConfigurationAdapter()
    {
        WebMvcConfigurerAdapter adapter=new  WebMvcConfigurerAdapter(){
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/snackOrder/toShopCart","/user/info","/service/toOrder").excludePathPatterns("login.html","/","/login","/login");
            }
        };

        return adapter ;
    }
   
}

