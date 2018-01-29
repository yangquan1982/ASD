package com.java1234.model;

/**
 * �γ�ʵ����
 * @author Administrator
 *
 */
public class Goods {

	private Integer id; // ���
	private String courseName; // �γ�����
	private Integer credit; // ѧ��
	private Integer teacherId; // �ڿ���ʦId
	private String tearchName;  // �ڿ���ʦ����
	
	
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Goods(String courseName, Integer credit, Integer teacherId) {
		super();
		this.courseName = courseName;
		this.credit = credit;
		this.teacherId = teacherId;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getTearchName() {
		return tearchName;
	}
	public void setTearchName(String tearchName) {
		this.tearchName = tearchName;
	}
	
	
}
