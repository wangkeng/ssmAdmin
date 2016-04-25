package com.wang.ssm.dao;

import java.util.List;
import java.util.Map;

import com.wang.ssm.base.IBaseGenericDAO;
import com.wang.ssm.model.SsmMenu;
import com.wang.ssm.model.SsmMenuExample;
import com.wang.ssm.vo.TreeVO;

public interface SsmMenuDao extends IBaseGenericDAO<SsmMenu,SsmMenuExample, Integer>{

	public List<SsmMenu> getChildList(Integer id);
	
	public List<SsmMenu> getListById(Integer id);
	
	public List<TreeVO> getTreeById(Map<String,Object> map);
}
