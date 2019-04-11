package com.example.springboot.config;


import com.example.springboot.interceptor.LoginInterceptor;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Method;

/**
 * 原WebMvcConfigurerAdapter已被废弃，现在改用实现WebMvcConfigurer
 * 接口来添加注册拦截器
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //拦截的路径
        String[] addPathPatterns = {
                "/**"
        };

        //不拦截的路径
        String[] excludePathPatterns = {
                "/index.html",
                "/",
                "/boot/login",
                "/css/**",
                "/js/**",
                "/img/**",
                "/webjars/**"

        };

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }

    /**
     * 设置访问路径的映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("Login");
        registry.addViewController("/index.html").setViewName("Login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new WebLocaleResolver();
    }

    /**
     *
     *自定义keygenerator
     */
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return o;
            }
        };
    }
}
