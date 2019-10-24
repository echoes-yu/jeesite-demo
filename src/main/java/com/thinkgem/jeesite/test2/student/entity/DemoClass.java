/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test2.student.entity;

import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.google.common.collect.Lists;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生班级情况记录Entity
 * @author echoyu
 * @version 2019-10-23
 */
public class DemoClass extends DataEntity<DemoClass> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 班级名称
	private String headTeacher;		// 班主任
	private List<DemoStudent> demoStudentList = Lists.newArrayList();		// 子表列表
	
	public DemoClass() {
		super();
	}

	public DemoClass(String id){
		super(id);
	}

	@Length(min=0, max=255, message="班级名称长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="班主任长度必须介于 0 和 255 之间")
	public String getHeadTeacher() {
		return headTeacher;
	}

	public void setHeadTeacher(String headTeacher) {
		this.headTeacher = headTeacher;
	}
	
	public List<DemoStudent> getDemoStudentList() {
		return demoStudentList;
	}

	public void setDemoStudentList(List<DemoStudent> demoStudentList) {
		this.demoStudentList = demoStudentList;
	}
}