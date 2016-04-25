package com.wang.ssm.daoImpl;

import org.springframework.stereotype.Repository;

import com.wang.ssm.base.MybatisBaseGenericDAOImpl;
import com.wang.ssm.dao.SsmRoleDao;
import com.wang.ssm.model.SsmRole;
import com.wang.ssm.model.SsmRoleExample;
@Repository
public class SsmRoleDaoImpl extends MybatisBaseGenericDAOImpl<SsmRoleDao,SsmRole,SsmRoleExample,Integer> implements SsmRoleDao{

	
}
