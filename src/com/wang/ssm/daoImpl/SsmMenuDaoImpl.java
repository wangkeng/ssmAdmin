package com.wang.ssm.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wang.ssm.base.MybatisBaseGenericDAOImpl;
import com.wang.ssm.dao.SsmMenuDao;
import com.wang.ssm.model.SsmMenu;
import com.wang.ssm.model.SsmMenuExample;
import com.wang.ssm.vo.TreeVO;
@Repository
public class SsmMenuDaoImpl extends MybatisBaseGenericDAOImpl<SsmMenuDao,SsmMenu,SsmMenuExample,Integer> implements SsmMenuDao{

	@Override
	public List<SsmMenu>  getChildList(Integer id){
		return getMapper().getChildList(id);
	}

	@Override
	public List<SsmMenu> getListById(Integer id) {
		return getMapper().getListById(id);
	}

	@Override
	public List<TreeVO> getTreeById(Map<String, Object> map) {
		return getMapper().getTreeById(map);
	}

	
}
