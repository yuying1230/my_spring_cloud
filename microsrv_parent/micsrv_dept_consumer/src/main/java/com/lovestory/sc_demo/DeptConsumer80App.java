package com.lovestory.sc_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.lovestory.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
// 在启动该服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
@RibbonClient(name = "MICSRV-DEPT", configuration = MySelfRule.class)
public class DeptConsumer80App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80App.class, args);
	}

}
