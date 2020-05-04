package com.lovestory.sc_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 1、错误原因： 由于服务网关相当于现实中的看门保安，所有的请求服务都要经过zuul这里
 * zuul根据请求服务的服务IP地址去到eureka中心去找这个服务IP地址的服务实例
 * 如果有，则允许访问，如果没有则不允许，并且我们的服务网关子模块程序是没有在application.yml配置数据源等信息的
 * 错就错在这，因为@SpringBootApplication，注解里面有个@EnableAutoConfiguration，它会把springboot默认自动配置的datasources配置进来
 * 而我们没有配置，所以这里我们要排除自动配置DataSourceAutoConfiguration.class。
 * 2、解决办法：在@SpringBootApplication注解里排除DataSourceAutoConfiguration.class的自动配置即可。
 * 重新再次启动即可。
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableZuulProxy
public class ZuulGateway9010App {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGateway9010App.class, args);
	}
}
