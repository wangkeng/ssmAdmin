package com.wang.ssm.service;

import java.util.List;
import java.util.Map;

import com.wang.ssm.base.IGenericPage;
import com.wang.ssm.model.SsmMenu;
import com.wang.ssm.vo.TreeVO;


public interface SsmMenuService{

	public IGenericPage<SsmMenu> findPage(Integer pageNo , Integer pageSize);
	
	public Integer add(SsmMenu ssmMenu);
	
	public Integer update(SsmMenu ssmMenu);
	
	public Integer delete(Integer id);

	public SsmMenu getById(Integer id);
	
	public List<SsmMenu> getChildList(Integer id);
	
	public List<SsmMenu> getListById(Integer id);
	
	public List<TreeVO> getTreeById(Map<String,Object> map);
}

