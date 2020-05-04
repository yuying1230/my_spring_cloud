package com.lovestory.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lovestory.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

// 千万不要忘记在类上面新增@Component注解，否则不起作用 -- 大坑
@Component
public class DeptCientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {

			@Override
			public List<Dept> list() {
				return null;
			}

			@Override
			public Dept get(long id) {
				return new Dept().setDeptno(id).setDname("id:" + id + "没有对应的信息，consumer客户端提供的降级信息，此刻服务provider已经关闭。")
						.setDb_source("no this database in MySQL.");
			}

			@Override
			public Object discovery() {
				return null;
			}

			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}
