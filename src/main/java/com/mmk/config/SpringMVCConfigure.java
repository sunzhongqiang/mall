package com.mmk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mmk.common.convert.StringToDate;
import com.mmk.security.service.impl.APISecurityInterceptorAdapter;
/**
 * 对springMVC 的一些常规配置
 * @author 孙中强 sunzhongqiang
 *
 */
@Configuration
public class SpringMVCConfigure  extends WebMvcConfigurerAdapter{


	/**
	 * 增加拦截器
	 */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new APISecurityInterceptorAdapter()).addPathPatterns("/api/**");
    }

    
    /**
     * 添加转化器
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
    	StringToDate converter = new StringToDate();
    	registry.addConverter(converter);
    }
    
    
    
}
