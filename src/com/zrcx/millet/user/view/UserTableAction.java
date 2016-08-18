package com.zrcx.millet.user.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.user.bean.UserBean;
import com.zrcx.millet.user.dao.UserDao;

import common.Jpage;

@WebServlet("/page/admin/page/page/userMg/userTableAction.action")
public class UserTableAction extends HttpServlet{
	private UserDao userDao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String phone = req.getParameter("phone");
		if(phone==null || "".equals(phone) || "null".equals(phone)){
			phone = "%%";
		}else{
			phone = "%"+phone+"%";
		}
		
		int currentPage = req.getParameter("currentPage")==null?
				1:Integer.parseInt(req.getParameter("currentPage"));
		int totalRow = userDao.getCount(phone);
		Jpage jpage = new Jpage(currentPage, totalRow, "&&phone="+
				(req.getParameter("phone")==null?"":req.getParameter("phone")));
		List<UserBean> list = userDao.getPage(phone, jpage.getBegin(), jpage.getPageSize());
		req.setAttribute("list", list);
		req.setAttribute("jpage", jpage);
		req.getRequestDispatcher("table.jsp").forward(req, resp);
	}
}
