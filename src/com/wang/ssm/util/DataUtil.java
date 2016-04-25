package com.wang.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	public static String getDateTime(){
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  return df.format(new Date());
	}
}
