package com.lovestory.sc_demo.service;

import java.util.List;

import com.lovestory.springcloud.entities.Dept;

public interface DeptService {
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
