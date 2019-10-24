/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test2.student.entity;

import com.thinkgem.jeesite.common.utils.StringUtils;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

import java.math.BigDecimal;

/**
 * 学分列表Entity
 * @author echoyu
 * @version 2019-10-23
 */
public class DemoScore extends DataEntity<DemoScore> {
	
	private static final long serialVersionUID = 1L;
	private DemoStudent demoStudent;		// 学生编号

	private String studentId;		// 学生编号
	private String studentName;		// 学生姓名

	private DemoSubject demoSubject;		// 学生编号

	private String subjectId;		// 科目编号
	private String subjectName;		// 科目名称
	private BigDecimal score;		// 分数
	
	public DemoScore() {
		super();
	}

	public DemoScore(String id){
		super(id);
	}


	public DemoStudent getDemoStudent() {
		return demoStudent;
	}

	public void setDemoStudent(DemoStudent demoStudent) {
		this.demoStudent = demoStudent;
	}

	public DemoSubject getDemoSubject() {
		return demoSubject;
	}

	public void setDemoSubject(DemoSubject demoSubject) {
		this.demoSubject = demoSubject;
	}

	@Length(min=0, max=64, message="学生编号长度必须介于 0 和 64 之间")
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
		if (demoStudent==null){
			demoStudent=new DemoStudent();
			demoStudent.setId(studentId);
		}else if (StringUtils.isEmpty(demoStudent.getId())) {
			demoStudent.setId(studentId);
		}
	}
	
	@Length(min=0, max=255, message="学生姓名长度必须介于 0 和 255 之间")
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
		if (demoStudent==null){
			demoStudent=new DemoStudent();
			demoStudent.setUsername(studentName);
		}else if (StringUtils.isEmpty(demoStudent.getUsername())) {
			demoStudent.setUsername(studentName);
		}
	}
	
	@Length(min=0, max=64, message="科目编号长度必须介于 0 和 64 之间")
	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
		if (demoSubject==null){
			demoSubject=new DemoSubject();
			demoSubject.setId(subjectId);
		}else if (StringUtils.isEmpty(demoSubject.getId())) {
			demoSubject.setId(subjectId);
		}

	}
	
	@Length(min=0, max=64, message="科目名称长度必须介于 0 和 64 之间")
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
		if (demoSubject==null){
			demoSubject=new DemoSubject();
			demoSubject.setSubjectName(subjectName);
		}else if (StringUtils.isEmpty(demoSubject.getSubjectName())) {
			demoSubject.setSubjectName(subjectName);
		}
	}


	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}


}