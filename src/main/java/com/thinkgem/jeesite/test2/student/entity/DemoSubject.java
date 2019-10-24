/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test2.student.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 科目模块Entity
 * @author echoyu
 * @version 2019-10-23
 */
public class DemoSubject extends DataEntity<DemoSubject> {
	
	private static final long serialVersionUID = 1L;
	private String subjectName;		// 科目名称
	
	public DemoSubject() {
		super();
	}

	public DemoSubject(String id){
		super(id);
	}

	@Length(min=0, max=64, message="科目名称长度必须介于 0 和 64 之间")
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
}