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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

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
	// 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod，调用类中的指定方法。
	@HystrixCommand(fallbackMethod = "hystrix_process_get")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = service.get(id);
		if (null == dept) {
			throw new RuntimeException("id :" + id + "没有对应信息。");
		}
		return dept;
	}

	public Dept hystrix_process_get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("id:" + id + "没有对应的信息，null -- @HystrixCommand")
				.setDb_source("no this database in MySQL.");
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
