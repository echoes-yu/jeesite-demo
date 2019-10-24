/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test2.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.test2.student.entity.DemoSubject;
import com.thinkgem.jeesite.test2.student.dao.DemoSubjectDao;

/**
 * 科目模块Service
 * @author echoyu
 * @version 2019-10-23
 */
@Service
@Transactional(readOnly = true)
public class DemoSubjectService extends CrudService<DemoSubjectDao, DemoSubject> {

	public DemoSubject get(String id) {
		return super.get(id);
	}
	
	public List<DemoSubject> findList(DemoSubject demoSubject) {
		return super.findList(demoSubject);
	}
	
	public Page<DemoSubject> findPage(Page<DemoSubject> page, DemoSubject demoSubject) {
		return super.findPage(page, demoSubject);
	}
	
	@Transactional(readOnly = false)
	public void save(DemoSubject demoSubject) {
		super.save(demoSubject);
	}
	
	@Transactional(readOnly = false)
	public void delete(DemoSubject demoSubject) {
		super.delete(demoSubject);
	}
	
}