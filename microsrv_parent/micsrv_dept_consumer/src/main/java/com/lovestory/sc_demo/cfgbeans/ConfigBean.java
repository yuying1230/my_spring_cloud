package com.lovestory.sc_demo.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

// @Configuration 注解使得该类变成了配置类
// springboot的推荐配置
@Configuration
public class ConfigBean { // @Configuration ConfigBean 等同于 applicationContext.xml

	// <bean id="restTemplate" class="org.springframework.web.client.RestTemplate">
	//客户端访问通过restTemplate，要想访问时自带负载均衡功能，需要添加注解 @LoadBalanced
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
//	@Bean
//	public IRule myRule() {
//		return new RandomRule();  // 达到的目的：用我们重新选择的随机算法替代默认的轮询
//	}
}
