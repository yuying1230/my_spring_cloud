package com.lovestory.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial") // 警告压制
@AllArgsConstructor // 全参构造函数
@NoArgsConstructor // 空参构造函数
@Data // 相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Accessors(chain = true) // 链式风格访问
public class Dept implements Serializable {
	private Long deptno;
	private String dname;
	private String db_source;

	public Dept(String dname) {
		super();
		this.dname = dname;
	}

//	public static void main(String[] args) {
//		Dept dept = new Dept();
//		dept.setDeptno(11L).setDname("RD").setDb_source("DB01");
//		System.out.println(dept);
//	}
}
