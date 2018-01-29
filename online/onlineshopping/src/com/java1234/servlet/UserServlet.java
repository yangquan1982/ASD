package com.java1234.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java1234.dao.ManagerDao;
import com.java1234.dao.CustomerDao;
import com.java1234.dao.SellerDao;
import com.java1234.model.User;
import com.java1234.util.DBUtil;
import com.java1234.util.StringUtil;

/**
 * 锟矫伙拷Servlet锟斤拷
 * @author Administrator
 *
 */
public class UserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DBUtil dbUtil=new DBUtil();
	private ManagerDao managerDao=new ManagerDao();
	private SellerDao teacherDao=new SellerDao();
	private CustomerDao studentDao=new CustomerDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action"); // 锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷
		if("login".equals(action)){
			this.login(request, response);
		}else if("logout".equals(action)){
			this.logout(request, response);
		}
	}
	
	/**
	 * 锟斤拷录锟斤拷证
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String userType=request.getParameter("userType");
		String error="";
		if(StringUtil.isEmpty(userName)){
			error="user name cannot be null";
		}else if(StringUtil.isEmpty(password)){
			error="password cannot be null";
		}else if(StringUtil.isEmpty(userType)){
			error="user type cannot be null";
		}
		User user=new User(userName,password,userType);
		if(StringUtil.isNotEmpty(error)){
			request.setAttribute("user", user);
			request.setAttribute("error", error);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		Connection con=null;
		User currentUser=null;
		try{
			con=dbUtil.getCon();
			if("admin".equals(userType)){
				currentUser=managerDao.login(con, user);
			}else if("seller".equals(userType)){
				currentUser=teacherDao.login(con, user);
			}else if("customer".equals(userType)){
				currentUser=studentDao.login(con, user);
			}
			
			if(currentUser==null){
				error="pls login first";
				request.setAttribute("user", user);
				request.setAttribute("error", error);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}else{
				HttpSession session=request.getSession();
				session.setAttribute("currentUser", currentUser);
				response.sendRedirect("main.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 锟斤拷全锟剿筹拷
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("login.jsp");
	}
	
	

}
