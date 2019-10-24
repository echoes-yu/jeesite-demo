/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test2.student.service;

import java.util.List;

import com.thinkgem.jeesite.test2.student.entity.DemoScoreVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.test2.student.entity.DemoScore;
import com.thinkgem.jeesite.test2.student.dao.DemoScoreDao;

/**
 * 学分列表Service
 * @author echoyu
 * @version 2019-10-23
 */
@Service
@Transactional(readOnly = true)
public class DemoScoreService extends CrudService<DemoScoreDao, DemoScore> {

	public DemoScore get(String id) {
		return super.get(id);
	}
	
	public List<DemoScore> findList(DemoScore demoScore) {
		return super.findList(demoScore);
	}
	
	public Page<DemoScore> findPage(Page<DemoScore> page, DemoScore demoScore) {
		return super.findPage(page, demoScore);
	}

	public Page<DemoScore> findPageByScore(Page<DemoScore> page, DemoScoreVo demoScoreVo) {
		demoScoreVo.setPage(page);
		page.setList(dao.findListByScore(demoScoreVo));
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(DemoScore demoScore) {
		super.save(demoScore);
	}
	
	@Transactional(readOnly = false)
	public void delete(DemoScore demoScore) {
		super.delete(demoScore);
	}
	
}