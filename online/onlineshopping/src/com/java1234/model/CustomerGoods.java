package com.java1234.model;

/**
 * ѧ���γ̹�����
 * @author Administrator
 *
 */
public class CustomerGoods {

	private Integer id; // ���
	private Integer studentId; // ѧ�����
	private String studentName; // ѧ������
	private Integer courseId; // �γ̱��
	private String courseName; // �γ�����
	private Integer credit; // �γ�ѧ��
	private Integer score; // �γ̳ɼ�
	
	private String teacherName; // �ڿ���ʦ
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
	
	
}
