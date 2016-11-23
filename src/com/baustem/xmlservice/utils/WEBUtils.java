package com.baustem.xmlservice.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

public class WEBUtils {
	public static <T> T paramsToBean(HttpServletRequest request,T t){
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * 获取请求地址
	 * @param request
	 * @return
	 */
	public static String getRequestPath(HttpServletRequest request){
		String  requestURI = request.getRequestURI();
		String queryString = request.getQueryString();
		if(queryString.contains("&currentPage")){
			queryString = queryString.substring(0,queryString.indexOf("&currentPage"));
		}
		
		return requestURI+"?"+queryString;
	}


}
