package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java1234.model.PageBean;
import com.java1234.model.Seller;
import com.java1234.model.User;
import com.java1234.util.StringUtil;

/**
 * 锟斤拷师Dao锟斤拷
 * @author Administrator
 *
 */
public class SellerDao {

	/**
	 * 锟斤拷师锟斤拷录
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{
		User resultUser=null;
		String sql="select * from t_teacher where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setUserId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
			resultUser.setUserType("seller");
		}
		return resultUser;
	}
	
	/**
	 * 学锟斤拷锟斤拷息锟斤拷询
	 * @param con
	 * @param pageBean
	 * @param s_teacher
	 * @return
	 * @throws Exception
	 */
	public List<Seller> teacherList(Connection con,PageBean pageBean,Seller s_teacher)throws Exception{
		List<Seller> teacherList=new ArrayList<Seller>();
		StringBuffer sb=new StringBuffer("select * from t_teacher ");
		if(s_teacher!=null){
			if( StringUtil.isNotEmpty(s_teacher.getUserName())){
				sb.append(" and userName like '%"+s_teacher.getUserName()+"%'");
			}			
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Seller teacher=new Seller();
			teacher.setId(rs.getInt("id"));
			teacher.setUserName(rs.getString("userName"));
			teacher.setPassword(rs.getString("password"));
			teacher.setTrueName(rs.getString("trueName"));
			teacher.setTitle(rs.getString("title"));
			teacherList.add(teacher);
		}
		return teacherList;
	}
	
	/**
	 * 锟斤拷询锟斤拷录锟斤拷
	 * @param con
	 * @param s_teacher
	 * @return
	 * @throws Exception
	 */
	public int teacherCount(Connection con,Seller s_teacher)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_teacher ");
		if(s_teacher!=null){
			if(StringUtil.isNotEmpty(s_teacher.getUserName())){
				sb.append(" and userName like '%"+s_teacher.getUserName()+"%'");
			}			
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	/**
	 * 学锟斤拷锟斤拷锟�
	 * @param con
	 * @param teacher
	 * @return
	 * @throws Exception
	 */
	public int teacherAdd(Connection con,Seller teacher)throws Exception{
		String sql="insert into t_teacher values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, teacher.getUserName());
		pstmt.setString(2, teacher.getPassword());
		pstmt.setString(3, teacher.getTrueName());
		pstmt.setString(4, teacher.getTitle());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 学锟斤拷锟斤拷锟斤拷
	 * @param con
	 * @param teacher
	 * @return
	 * @throws Exception
	 */
	public int teacherUpdate(Connection con,Seller teacher)throws Exception{
		String sql="update t_teacher set userName=?,password=?,trueName=?,title=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, teacher.getUserName());
		pstmt.setString(2, teacher.getPassword());
		pstmt.setString(3, teacher.getTrueName());
		pstmt.setString(4, teacher.getTitle());
		pstmt.setInt(5, teacher.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 学锟斤拷删锟斤拷
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int teacherDelete(Connection con,String id)throws Exception{
		String sql="delete from t_teacher where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 锟斤拷锟斤拷ID锟斤拷询学锟斤拷
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Seller loadTeacherById(Connection con,String id)throws Exception{
		String sql="select * from t_teacher where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		Seller teacher=new Seller();
		while(rs.next()){
			teacher.setId(rs.getInt("id"));
			teacher.setUserName(rs.getString("userName"));
			teacher.setPassword(rs.getString("password"));
			teacher.setTrueName(rs.getString("trueName"));
			teacher.setTitle(rs.getString("title"));
		}
		return teacher;
	}
	
}
