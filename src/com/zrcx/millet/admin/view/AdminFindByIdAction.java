package com.zrcx.millet.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.admin.bean.AdminBean;
import com.zrcx.millet.admin.dao.AdminDao;

@WebServlet("/page/admin/page/page/adminMg/adminFindByIdAction.action")
public class AdminFindByIdAction extends HttpServlet{
	private AdminDao adminDao = new AdminDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//通过id找到对应的adminBean
		int id = Integer.parseInt(req.getParameter("id"));
		AdminBean adminBean = adminDao.findById(id);
		req.setAttribute("adminBean", adminBean);
		req.getRequestDispatcher("modify.jsp").forward(req, resp);
	}
}
