package com.zrcx.millet.user.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.user.bean.UserBean;
import com.zrcx.millet.user.dao.UserDao;

@WebServlet("/page/user/login/showUserLoginAction.action")
public class ShowUserLoginAction extends HttpServlet{
	private UserDao userDao = new UserDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String phone = req.getParameter("phone");
		String pwd = req.getParameter("pwd");
		UserBean userBean = userDao.findByPhoneAndPwd(phone, pwd);
		if(userBean != null){
			req.getSession().setAttribute("userBean", userBean);
			req.getRequestDispatcher("../page/userIndex.jsp").forward(req, resp);;
		}else{
			req.setAttribute("error", "用户名或密码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
