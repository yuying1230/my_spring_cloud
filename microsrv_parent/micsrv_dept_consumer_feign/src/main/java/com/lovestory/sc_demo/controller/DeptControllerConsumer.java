package com.lovestory.sc_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovestory.springcloud.entities.Dept;
import com.lovestory.springcloud.service.DeptClientService;

@RestController
public class DeptControllerConsumer {

	@Autowired
	private DeptClientService service;

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return service.add(dept);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return service.list();
	}

	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery() {
		return service.discovery();
	}
}
