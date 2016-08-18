package com.zrcx.millet.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.admin.bean.AdminBean;
import com.zrcx.millet.admin.dao.AdminDao;

@WebServlet("/page/admin/page/page/adminMg/adminModifyAction.action")
public class AdminModifyAction extends HttpServlet{
	private AdminDao adminDao = new AdminDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//重置管理员密码
		int id = Integer.parseInt(req.getParameter("id"));
		String pwd = req.getParameter("pwd");
		AdminBean adminBean = adminDao.findById(id);
		adminBean.setId(id);
		adminBean.setPwd(pwd);
		adminDao.modify(adminBean);
		resp.sendRedirect("adminTableAction.action");
	}
}
