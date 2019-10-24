/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test2.student.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.test2.student.entity.DemoScore;
import com.thinkgem.jeesite.test2.student.entity.DemoScoreVo;

import java.util.List;

/**
 * 学分列表DAO接口
 * @author echoyu
 * @version 2019-10-23
 */
@MyBatisDao
public interface DemoScoreDao extends CrudDao<DemoScore> {

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     * @param demoScoreVo
     * @return
     */
    public List<DemoScore> findListByScore(DemoScoreVo demoScoreVo);
	
}