package com.java1234.model;

/**
 * ��ʦʵ��
 * @author Administrator
 *
 */
public class Seller {

	private Integer id; // ���
	private String userName; // �û���
	private String password; // ����
	private String trueName; // ��ʵ����
	private String title; // ְ��
	
	
	
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Seller(String userName, String password, String trueName,
			String title) {
		super();
		this.userName = userName;
		this.password = password;
		this.trueName = trueName;
		this.title = title;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
