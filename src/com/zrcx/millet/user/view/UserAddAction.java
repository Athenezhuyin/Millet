package com.zrcx.millet.user.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.user.bean.UserBean;
import com.zrcx.millet.user.dao.UserDao;

@WebServlet("/page/admin/page/page/userMg/userAddAction.action")
public class UserAddAction extends HttpServlet{
	private UserDao userDao = new UserDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String phone = req.getParameter("phone");
		String pwd = req.getParameter("pwd");
		if(userDao.findByPhone(phone)){
			req.setAttribute("error", "手机号已经被注册");
			req.getRequestDispatcher("add.jsp").forward(req, resp);
		}
		else{
			UserBean userBean = new UserBean();
			userBean.setPhone(phone);
			userBean.setPwd(pwd);
			userDao.add(userBean);
			resp.sendRedirect("userTableAction.action");
		}
	}
}
