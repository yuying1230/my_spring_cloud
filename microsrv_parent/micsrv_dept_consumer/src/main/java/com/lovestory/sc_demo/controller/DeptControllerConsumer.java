package com.lovestory.sc_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lovestory.springcloud.entities.Dept;

@RestController
public class DeptControllerConsumer {

	// private static final String REST_URL_PREFIX = "http://localhost:9001";
	// 把域名修改成微服务名，按名字访问微服务，这才是标准的微服务访问方式
	private static final String REST_URL_PREFIX = "http://MICSRV-DEPT";

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		String url = REST_URL_PREFIX + "/dept/add";
		return restTemplate.postForObject(url, dept, Boolean.class);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		String url = REST_URL_PREFIX + "/dept/get/" + id;
		return restTemplate.getForObject(url, Dept.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		String url = REST_URL_PREFIX + "/dept/list";
		return restTemplate.getForObject(url, List.class);
	}

	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		String url = REST_URL_PREFIX + "/dept/discovery";
		return restTemplate.getForObject(url, Object.class);
	}
}
