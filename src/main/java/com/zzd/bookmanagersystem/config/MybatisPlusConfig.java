package com.zzd.bookmanagersystem.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 张振东
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 新建一个包：通过@mapperScan注解指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类。PaginationInterceptor是一个分页插件。
 * @date：
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.zzd.bookmanagersystem.mapper")
public class MybatisPlusConfig {
	//分页插件
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		return paginationInterceptor;
	}
}
