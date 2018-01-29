package com.java1234.util;

import ASDFramework.src.Singleton.IUtil;

/**
 * �ַ���������
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
	 * �ж��Ƿ��ǿ�
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
	 * �ж��Ƿ��ǿ�
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
