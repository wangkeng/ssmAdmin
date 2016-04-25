package com.wang.ssm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.ssm.base.IGenericPage;
import com.wang.ssm.dao.SsmMenuDao;
import com.wang.ssm.model.SsmMenu;
import com.wang.ssm.service.SsmMenuService;
import com.wang.ssm.vo.TreeVO;

@Service
public class SsmMenuServiceImpl implements SsmMenuService{

	@Autowired
	SsmMenuDao ssmMenuDao ;
	
	@Override
	public IGenericPage<SsmMenu> findPage(Integer pageNo, Integer pageSize) {
		return null;
	}

	@Override
	public Integer add(SsmMenu ssmMenu) {
		return ssmMenuDao.insert(ssmMenu);
	}

	@Override
	public Integer update(SsmMenu ssmMenu) {
		return ssmMenuDao.updateByPrimaryKey(ssmMenu);
	}

	@Override
	public Integer delete(Integer id) {
		return ssmMenuDao.deleteByPrimaryKey(id);
	}

	@Override
	public SsmMenu getById(Integer id) {
		return ssmMenuDao.selectByPrimaryKey(id);
	}

	@Override
	public List<SsmMenu> getChildList(Integer id) {
		return ssmMenuDao.getChildList(id);
	}

	@Override
	public List<SsmMenu> getListById(Integer id) {
		return ssmMenuDao.getListById(id);
	}

	@Override
	public List<TreeVO> getTreeById(Map<String, Object> map) {
		return ssmMenuDao.getTreeById(map);
	}

}
