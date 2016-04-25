package com.wang.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.wang.ssm.base.IGenericPage;
import com.wang.ssm.controller.base.BaseDataGridController;
import com.wang.ssm.model.SsmUser;
import com.wang.ssm.model.SsmUserExample;
import com.wang.ssm.service.SsmUserService;
import com.wang.ssm.util.DataUtil;
import com.wang.ssm.util.MD5Util;
import com.wang.ssm.util.WilsonUtil;

@Controller
@RequestMapping("user")
public class SsmUserController extends BaseDataGridController {

	@Autowired
	SsmUserService ssmUserService;

	@RequestMapping("listView")
	public Object listView() {
		return "user/list";
	}
	
	@RequestMapping("addView")
	public Object addView() {
		return "user/add";
	}
	
	@RequestMapping("updateView")
	public Object updateView(HttpServletRequest request,@RequestParam Integer id){
		request.setAttribute("ssmUser",ssmUserService.getById(id));
		return "user/update";
	}

	@RequestMapping("getList")
	@ResponseBody
	public Object getList(HttpServletRequest request,
			@RequestParam Integer page, @RequestParam Integer rows,
			@RequestParam(required=false) String beginTime,@RequestParam(required=false) String endTime) {
		SsmUser param = (SsmUser) WilsonUtil.parseParam2Object(request,
				new SsmUser());
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(!StringUtils.isEmpty(beginTime)){
			paramMap.put("beginTime", beginTime);
		}
		if(!StringUtils.isEmpty(endTime)){
			paramMap.put("endTime", endTime);
		}
		paramMap.put("order", "createtime desc");
		IGenericPage<SsmUser> iGenericPage = ssmUserService.findPage(page,
				rows, param, paramMap);
		Map<String,Object> map = getDataGridMap(iGenericPage);
		return map;
	}

	@RequestMapping("add")
	@ResponseBody
	public Object add(HttpServletRequest request){
		SsmUser ssmUser = (SsmUser) WilsonUtil.parseParam2Object(request,
				new SsmUser());
		ssmUser.setPassword(new MD5Util().GetMD5Code(ssmUser.getPassword()));
		ssmUser.setCreatetime(DataUtil.getDateTime());
		ssmUserService.add(ssmUser);
		return JSON.toJSONString("添加成功");
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(HttpServletRequest request){
		SsmUser ssmUser = (SsmUser) WilsonUtil.parseParam2Object(request,
				new SsmUser());
		ssmUserService.update(ssmUser);
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
		SsmUserExample example = new SsmUserExample();
		SsmUserExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(list);
		ssmUserService.delete(example);
		return JSON.toJSONString("删除成功");
	}
	
}
