package com.wang.ssm.daoImpl;

import org.springframework.stereotype.Repository;

import com.wang.ssm.base.MybatisBaseGenericDAOImpl;
import com.wang.ssm.dao.SsmUserDao;
import com.wang.ssm.model.SsmUser;
import com.wang.ssm.model.SsmUserExample;
@Repository
public class SsmUserDaoImpl extends MybatisBaseGenericDAOImpl<SsmUserDao,SsmUser,SsmUserExample,Integer> implements SsmUserDao{

	
}
