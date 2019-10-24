/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test2.student.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.test2.student.entity.DemoScore;
import com.thinkgem.jeesite.test2.student.entity.DemoScoreVo;
import com.thinkgem.jeesite.test2.student.service.DemoScoreService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 学分列表Controller
 * @author echoyu
 * @version 2019-10-23
 */
@Controller
@RequestMapping(value = "${adminPath}/student/demoScore")
public class DemoScoreController extends BaseController {

	@Autowired
	private DemoScoreService demoScoreService;
	
	@ModelAttribute
	public DemoScore get(@RequestParam(required=false) String id) {
		DemoScore entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = demoScoreService.get(id);
		}
		if (entity == null){
			entity = new DemoScore();
		}
		return entity;
	}
	
	@RequiresPermissions("student:demoScore:view")
	@RequestMapping(value = {"list", ""})
	public String list(DemoScore demoScore, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DemoScore> page = demoScoreService.findPage(new Page<DemoScore>(request, response), demoScore); 
		model.addAttribute("page", page);
		return "test2/student/demoScoreList";
	}


	@RequiresPermissions("student:demoScore:view")
	@RequestMapping(value = {"list2"})
	public String list2(DemoScoreVo demoScoreVo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DemoScore> page = demoScoreService.findPageByScore(new Page<DemoScore>(request, response), demoScoreVo);
		model.addAttribute("page", page);
		return "test2/student/demoScoreList";
	}

	@RequiresPermissions("student:demoScore:view")
	@RequestMapping(value = "form")
	public String form(DemoScore demoScore, Model model) {
		model.addAttribute("demoScore", demoScore);
		return "test2/student/demoScoreForm";
	}


	@RequiresPermissions("student:demoScore:edit")
	@RequestMapping(value = "save")
	public String save(DemoScore demoScore, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, demoScore)){
			return form(demoScore, model);
		}
		demoScoreService.save(demoScore);
		addMessage(redirectAttributes, "保存学分列表成功");
		return "redirect:"+Global.getAdminPath()+"/student/demoScore/?repage";
	}
	
	@RequiresPermissions("student:demoScore:edit")
	@RequestMapping(value = "delete")
	public String delete(DemoScore demoScore, RedirectAttributes redirectAttributes) {
		demoScoreService.delete(demoScore);
		addMessage(redirectAttributes, "删除学分列表成功");
		return "redirect:"+Global.getAdminPath()+"/student/demoScore/?repage";
	}



}