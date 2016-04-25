package com.wang.ssm.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.ssm.base.IGenericPage;
import com.wang.ssm.dao.SsmRoleDao;
import com.wang.ssm.model.SsmRole;
import com.wang.ssm.model.SsmRoleExample;
import com.wang.ssm.service.SsmRoleService;

@Service
public class SsmRoleServiceImpl implements SsmRoleService{

	@Autowired
	SsmRoleDao ssmRoleDao ;
	
	@Override
	public IGenericPage<SsmRole> findPage(Integer pageNo, Integer pageSize,SsmRole param , Map<String,Object> map) {
		return ssmRoleDao.findPageBy(param, pageNo, pageSize, map);
	}

	@Override
	public Integer add(SsmRole ssmRole) {
		return ssmRoleDao.insert(ssmRole);
	}

	@Override
	public Integer update(SsmRole ssmRole) {
		return ssmRoleDao.updateByPrimaryKey(ssmRole);
	}

	@Override
	public Integer delete(Integer id) {
		return ssmRoleDao.deleteByPrimaryKey(id);
	}

	@Override
	public SsmRole getById(Integer id) {
		return ssmRoleDao.selectByPrimaryKey(id);
	}

	@Override
	public Integer delete(SsmRoleExample example) {
		return ssmRoleDao.deleteByExample(example);
	}


}
