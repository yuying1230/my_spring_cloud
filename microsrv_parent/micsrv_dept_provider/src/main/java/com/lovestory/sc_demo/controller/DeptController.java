package com.lovestory.sc_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lovestory.sc_demo.service.DeptService;
import com.lovestory.springcloud.entities.Dept;

@RestController
public class DeptController {

	@Autowired
	private DiscoveryClient client;

	@Autowired
	private DeptService service;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		System.out.println("请求参数 request params：" + dept);
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return service.list();
	}

	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("*******" + list);
		List<ServiceInstance> srvList = client.getInstances("MICSRV-DEPT");
		for (ServiceInstance ele : srvList) {
			System.out.println(ele.getServiceId() + "\t" + ele.getHost() + "\t" + ele.getPort() + "\t" + ele.getUri());
		}
		return this.client;
	}
}
