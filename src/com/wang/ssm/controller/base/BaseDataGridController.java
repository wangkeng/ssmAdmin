package com.wang.ssm.controller.base;

import java.util.HashMap;
import java.util.Map;

import com.wang.ssm.base.IGenericPage;

public abstract class BaseDataGridController extends BaseController {

	// 返回dataGrid需要的格式
	public Map<String, Object> getDataGridMap(IGenericPage<?> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", list.getTotalCount());
		map.put("rows", list.getThisPageElements());
		return map;
	}
}
