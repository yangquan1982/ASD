package com.java1234.util;

import ASDFramework.src.Singleton.IUtil;

/**
 * ��ҳ������
 * @author Administrator
 *
 */
public class PageUtil implements IUtil {
	private static PageUtil instance = null;
	@Override
	public IUtil getInstance() {
		if(instance != null) return instance;
		return new PageUtil();
	}
	/**
	 * ��ȡ��ҳ����
	 * @param targetUrl Ŀ���ַ
	 * @param totalNum �ܼ�¼��
	 * @param currentPage ��ǰҳ
	 * @param pageSize ÿҳ��С
	 * @return
	 */
	public static String getPagation(String targetUrl,int totalNum,int currentPage,int pageSize){
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		if(totalPage==0){
			return "<font color=red>data not found!</font>";
		}
		StringBuffer pageCode=new StringBuffer();
		pageCode.append("<li><a href='"+targetUrl+"&page=1'>First Page</a></li>");
		if(currentPage==1){
			pageCode.append("<li class='disabled'><a href='#'>Previous</a></li>");
		}else{
			pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage-1)+"'>Previous</a></li>");
		}
		
		for(int i=currentPage-2;i<=currentPage+2;i++){
			if(i<1 || i>totalPage){
				continue;
			}
			if(i==currentPage){
				pageCode.append("<li class='active'><a href='#'>"+i+"</a></li>");
			}else{
				pageCode.append("<li><a href='"+targetUrl+"&page="+i+"'>"+i+"</a></li>");
			}
			
		}
		
		if(currentPage==totalPage){
			pageCode.append("<li class='disabled'><a href='#'>Next</a></li>");
		}else{
			pageCode.append("<li><a href='"+targetUrl+"&page="+(currentPage+1)+"'>Next</a></li>");
		}
		pageCode.append("<li><a href='"+targetUrl+"&page="+totalPage+"'>Last Page</a></li>");
		return pageCode.toString();
	}
}
