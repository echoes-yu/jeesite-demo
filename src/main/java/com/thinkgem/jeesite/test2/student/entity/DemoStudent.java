/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test2.student.entity;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.utils.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生班级情况记录Entity
 * @author echoyu
 * @version 2019-10-23
 */
public class DemoStudent extends DataEntity<DemoStudent> {
	
	private static final long serialVersionUID = 1L;
	private DemoClass demoClass;		// 班级编号 父类
	private String username;		// 学生姓名
	private String className;		// 班级名称
	private String sex;		// 性别
	private String age;		// 学生年龄
	
	public DemoStudent() {
		super();
	}

	public DemoStudent(String id){
		super(id);
	}

	public DemoStudent(DemoClass demoClass){
		this.demoClass = demoClass;
	}

	public DemoClass getDemoClass() {
			return demoClass;
	}

	public void setDemoClass(DemoClass demoClass) {
		this.demoClass = demoClass;
	}
	
	@Length(min=0, max=255, message="学生姓名长度必须介于 0 和 255 之间")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Length(min=0, max=255, message="班级名称长度必须介于 0 和 255 之间")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	@Length(min=0, max=4, message="性别长度必须介于 0 和 4 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=16, message="学生年龄长度必须介于 0 和 16 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}



	/**
	 * 获取通知发送记录用户ID
	 * @return
	 */
	public String getDemoClassId() {
		return demoClass.getId();
	}

	/**
	 * 设置通知发送记录用户ID
	 * @return
	 */
	public void setDemoClassId(String demoClassId) {
		this.demoClass.setId(demoClassId);
	}

	/**
	 * 获取通知发送记录用户Name
	 * @return
	 */
	public String getDemoClassName() {
		return demoClass.getName();
	}

	/**
	 * 设置通知发送记录用户Name
	 * @return
	 */
	public void setDemoClassName(String oaNotifyRecord) {
		// 什么也不做
	}


}