package com.wang.ssm.util;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.util.StringUtils;


public class WilsonUtil {
	protected static Logger logger = Logger.getLogger(WilsonUtil.class);
	
	private static ObjectMapper objMapper = new ObjectMapper();
	
	
	public static Object invokeMethod(Object obj, String methodName, Object[] args)
			    throws Exception
	{
	  List clazz = new ArrayList();
	  if ((args != null) && (args.length > 0)) {
	    for (Object arg : args) {
	      clazz.add(arg.getClass());
	    }
	  }
	  return invokeMethod(obj, methodName, clazz, args);
	}
	  
	public static <T> Object invokeMethod(Object obj, String methodName, List<Class<?>> clazz, Object[] args)
			    throws Exception
	{
	  try
	  {
	    return obj.getClass().getDeclaredMethod(methodName, (Class[])clazz.toArray(new Class[clazz.size()])).invoke(obj, args);
	  }
	  catch (NoSuchMethodException e)
	  {
	  }
	
	  return obj.getClass().getMethod(methodName, (Class[])clazz.toArray(new Class[clazz.size()])).invoke(obj, args);
	}
	
	public static <T> String obj2Str(T obj)
	{
		String result = obj2JsonStr(obj);
	    String a = "\"jsonObject\":(\\{\"[^}]+\"\\})";
	    Pattern p = Pattern.compile(a);
	    Matcher m = p.matcher(result);
	    if (m.find()) {
	      result = m.group(0);
	    }
	    return result;
	}
	
	  public static <T> String obj2JsonStr(T t)
	  {
	    StringWriter sw = new StringWriter();
	    try {
	      objMapper.writeValue(sw, t);
	    } catch (Exception e) {
	      logger.error("", e);
	    }
	    return sw.toString();
	  }
	
	  public static <T> T jsonStr2Obj(String str, Class<T> clazz)
	  {
	    if (!StringUtils.isEmpty(str)) {
	      try {
	        return objMapper.readValue(str, clazz);
	      } catch (Exception e) {
	        logger.error("", e);
	      }
	    }
	    return null;
	  }

	  public static <T> T jsonStr2Obj(String str, TypeReference<T> tr)
	  {
	    try
	    {
	      return objMapper.readValue(str, tr);
	    } catch (Exception e) {
	      logger.error("", e);
	    }return null;
	  }
	  
	public static <T> T map2Object(Map map, T t)
	{
		try
	    {
	      ConvertUtils.register(new DateConvert(), Date.class);
	      BeanUtils.populate(t, map);
	    } catch (Exception ex) {
	      logger.error("", ex);
	    }
	    return t;
	 }
	
	
	/**
	 * <b>将httprequest中传入的参数映射成dto对象</b>
	 * 
	 * @param request
	 *            httprequest 对象
	 * @param Object
	 *            需要转换成的dto对象
	 * @return Object
	 */

	public static <T> T parseParam2Object(HttpServletRequest request, T obj) {
		Map requestMap = request.getParameterMap();
		//

		// add to map by obj's field name
		Map map = new HashMap();
		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {
			String name = field.getName();
			Object val = requestMap.get(name);
			if (val != null) {
				map.put(name, val);
			}
		}

		// 当对象为空时返回null
		if (map.size() == 0) {
			return null;
		} else {
			map2Object(map, obj);
			return addVOBaseParam(request, obj);
		}
	}
	
	// 添加2个必填的数据库字段入vo
	public static <T> T addVOBaseParam(HttpServletRequest request, T obj) {

		// add to map by obj's field name
		Map map = new HashMap();

		Date now = new Date();
		Long userId = 0l;
		map.put("createTime", now);
		map.put("lastUpdateTime", now);
		map2Object(map, obj);
		return obj;
	}
	
	  public static String genUUId()
	  {
	    return String.valueOf(UUID.randomUUID());
	  }
	  
	  public static <T> List<T> listNullElmentFilter(T[] arr)
	  {
	    List list = new ArrayList();
	    if (arr == null) {
	      return null;
	    }
	    for (Object t : arr) {
	      if (t != null) {
	        list.add(t);
	      }
	    }
	    return list;
	  }
}
