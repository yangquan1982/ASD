package com.java1234.util;

import ASDFramework.src.Singleton.IUtil;

/**
 * 字符串工具类
 * @author 
 *
 */
public class StringUtil implements IUtil{
	private static StringUtil instance = null;
	@Override
	public IUtil getInstance() {
		if(instance != null) return instance;
		return new StringUtil();
	}

	/**
	 * 判断是否是空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断是否不是空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if((str!=null)&&!"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
}
