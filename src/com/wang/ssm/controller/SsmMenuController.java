package com.wang.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.wang.ssm.controller.base.BaseController;
import com.wang.ssm.model.SsmMenu;
import com.wang.ssm.service.SsmMenuService;
import com.wang.ssm.util.WilsonUtil;

@Controller
@RequestMapping("menu")
public class SsmMenuController extends BaseController{

	@Autowired
	SsmMenuService ssmMenuService ;
	
	
	@RequestMapping("listView")
	public String listView(){
		return "menu/list";
	}
	
	@RequestMapping("addView")
	public String addView(HttpServletRequest request , @RequestParam("id")Integer id){
		SsmMenu ssmMenu = ssmMenuService.getById(id);
		request.setAttribute("ssmMenu", ssmMenu);
		return "menu/add";
	}
	@RequestMapping("editView")
	public String editView(HttpServletRequest request, @RequestParam("id")Integer id){
		SsmMenu ssmMenu = ssmMenuService.getById(id);
		request.setAttribute("ssmMenu", ssmMenu);
		return "menu/edit";
	}
	
	@RequestMapping("getFirstData")
	@ResponseBody
	public Object getTreeData(HttpServletRequest request){
		Integer id = Integer.parseInt(request.getParameter("id"));
		Map<String , Object> map = new HashMap<String ,Object>();
		map.put("total", 10);
		List<SsmMenu> list = ssmMenuService.getListById(id); 
		map.put("rows", list);
		return JSON.toJSONString(map) ;
	}
	
	@RequestMapping("getSecondData")
	@ResponseBody
	public Object getData(HttpServletRequest request ,  @RequestParam("id")Integer id){
		List<SsmMenu> list = ssmMenuService.getChildList(id);
		return JSON.toJSONString(list) ;
	}
	
	@RequestMapping("add")
	@ResponseBody
	public Object add(HttpServletRequest request){
		SsmMenu ssmMenu = (SsmMenu) WilsonUtil.parseParam2Object(
				request, new SsmMenu());
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ssmMenu.setCreatetime(simple.format(new Date()));
		ssmMenu.setStatus(1);
		ssmMenuService.add(ssmMenu);
		return JSON.toJSONString("添加成功");
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public Object edit(HttpServletRequest request){
		SsmMenu ssmMenu = (SsmMenu) WilsonUtil.parseParam2Object(
				request, new SsmMenu());
		SsmMenu oldMenu = ssmMenuService.getById(ssmMenu.getId());
		oldMenu.setDescription(ssmMenu.getDescription());
		oldMenu.setName(ssmMenu.getName());
		oldMenu.setLinkurl(ssmMenu.getLinkurl());
		oldMenu.setMenulevel(ssmMenu.getMenulevel());
		oldMenu.setSort(ssmMenu.getSort());
		ssmMenuService.update(oldMenu);
		return JSON.toJSONString("修改成功");
	}
}
