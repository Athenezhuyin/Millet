package com.zrcx.millet.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/admin/page/main/adminExitAction.action")
public class AdminExitAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//停止会话
		req.getSession().invalidate();
		//跳转到登录页面
		resp.sendRedirect("../../login/login.jsp");
	}
}
