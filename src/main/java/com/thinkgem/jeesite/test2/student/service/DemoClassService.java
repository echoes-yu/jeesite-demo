/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test2.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.test2.student.entity.DemoClass;
import com.thinkgem.jeesite.test2.student.dao.DemoClassDao;
import com.thinkgem.jeesite.test2.student.entity.DemoStudent;
import com.thinkgem.jeesite.test2.student.dao.DemoStudentDao;

/**
 * 学生班级情况记录Service
 * @author echoyu
 * @version 2019-10-23
 */
@Service
@Transactional(readOnly = true)
public class DemoClassService extends CrudService<DemoClassDao, DemoClass> {

	@Autowired
	private DemoStudentDao demoStudentDao;
	
	public DemoClass get(String id) {
		DemoClass demoClass = super.get(id);
		demoClass.setDemoStudentList(demoStudentDao.findList(new DemoStudent(demoClass)));
		return demoClass;
	}
	
	public List<DemoClass> findList(DemoClass demoClass) {
		return super.findList(demoClass);
	}
	
	public Page<DemoClass> findPage(Page<DemoClass> page, DemoClass demoClass) {
		return super.findPage(page, demoClass);
	}
	
	@Transactional(readOnly = false)
	public void save(DemoClass demoClass) {
		super.save(demoClass);
		for (DemoStudent demoStudent : demoClass.getDemoStudentList()){
			if (demoStudent.getId() == null){
				continue;
			}
			if (DemoStudent.DEL_FLAG_NORMAL.equals(demoStudent.getDelFlag())){
				if (StringUtils.isBlank(demoStudent.getId())){
					demoStudent.setDemoClass(demoClass);
					demoStudent.preInsert();
					demoStudentDao.insert(demoStudent);
				}else{
					demoStudent.preUpdate();
					demoStudentDao.update(demoStudent);
				}
			}else{
				demoStudentDao.delete(demoStudent);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(DemoClass demoClass) {
		super.delete(demoClass);
		demoStudentDao.delete(new DemoStudent(demoClass));
	}
	
}