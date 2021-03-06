package com.wang.ssm.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.wang.ssm.util.BeanMapUtil;
import com.wang.ssm.util.ReflectGenericUtil;

/**
 * 基于Mybatis的基�?��型DAO实现类�?
 * 
 * 
 * @param <T>
 *            业务实体类型
 * @param <ID>
 *            ID类型 ，如：String、Long、Integer �?
 */
@SuppressWarnings("unchecked")
public abstract class MybatisBaseGenericDAOImpl<TDAO,T,TExample, ID extends Serializable>
		extends SqlSessionDaoSupport implements IBaseGenericDAO<T,TExample, ID> {

	
	public static final String SQL_COUNTBYEXAMPLE = "countByExample";
	public static final String SQL_DELETEBYEXAMPLE = "deleteByExample";
	public static final String SQL_DELETEBYPRIMARYKEY = "deleteByPrimaryKey";
	public static final String SQL_INSERT = "insert";
	public static final String SQL_INSERTSELECTIVE = "insertSelective";
	public static final String SQL_SELECTBYEXAMPLE = "selectByExample";
	public static final String SQL_SELECTBYPRIMARYKEY = "selectByPrimaryKey";
	public static final String SQL_UPDATEBYEXAMPLESELECTIVE = "updateByExampleSelective";
	public static final String SQL_UPDATEBYEXAMPLE = "updateByExample";
	public static final String SQL_UPDATEBYPRIMARYKEYSELECTIVE = "updateByPrimaryKeySelective";
	public static final String SQL_UPDATEBYPRIMARYKEY = "updateByPrimaryKey";
	public static final String SQL_FINDPAGEBY = "findPageBy";
	public static final String SQLNAME_SEPARATOR = ".";
	public static final String SQL_FINDLISTBY = "findListBy";
	/** 不能用于SQL中的非法字符（主要用于排序字段名�?*/
	public static final String[] ILLEGAL_CHARS_FOR_SQL = { ",", ";", " ", "\"",
			"%" };

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	//获取传入mapper
	protected TDAO getMapper(){
		return this.getSqlSession().getMapper(getClassType());
	}
	
	//获取传入mapper类型（即DAO类）
	public Class<TDAO> getClassType(){
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		return(Class<TDAO>) pt.getActualTypeArguments()[0];
	}
	
	protected String getSqlName(String sqlName) {
		return (sqlNamespace + SQLNAME_SEPARATOR + sqlName).replace(
				"pojo", "dao"); 
	}

	  //SqlMapping命名空间
	private String sqlNamespace = getDefaultSqlNamespace();

	  // 获取SqlMapping命名空间
	public String getSqlNamespace() {
		return sqlNamespace;
	}

	/**
	  设置SqlMapping命名空间�?此方法只用于注入SqlMapping命名空间，以改变默认的SqlMapping命名空间�?
	 不能滥用此方法随意改变SqlMapping命名空间�?
	  
	  @param sqlNamespace
	             SqlMapping命名空间
	 **/
	public void setSqlNamespace(String sqlNamespace) {
		this.sqlNamespace = sqlNamespace;
	}

	/**
	 * 获取默认SqlMapping命名空间�?使用泛型参数中业务实体类型的全限定名作为默认的命名空间�?
	 * 如果实际应用中需要特殊的命名空间，可由子类重写该方法实现自己的命名空间规则�?
	 * 
	 * @return 返回命名空间字符�?
	 */ 
	protected String getDefaultSqlNamespace() {
		Class<T> clazz = ReflectGenericUtil.getClassGenricType(this.getClass());
		String nameSpace = clazz.getName();
		return nameSpace;
	}

	 /**
	 * 将SqlMapping命名空间与给定的SqlMapping名组合在�?���?
	 * 
	 * @param sqlName
	 *            SqlMapping�?
	 * @return 组合了SqlMapping命名空间后的完整SqlMapping�?
	 *//*
	
	
	
	*/
	
	
	
	
	 /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    
	
	public int countByExample(TExample example){
    	 return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).countByExample(example);
    };

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    
	public int deleteByExample(TExample example){
    	return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).deleteByExample(example);
    };

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    public int deleteByPrimaryKey(Integer id){
    	return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).deleteByPrimaryKey(id);
    };

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    public int insert(T record){
    	return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).insert(record);
    };

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
     public int insertSelective(T record){
    	 return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).insertSelective(record);
     };

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    public List<T> selectByExample(TExample example){
    	return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).selectByExample(example);
    };

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    public T selectByPrimaryKey(Integer id){
    	return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).selectByPrimaryKey(id);
    };

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    public int updateByExampleSelective(@Param("record") T record, @Param("example") TExample example){
    	return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).updateByExampleSelective(record,example);
    };

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    public int updateByExample(@Param("record") T record, @Param("example") TExample example){
    	return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).updateByExample(record,example);
    };

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    public int updateByPrimaryKeySelective(T record){
    	return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).updateByPrimaryKeySelective(record);
    };

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    public int updateByPrimaryKey(T record){
    	return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).updateByPrimaryKey(record);
    };

    public int getCount(Map<String,Object> map){
    	return ((IBaseGenericDAO<T, TExample, Integer>)getMapper()).getCount(map);
    }
	
	
	@Override
	public IGenericPage<T> findPageBy(T param, int pageNo, int pageSize,
			Map<String, Object> map) {

		Map<String, Object> paramMap = null;
		try {
			paramMap = BeanMapUtil.bean2Map(param);
		} catch (Exception e) {
			throw new BaseDaoException("获取参数失败", e);
		}
		// 其他可能传�?进来的参�?
		if (map!=null&&map.size() > 0) {
			for (String key : map.keySet()) {
				paramMap.put(key, map.get(key));
			}
		}
		// 获取满足条件的记录�?数，没有记录时返回空页数�?
		int count = getCount(paramMap);
		if (count < 1) {
			return GenericDefaultPage.emptyPage();
		}
		// 分页条件
		int start = GenericDefaultPage.getStartOfPage(pageNo, pageSize) - 1;
		RowBounds rowBound = new RowBounds(start, pageSize);

		List<T> lst = this.getSqlSession().selectList(
				getSqlName(SQL_FINDPAGEBY), paramMap, rowBound);

		return new GenericDefaultPage<T>(pageNo, pageSize, lst, count);
	}
	
	
	@Override
	public List<T> findListBy(T param, Map<String, Object> map) {
		Map<String, Object> paramMap = null;
		try {
			paramMap = BeanMapUtil.bean2Map(param);
		} catch (Exception e) {
			throw new BaseDaoException("获取参数失败", e);
		}
		if(map!=null&&map.size()>0){
			for(String key : map.keySet()){
				paramMap.put(key, map.get(key));
			}
		}
		List<T> lst = this.getSqlSession().selectList(
				getSqlName(SQL_FINDLISTBY), paramMap);
		return lst;
	}
	
	
	
	/*public Integer save(T ob) {
		return this.getSqlSession().insert(getSqlName(SQL_SAVE), ob);
	}

	public Integer update(T ob) {
		return this.getSqlSession().update(getSqlName(SQL_UPDATE), ob);
	}

	@SuppressWarnings("unchecked")
	public T getById(ID id) {
		return (T) this.getSqlSession().selectOne(getSqlName(SQL_GETBYID), id);
	}

	public Integer deleteByIds(ID[] ids) {
		return this.getSqlSession().delete(getSqlName(SQL_DELETEBYIDS), ids);
	}

	public Integer deleteById(ID id) {
		return this.getSqlSession().delete(getSqlName(SQL_DELETEBYID), id);
	}

	@SuppressWarnings("unchecked")

	// 获取总共条数
	@SuppressWarnings("unchecked")
	public Integer getCountBy(T param) {
		Map<String, Object> paramMap = null;
		try {
			paramMap = BeanMapUtil.bean2Map(param);
		} catch (Exception e) {
			throw new BaseDaoException("获取参数失败", e);
		}
		return (Integer) this.getSqlSession().selectOne(
				getSqlName(SQL_GETCOUNTBY), paramMap);
	}

	// 不分页查�?
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListBy(T param, Map<String, Object> map) {
		Map<String, Object> paramMap = null;
		try {
			paramMap = BeanMapUtil.bean2Map(param);
		} catch (Exception e) {
			throw new BaseDaoException("获取参数失败", e);
		}
		if(map!=null&&map.size()>0){
			for(String key : map.keySet()){
				paramMap.put(key, map.get(key));
			}
		}
		List<T> lst = this.getSqlSession().selectList(
				getSqlName(SQL_FINDLISTBY), paramMap);
		return lst;
	}

	public List<T> findListBy(T param) {
		return findListBy(param, null);
	}

	*//**
	 * 从给定字符串中将指定的非法字符串数组中各字符串过滤掉�?
	 * 
	 * @param str
	 *            待过滤的字符�?
	 * @param filterChars
	 *            指定的非法字符串数组
	 * @return 过滤后的字符�?
	 *//*
	protected String filterIllegalChars(String str, String[] filterChars) {
		String rs = str;
		if (rs != null && filterChars != null) {
			for (String fc : filterChars) {
				if (fc != null && fc.length() > 0) {
					str = str.replaceAll(fc, "");
				}
			}
		}
		return rs;
	}*/

	/**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#insert(java.lang.String, java.lang.Object)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param parameter
	 *            参数
	 * @return 执行结果—�?插入成功的记录数
	 * @see org.apache.ibatis.session.SqlSession#insert(java.lang.String,
	 *      java.lang.Object)
	 */
	/*
	 * protected int insert(String statement, Object parameter) { return
	 * this.getSqlSession().insert( getSqlName(statement), parameter); }
	 *//**
	 * 对{@link org.apache.ibatis.session.SqlSession#insert(java.lang.String)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @return 执行结果—�?插入成功的记录数
	 * @see org.apache.ibatis.session.SqlSession#insert(java.lang.String)
	 */
	/*
	 * protected int insert(String statement) { return
	 * this.getSqlSession().insert( getSqlName(statement)); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#update(java.lang.String, java.lang.Object)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param parameter
	 *            参数
	 * @return 执行结果—�?更新成功的记录数
	 * @see org.apache.ibatis.session.SqlSession#update(java.lang.String,
	 *      java.lang.Object)
	 */
	/*
	 * protected int update(String statement, Object parameter) { return
	 * this.getSqlSession().update( getSqlName(statement), parameter); }
	 *//**
	 * 对{@link org.apache.ibatis.session.SqlSession#update(java.lang.String)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param parameter
	 *            参数
	 * @return 执行结果—�?更新成功的记录数
	 * @see org.apache.ibatis.session.SqlSession#update(java.lang.String)
	 */
	/*
	 * protected int update(String statement) { return
	 * this.getSqlSession().update( getSqlName(statement)); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#delete(java.lang.String, java.lang.Object)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param parameter
	 *            参数
	 * @return 执行结果—�?删除成功的记录数
	 * @see org.apache.ibatis.session.SqlSession#delete(java.lang.String,
	 *      java.lang.Object)
	 */
	/*
	 * protected int delete(String statement, Object parameter) { return
	 * this.getSqlSession().delete( getSqlName(statement), parameter); }
	 *//**
	 * 对{@link org.apache.ibatis.session.SqlSession#delete(java.lang.String)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @return 执行结果—�?删除成功的记录数
	 * @see org.apache.ibatis.session.SqlSession#delete(java.lang.String)
	 */
	/*
	 * protected int delete(String statement) { return
	 * this.getSqlSession().delete( getSqlName(statement)); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#selectList(java.lang.String, java.lang.Object, org.apache.ibatis.session.RowBounds)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param parameter
	 *            参数
	 * @param rowBounds
	 *            用于分页查询的记录范�?
	 * @return 查询结果列表
	 * @see org.apache.ibatis.session.SqlSession#selectList(java.lang.String,
	 *      java.lang.Object, org.apache.ibatis.session.RowBounds)
	 */
	/*
	 * protected List selectList( String statement, Object parameter, RowBounds
	 * rowBounds) { return this.getSqlSession().selectList(
	 * getSqlName(statement), parameter, rowBounds); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#selectList(java.lang.String, java.lang.Object)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param parameter
	 *            参数
	 * @return 查询结果列表
	 * @see org.apache.ibatis.session.SqlSession#selectList(java.lang.String,
	 *      java.lang.Object)
	 */
	/*
	 * protected List selectList(String statement, Object parameter) { return
	 * this.getSqlSession().selectList( getSqlName(statement), parameter); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#selectList(java.lang.String)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @return 查询结果列表
	 * @see org.apache.ibatis.session.SqlSession#selectList(java.lang.String)
	 */
	/*
	 * protected List selectList(String statement) { return
	 * this.getSqlSession().selectList( getSqlName(statement)); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#selectOne(java.lang.String, java.lang.Object)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param parameter
	 *            参数
	 * @return 查询结果对象
	 * @see org.apache.ibatis.session.SqlSession#selectOne(java.lang.String,
	 *      java.lang.Object)
	 */
	/*
	 * protected Object selectOne(String statement, Object parameter) { return
	 * this.getSqlSession().selectOne( getSqlName(statement), parameter); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#selectOne(java.lang.String)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @return 查询结果对象
	 * @see org.apache.ibatis.session.SqlSession#selectOne(java.lang.String)
	 */
	/*
	 * protected Object selectOne(String statement) { return
	 * this.getSqlSession().selectOne( getSqlName(statement)); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#selectMap(java.lang.String, java.lang.Object, java.lang.String, org.apache.ibatis.session.RowBounds)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param parameter
	 *            参数
	 * @param mapKey
	 *            数据mapKey
	 * @param rowBounds
	 *            用于分页查询的记录范�?
	 * @return 查询结果Map
	 * @see org.apache.ibatis.session.SqlSession#selectMap(java.lang.String,
	 *      java.lang.Object, java.lang.String,
	 *      org.apache.ibatis.session.RowBounds)
	 */
	/*
	 * protected Map selectMap( String statement, Object parameter, String
	 * mapKey, RowBounds rowBounds) { return this.getSqlSession().selectMap(
	 * getSqlName(statement), parameter, mapKey, rowBounds); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#selectMap(java.lang.String, java.lang.Object, java.lang.String)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param parameter
	 *            参数
	 * @param mapKey
	 *            数据mapKey
	 * @return 查询结果Map
	 * @see org.apache.ibatis.session.SqlSession#selectMap(java.lang.String,
	 *      java.lang.Object, java.lang.String)
	 */
	/*
	 * protected Map selectMap( String statement, Object parameter, String
	 * mapKey) { return this.getSqlSession().selectMap( getSqlName(statement),
	 * parameter, mapKey); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#selectMap(java.lang.String, java.lang.String)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param mapKey
	 *            数据mapKey
	 * @return 查询结果Map
	 * @see org.apache.ibatis.session.SqlSession#selectMap(java.lang.String,
	 *      java.lang.String)
	 */
	/*
	 * protected Map selectMap(String statement, String mapKey) { return
	 * this.getSqlSession().selectMap( getSqlName(statement), mapKey); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#select(java.lang.String, java.lang.Object, org.apache.ibatis.session.RowBounds, org.apache.ibatis.session.ResultHandler)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param parameter
	 *            参数
	 * @param rowBounds
	 *            用于分页查询的记录范�?
	 * @param handler
	 *            结果集处理器
	 * @see org.apache.ibatis.session.SqlSession#select(java.lang.String,
	 *      java.lang.Object, org.apache.ibatis.session.RowBounds,
	 *      org.apache.ibatis.session.ResultHandler)
	 */
	/*
	 * protected void select( String statement, Object parameter, RowBounds
	 * rowBounds, ResultHandler handler) { this.getSqlSession().select(
	 * getSqlName(statement), parameter, rowBounds, handler); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#select(java.lang.String, java.lang.Object, org.apache.ibatis.session.ResultHandler)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param parameter
	 *            参数
	 * @param handler
	 *            结果集处理器
	 * @see org.apache.ibatis.session.SqlSession#select(java.lang.String,
	 *      java.lang.Object, org.apache.ibatis.session.ResultHandler)
	 */
	/*
	 * protected void select( String statement, Object parameter, ResultHandler
	 * handler) { this.getSqlSession().select( getSqlName(statement), parameter,
	 * handler); }
	 *//**
	 * �?
	 * {@link org.apache.ibatis.session.SqlSession#select(java.lang.String, org.apache.ibatis.session.ResultHandler)}
	 * 的代理�? 将statement包装了命名空间，方便DAO子类调用�?
	 * 
	 * @param statement
	 *            映射的语句ID
	 * @param handler
	 *            结果集处理器
	 * @see org.apache.ibatis.session.SqlSession#select(java.lang.String,
	 *      org.apache.ibatis.session.ResultHandler)
	 */
	/*
	 * protected void select(String statement, ResultHandler handler) {
	 * this.getSqlSession().select( getSqlName(statement), handler); }
	 */
}
