package com.lovestory.sc_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.lovestory.springcloud"})
@ComponentScan({"com.lovestory.sc_demo", "com.lovestory.springcloud"})
public class DeptConsumer80App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80App.class, args);
	}

}
