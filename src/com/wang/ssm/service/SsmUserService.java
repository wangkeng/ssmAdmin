package com.wang.ssm.service;

import java.util.Map;

import com.wang.ssm.base.IGenericPage;
import com.wang.ssm.model.SsmUser;
import com.wang.ssm.model.SsmUserExample;


public interface SsmUserService{

	public IGenericPage<SsmUser> findPage(Integer pageNo , Integer pageSize ,SsmUser param , Map<String,Object> map);
	
	public Integer add(SsmUser ssmUser);
	
	public Integer update(SsmUser ssmUser);
	
	public Integer delete(Integer id);

	public SsmUser getById(Integer id);
	
	public Integer delete(SsmUserExample example);
	
}

