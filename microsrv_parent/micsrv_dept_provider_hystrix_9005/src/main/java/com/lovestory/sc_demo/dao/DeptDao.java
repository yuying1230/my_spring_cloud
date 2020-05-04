package com.lovestory.sc_demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lovestory.springcloud.entities.Dept;

// 关键：springboot整合mybatis需要添加注解 @Mapper -- 重要！！！
@Mapper
public interface DeptDao {
	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
