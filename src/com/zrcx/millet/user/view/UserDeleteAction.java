package com.zrcx.millet.user.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.user.dao.UserDao;

@WebServlet("/page/admin/page/page/userMg/userDeleteAction.action")
public class UserDeleteAction extends HttpServlet{
	private UserDao userDao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		userDao.delete(id);
		resp.sendRedirect("userTableAction.action");
	}
}
