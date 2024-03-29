/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test2.test.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.test2.test.entity.TestDataCopy;

/**
 * 测试数据生成功能描述:DAO接口
 * @author echoyu
 * @version 2019-10-22
 */
@MyBatisDao
public interface TestDataCopyDao extends CrudDao<TestDataCopy> {
	
}