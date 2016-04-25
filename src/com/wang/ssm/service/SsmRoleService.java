package com.wang.ssm.service;

import java.util.Map;

import com.wang.ssm.base.IGenericPage;
import com.wang.ssm.model.SsmRole;
import com.wang.ssm.model.SsmRoleExample;


public interface SsmRoleService{

	public IGenericPage<SsmRole> findPage(Integer pageNo , Integer pageSize ,SsmRole param , Map<String,Object> map);
	
	public Integer add(SsmRole ssmRole);
	
	public Integer update(SsmRole ssmRole);
	
	public Integer delete(Integer id);

	public SsmRole getById(Integer id);
	
	public Integer delete(SsmRoleExample example);
	
}

