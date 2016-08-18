package com.zrcx.millet.user.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.user.bean.UserBean;
import com.zrcx.millet.user.dao.UserDao;

@WebServlet("/page/admin/page/page/userMg/userModifyAction.action")
public class UserModifyAction extends HttpServlet{
	private UserDao userDao = new UserDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String phone = req.getParameter("phone");
		String pwd = req.getParameter("pwd");
		UserBean userBean = new UserBean();
		userBean.setId(id);
		userBean.setPhone(phone);
		userBean.setPwd(pwd);
		userDao.modify(userBean);
		resp.sendRedirect("userTableAction.action");
	}
}
