package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java1234.model.PageBean;
import com.java1234.model.Goods;
import com.java1234.util.StringUtil;

/**
 * �γ�Dao��
 * @author Administrator
 *
 */
public class GoodsDao {

	/**
	 * �γ���Ϣ��ѯ
	 * @param con
	 * @param pageBean
	 * @param s_course
	 * @return
	 * @throws Exception
	 */
	public List<Goods> courseList(Connection con,PageBean pageBean,Goods s_course)throws Exception{
		List<Goods> courseList=new ArrayList<Goods>();
		StringBuffer sb=new StringBuffer("select * from t_course t1,t_teacher t2 where t1.teacherId=t2.id ");
		if(s_course!=null){
			if(StringUtil.isNotEmpty(s_course.getCourseName())){
				sb.append(" and t1.courseName like '%"+s_course.getCourseName()+"%'");
			}
			if(s_course.getTeacherId()!=null){
				sb.append(" and t1.teacherId="+s_course.getTeacherId());
			}
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Goods course=new Goods();
			course.setId(rs.getInt("id"));
			course.setCourseName(rs.getString("courseName"));
			course.setCredit(rs.getInt("credit"));
			course.setTeacherId(rs.getInt("teacherId"));
			course.setTearchName(rs.getString("trueName"));
			courseList.add(course);

		}
		return courseList;
	}
	
	/**
	 * ��ѯ��¼��
	 * @param con
	 * @param s_course
	 * @return
	 * @throws Exception
	 */
	public int courseCount(Connection con,Goods s_course)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_course t1,t_teacher t2 where t1.teacherId=t2.id ");
		if(s_course!=null){
			if( StringUtil.isNotEmpty(s_course.getCourseName())){
				sb.append(" and t1.courseName like '%"+s_course.getCourseName()+"%'");
			}			
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	/**
	 * �γ����
	 * @param con
	 * @param course
	 * @return
	 * @throws Exception
	 */
	public int courseAdd(Connection con,Goods course)throws Exception{
		String sql="insert into t_course values(null,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, course.getCourseName());
		pstmt.setInt(2, course.getCredit());
		pstmt.setInt(3, course.getTeacherId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * �γ̸���
	 * @param con
	 * @param course
	 * @return
	 * @throws Exception
	 */
	public int courseUpdate(Connection con,Goods course)throws Exception{
		String sql="update t_course set courseName=?,credit=?,teacherId=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, course.getCourseName());
		pstmt.setInt(2, course.getCredit());
		pstmt.setInt(3, course.getTeacherId());
		pstmt.setInt(4, course.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * �γ�ɾ��
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int courseDelete(Connection con,String id)throws Exception{
		String sql="delete from t_course where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * ����ID��ѯ�γ�
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Goods loadCourseById(Connection con,String id)throws Exception{
		String sql="select * from t_course where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		Goods course=new Goods();
		while(rs.next()){
			course.setId(rs.getInt("id"));
			course.setCourseName(rs.getString("courseName"));
			course.setCredit(rs.getInt("credit"));
			course.setTeacherId(rs.getInt("teacherId"));
		}
		return course;
	}
	
	/**
	 * ָ����ʦ�Ƿ������ڿγ�
	 * @param con
	 * @param teacherId
	 * @return
	 * @throws Exception
	 */
	public boolean existCourseWithTeacherId(Connection con,String teacherId)throws Exception{
		String sql="select * from t_course where teacherId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, teacherId);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
}
