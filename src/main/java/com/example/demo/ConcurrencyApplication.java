package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ConcurrencyApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyApplication.class, args);
    }

    // 过滤器实例注册
    @Bean
    public FilterRegistrationBean httpFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        // 注册自定义过滤器
        registrationBean.setFilter(new HttpFilter());
        // 设置需要拦截的URL
        registrationBean.addUrlPatterns("/threadLocal/*");
        // 可以通过setOrder()设置优先级，越低越优先
        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器，指定拦截器要拦截的请求
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
    }
}
