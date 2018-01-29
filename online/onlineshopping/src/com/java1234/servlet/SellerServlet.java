package com.java1234.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ASDFramework.src.Adapter.ResponseAdapter;
import net.sf.json.JSONObject;

import com.java1234.dao.GoodsDao;
import com.java1234.dao.CustomerGoodsDao;
import com.java1234.dao.CustomerDao;
import com.java1234.dao.SellerDao;
import com.java1234.model.Goods;
import com.java1234.model.PageBean;
import com.java1234.model.Customer;
import com.java1234.model.CustomerGoods;
import com.java1234.model.Seller;
import com.java1234.model.User;
import com.java1234.util.DBUtil;
import com.java1234.util.PageUtil;
import com.java1234.util.StringUtil;

/**
 * ��ʦServlet��
 * @author Administrator
 *
 */
public class SellerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DBUtil dbUtil=new DBUtil();
	private SellerDao teacherDao=new SellerDao();
	private GoodsDao courseDao = new GoodsDao();
	private CustomerDao studentDao=new CustomerDao();
	private CustomerGoodsDao studentCourseDao=new CustomerGoodsDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		if("list".equals(action)){
			this.list(request, response);
		}else if("preSave".equals(action)){
			this.preSave(request, response);
		}else if("save".equals(action)){
			this.save(request, response);
		}else if("delete".equals(action)){
			this.delete(request, response);
		}else if("showCourse".equals(action)){
			this.showCourse(request, response);
		}else if("showStudent".equals(action)){
			this.showStudent(request, response);
		}else if("showInfo".equals(action)){
			this.showInfo(request, response);
		}else if("scoreInfo".equals(action)){
			this.scoreInfo(request,response);
		}else if("updateScore".equals(action)){
			this.updateScore(request,response);
		}
	}
	
	/**
	 * ��ʾ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void list(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();
		String page=request.getParameter("page");
		String s_userName=request.getParameter("s_userName");
		Seller s_teacher=new Seller();
		if(StringUtil.isEmpty(page)){
			page="1";
			s_teacher.setUserName(s_userName);
			session.setAttribute("s_teacher", s_teacher);
		}else{
			s_teacher=(Seller) session.getAttribute("s_teacher");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<Seller> teacherList=teacherDao.teacherList(con, pageBean, s_teacher);
			int total=teacherDao.teacherCount(con, s_teacher);
			String pageCode=PageUtil.getPagation(request.getContextPath()+"/teacher?action=list", total, Integer.parseInt(page), 5);
			request.setAttribute("pageCode", pageCode);
			///request.setAttribute("modeName", "��ʦ��Ϣ����");
			request.setAttribute("teacherList", teacherList);
			request.setAttribute("mainPage", "teacher/list.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
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
	 * ����޸�Ԥ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void preSave(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id=request.getParameter("id");
		if(StringUtil.isNotEmpty(id)){
			request.setAttribute("actionName", "Modify Seller Information");
			Connection con=null;
			try{
				con=dbUtil.getCon();
				Seller teacher=teacherDao.loadTeacherById(con, id);
				request.setAttribute("teacher", teacher);
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
		}else{
			request.setAttribute("actionName", "Add Seller Information");
		}
		request.setAttribute("mainPage", "teacher/save.jsp");
		//request.setAttribute("modeName", "��ʦ��Ϣ����");
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}
	
	/**
	 * ����޸Ĳ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void save(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id=request.getParameter("id");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String trueName=request.getParameter("trueName");
		String title=request.getParameter("title");
		Seller teacher=new Seller(userName,password,trueName,title);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			if(StringUtil.isNotEmpty(id)){ // �޸�
				teacher.setId(Integer.parseInt(id));
				teacherDao.teacherUpdate(con, teacher);
			}else{
				teacherDao.teacherAdd(con, teacher);
			}
			response.sendRedirect("teacher?action=list");
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
	 * ɾ������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id=request.getParameter("id");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			if(courseDao.existCourseWithTeacherId(con, id)){
				result.put("errorInfo", "����ʦ�пγ����ڣ�����ɾ����");
			}else{
				teacherDao.teacherDelete(con, id);
				result.put("success", true);				
			}
			new ResponseAdapter(response).write(result);
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
	 * �鿴��ǰ��ʦ�Ŀγ�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showCourse(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();
		User currentUser=(User) session.getAttribute("currentUser");
		Goods s_course=new Goods();
		s_course.setTeacherId(currentUser.getUserId());
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<Goods> courseList=courseDao.courseList(con, null, s_course);
			request.setAttribute("courseList", courseList);
			//request.setAttribute("modeName", "�鿴���ڿγ�");
			request.setAttribute("mainPage", "teacher/courseList.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
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
	 * �鿴��ǰ��ʦ��ѧ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showStudent(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();
		User currentUser=(User) session.getAttribute("currentUser");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<Customer> studentList=studentDao.findStudentsByTeacherId(con, currentUser.getUserId());
			request.setAttribute("studentList", studentList);
			//request.setAttribute("modeName", "�鿴����ѧ��");
			request.setAttribute("mainPage", "teacher/studentList.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
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
	 * �鿴������Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();
		User currentUser=(User) session.getAttribute("currentUser");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			Seller teacher=teacherDao.loadTeacherById(con, String.valueOf(currentUser.getUserId()));
			request.setAttribute("teacher", teacher);
			//request.setAttribute("modeName", "�鿴������Ϣ");
			request.setAttribute("mainPage", "teacher/info.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
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
	 * �鿴��ǰ��ʦ��ѧ��(���ɼ�)
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void scoreInfo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session=request.getSession();
		User currentUser=(User) session.getAttribute("currentUser");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			List<CustomerGoods> studentCourseList=studentCourseDao.findStudentsByTeacherId(con, currentUser.getUserId());
			request.setAttribute("studentCourseList",studentCourseList);
			//request.setAttribute("modeName", "�ɼ�¼��");
			request.setAttribute("mainPage", "teacher/scoreInfo.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
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
	 * �鿴��ǰ��ʦ��ѧ��(���ɼ�)
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateScore(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String score=request.getParameter("score");
		String id=request.getParameter("id");
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int resultNum=studentCourseDao.updateScore(con, Integer.parseInt(score), Integer.parseInt(id));
			JSONObject result=new JSONObject();
			if(resultNum>0){
				result.put("success", true);				
			}else{
				result.put("errorInfo", "Delete Fail!");
			}
			new ResponseAdapter(response).write(result);
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
}
