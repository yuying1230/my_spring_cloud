package com.lovestory.sc_demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovestory.sc_demo.dao.DeptDao;
import com.lovestory.sc_demo.service.DeptService;
import com.lovestory.springcloud.entities.Dept;

@Service
public class DeptServiceImpl implements DeptService {

	// service层使用add、get、list，而不用dao层的addDept、fingById和findAll
	// 是为了尽量符合Rest风格，与controller层贴近
	
	@Autowired
	private DeptDao dao;

	@Override
	public boolean add(Dept dept) {
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return dao.findAll();
	}

}
