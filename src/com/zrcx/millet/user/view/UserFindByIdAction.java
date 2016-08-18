package com.zrcx.millet.user.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.user.bean.UserBean;
import com.zrcx.millet.user.dao.UserDao;

@WebServlet("/page/admin/page/page/userMg/userFindByIdAction.action")
public class UserFindByIdAction extends HttpServlet{
	private UserDao userDao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		UserBean userBean = userDao.findById(id);
		req.setAttribute("userBean", userBean);
		req.getRequestDispatcher("modify.jsp").forward(req, resp);
	}
}
