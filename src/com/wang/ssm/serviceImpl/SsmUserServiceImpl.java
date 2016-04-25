package com.wang.ssm.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.ssm.base.IGenericPage;
import com.wang.ssm.dao.SsmUserDao;
import com.wang.ssm.model.SsmUser;
import com.wang.ssm.model.SsmUserExample;
import com.wang.ssm.service.SsmUserService;

@Service
public class SsmUserServiceImpl implements SsmUserService{

	@Autowired
	SsmUserDao ssmUserDao ;
	
	@Override
	public IGenericPage<SsmUser> findPage(Integer pageNo, Integer pageSize,SsmUser param , Map<String,Object> map) {
		return ssmUserDao.findPageBy(param, pageNo, pageSize, map);
	}

	@Override
	public Integer add(SsmUser ssmUser) {
		return ssmUserDao.insert(ssmUser);
	}

	@Override
	public Integer update(SsmUser ssmUser) {
		return ssmUserDao.updateByPrimaryKey(ssmUser);
	}

	@Transactional
	@Override
	public Integer delete(Integer id) {
		return ssmUserDao.deleteByPrimaryKey(id);
	}

	@Override
	public SsmUser getById(Integer id) {
		return ssmUserDao.selectByPrimaryKey(id);
	}

	@Override
	public Integer delete(SsmUserExample example) {
		// TODO Auto-generated method stub
		return ssmUserDao.deleteByExample(example);
	}


}
