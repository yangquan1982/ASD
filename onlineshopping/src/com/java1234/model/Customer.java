package com.java1234.model;

/**
 * ѧ����
 * @author Administrator
 *
 */
public class Customer {

	private Integer id;  // ���
	private String userName; // �û���
	private String password; // ����
	private String trueName; // ��ʵ����
	private String stuNo; // ѧ��
	private String professional; // רҵ
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Customer(String userName, String password,
			String trueName, String stuNo, String professional) {
		super();
		this.userName = userName;
		this.password = password;
		this.trueName = trueName;
		this.stuNo = stuNo;
		this.professional = professional;
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
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	
	
}
