/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test2.student.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.test2.student.entity.DemoStudent;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.test2.student.entity.DemoSubject;
import com.thinkgem.jeesite.test2.student.service.DemoSubjectService;

import java.util.List;
import java.util.Map;

/**
 * 科目模块Controller
 * @author echoyu
 * @version 2019-10-23
 */
@Controller
@RequestMapping(value = "${adminPath}/student/demoSubject")
public class DemoSubjectController extends BaseController {

	@Autowired
	private DemoSubjectService demoSubjectService;
	
	@ModelAttribute
	public DemoSubject get(@RequestParam(required=false) String id) {
		DemoSubject entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = demoSubjectService.get(id);
		}
		if (entity == null){
			entity = new DemoSubject();
		}
		return entity;
	}
	
	@RequiresPermissions("student:demoSubject:view")
	@RequestMapping(value = {"list", ""})
	public String list(DemoSubject demoSubject, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DemoSubject> page = demoSubjectService.findPage(new Page<DemoSubject>(request, response), demoSubject); 
		model.addAttribute("page", page);
		return "test2/student/demoSubjectList";
	}

	@RequiresPermissions("student:demoSubject:view")
	@RequestMapping(value = "form")
	public String form(DemoSubject demoSubject, Model model) {
		model.addAttribute("demoSubject", demoSubject);
		return "test2/student/demoSubjectForm";
	}

	@RequiresPermissions("student:demoSubject:edit")
	@RequestMapping(value = "save")
	public String save(DemoSubject demoSubject, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, demoSubject)){
			return form(demoSubject, model);
		}
		demoSubjectService.save(demoSubject);
		addMessage(redirectAttributes, "保存科目模块成功");
		return "redirect:"+Global.getAdminPath()+"/student/demoSubject/?repage";
	}
	
	@RequiresPermissions("student:demoSubject:edit")
	@RequestMapping(value = "delete")
	public String delete(DemoSubject demoSubject, RedirectAttributes redirectAttributes) {
		demoSubjectService.delete(demoSubject);
		addMessage(redirectAttributes, "删除科目模块成功");
		return "redirect:"+Global.getAdminPath()+"/student/demoSubject/?repage";
	}


	/**
	 * 获取科目列表
	 * @param subjectName
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required = false) String subjectName, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		DemoSubject demoSubject = new DemoSubject();
		demoSubject.setSubjectName(subjectName);
		List<DemoSubject> list = demoSubjectService.findList(demoSubject);
		for (int i = 0; i < list.size(); i++) {
			DemoSubject e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("subjectName", e.getSubjectName());
			mapList.add(map);
		}
		return mapList;
	}

}