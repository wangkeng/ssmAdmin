package com.wang.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.wang.ssm.base.IGenericPage;
import com.wang.ssm.controller.base.BaseDataGridController;
import com.wang.ssm.model.SsmRole;
import com.wang.ssm.model.SsmRoleExample;
import com.wang.ssm.service.SsmMenuService;
import com.wang.ssm.service.SsmRoleService;
import com.wang.ssm.util.DataUtil;
import com.wang.ssm.util.WilsonUtil;
import com.wang.ssm.vo.TreeVO;

@Controller
@RequestMapping("role")
public class SsmRoleController extends BaseDataGridController {

	@Autowired
	SsmRoleService ssmRoleService;
	@Autowired
	SsmMenuService ssmMenuService;

	@RequestMapping("listView")
	public Object listView() {
		return "role/list";
	}
	
	@RequestMapping("addView")
	public Object addView() {
		return "role/add";
	}
	
	@RequestMapping("updateView")
	public Object updateView(HttpServletRequest request,@RequestParam Integer id){
		request.setAttribute("ssmRole",ssmRoleService.getById(id));
		return "role/update";
	}
	
	@RequestMapping("menuTreeView")
	public Object menuTreeView(HttpServletRequest request,@RequestParam Integer id){
		request.setAttribute("roleId", id);
		return "role/menuTree";
	}

	@RequestMapping("getList")
	@ResponseBody
	public Object getList(HttpServletRequest request,
			@RequestParam Integer page, @RequestParam Integer rows,
			@RequestParam(required=false) String beginTime,@RequestParam(required=false) String endTime) {
		SsmRole param = (SsmRole) WilsonUtil.parseParam2Object(request,
				new SsmRole());
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(beginTime)){
			paramMap.put("beginTime", beginTime);
		}
		if(!StringUtils.isEmpty(endTime)){
			paramMap.put("endTime", endTime);
		}
		paramMap.put("order", "sort");
		IGenericPage<SsmRole> iGenericPage = ssmRoleService.findPage(page,
				rows, param, paramMap);
		Map<String,Object> map = getDataGridMap(iGenericPage);
		return map;
	}

	@RequestMapping("add")
	@ResponseBody
	public Object add(HttpServletRequest request){
		SsmRole ssmRole = (SsmRole) WilsonUtil.parseParam2Object(request,
				new SsmRole());
		ssmRole.setCreatetime(DataUtil.getDateTime());
ssmRole.setCreator(1+"".trim());
		ssmRoleService.add(ssmRole);
		return JSON.toJSONString("添加成功");
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(HttpServletRequest request){
		SsmRole ssmRole = (SsmRole) WilsonUtil.parseParam2Object(request,
				new SsmRole());
		ssmRoleService.update(ssmRole);
		return JSON.toJSONString("修改成功");
	}

	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids){
		String[] strs = ids.split(","); 
		List<Integer> list = new ArrayList<Integer>(strs.length);
		for(String str : strs){
			list.add(Integer.parseInt(str));
		}
		SsmRoleExample example = new SsmRoleExample();
		SsmRoleExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(list);
		ssmRoleService.delete(example);
		return JSON.toJSONString("删除成功");
	}
	
	@RequestMapping("getMenuTree")
	@ResponseBody
	public Object getMenuTree(@RequestParam Integer id){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", -1);
		map.put("rid", id);
		List<TreeVO> treeList = ssmMenuService.getTreeById(map);
		return treeList;
	}
	
	/*public Object changeRoleMenu(@RequestParam String ids){
		String[] strs = ids.split(","); 
		List<Integer> list = new ArrayList<Integer>(strs.length);
		for(String str : strs){
			list.add(Integer.parseInt(str));
		}
	}*/
}
