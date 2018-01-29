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
import com.java1234.dao.SellerDao;
import com.java1234.model.Goods;
import com.java1234.model.PageBean;
import com.java1234.model.Seller;
import com.java1234.model.User;
import com.java1234.util.DBUtil;
import com.java1234.util.PageUtil;
import com.java1234.util.StringUtil;

/**
 * �γ�Servlet��
 * 
 * @author Administrator
 * 
 */
public class GoodsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DBUtil dbUtil = new DBUtil();
	private GoodsDao courseDao = new GoodsDao();
	private SellerDao teacherDao = new SellerDao();
	private CustomerGoodsDao studentCourseDao=new CustomerGoodsDao();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if ("list".equals(action)) {
			this.list(request, response);
		} else if ("preSave".equals(action)) {
			this.preSave(request, response);
		} else if ("save".equals(action)) {
			this.save(request, response);
		} else if ("delete".equals(action)) {
			this.delete(request, response);
		}
	}

	/**
	 * ��ʾ����
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currentUser=(User) session.getAttribute("currentUser");
		String page = request.getParameter("page");
		String s_courseName = request.getParameter("s_courseName");
		Goods s_course = new Goods();
		if (StringUtil.isEmpty(page)) {
			page = "1";
			s_course.setCourseName(s_courseName);
			s_course.setTeacherId(currentUser.getUserId());
			session.setAttribute("s_course", s_course);
		} else {
			s_course = (Goods) session.getAttribute("s_course");
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			List<Goods> courseList = courseDao.courseList(con, pageBean,
					s_course);
			int total = courseDao.courseCount(con, s_course);
			String pageCode = PageUtil.getPagation(request.getContextPath()
					+ "/course?action=list", total, Integer.parseInt(page), 10);
			request.setAttribute("pageCode", pageCode);
			//request.setAttribute("modeName", "�γ���Ϣ����");
			request.setAttribute("courseList", courseList);
			request.setAttribute("mainPage", "course/list.jsp");
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void preSave(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			if (StringUtil.isNotEmpty(id)) {
				request.setAttribute("actionName", "Goods Inforamtion Modify");
				Goods course = courseDao.loadCourseById(con, id);
				request.setAttribute("course", course);
			} else {
				request.setAttribute("actionName", "Add goods information");
			}
			
			List<Seller> teacherList=teacherDao.teacherList(con, null, null);
			request.setAttribute("teacherList", teacherList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("mainPage", "course/save.jsp");
	//	request.setAttribute("modeName", "�γ���Ϣ����");
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	/**
	 * ����޸Ĳ���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String courseName = request.getParameter("courseName");
		String credit = request.getParameter("credit");
		String teacherId = request.getParameter("teacherId");
		Goods course = new Goods(courseName, Integer.parseInt(credit),
				Integer.parseInt(teacherId));
		Connection con = null;
		try {
			con = dbUtil.getCon();
			if (StringUtil.isNotEmpty(id)) { // �޸�
				course.setId(Integer.parseInt(id));
				courseDao.courseUpdate(con, course);
			} else {
				courseDao.courseAdd(con, course);
			}
			response.sendRedirect("course?action=list");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			JSONObject result = new JSONObject();
			if(studentCourseDao.existCourseById(con, id)){
				result.put("success", false);
			}else{
				result.put("success", true);
				courseDao.courseDelete(con, id);				
			}
			new ResponseAdapter(response).write(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
