package com.zzd.bookmanagersystem.config;


import com.zzd.bookmanagersystem.handle.LoginHandlerInterceptor;
import com.zzd.bookmanagersystem.handle.MyLocalResolver;
import com.zzd.bookmanagersystem.handle.UserLoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date：
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		浏览器发送/请求发送到success.html
		registry.addViewController("/admin.html").setViewName("admin");
		registry.addViewController("/index.html").setViewName("index");
		registry.addViewController("/main.html").setViewName("dashboard");
		registry.addViewController("/register.html").setViewName("register");
		registry.addViewController("/header.html").setViewName("header");
		registry.addViewController("/footer.html").setViewName("footer");
		registry.addViewController("/login.html").setViewName("login");
		registry.addViewController("/book_list.html").setViewName("book_list");


	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/asserts/img/**").addResourceLocations("file:D:/360MoveData/Users/张振东/Desktop/图书管理系统/bookmanagersystem/src/main/resources/static/asserts/img/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		2.0以前不会过滤.css，.js
		registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin.html","/","/login.html","/register.html", "/webjars/**", "/asserts/**", "/js/**", "/css/**");
		registry.addInterceptor(new UserLoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin.html","/", "/webjars/**", "/asserts/**", "/js/**", "/css/**");
	}


	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocalResolver();
	}

}
