package com.zrcx.millet.user.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.user.bean.UserBean;
import com.zrcx.millet.user.dao.UserDao;

@WebServlet("/page/user/login/showUserRegAction.action")
public class ShowUserRegAction extends HttpServlet{
	private UserDao userDao = new UserDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String phone = req.getParameter("phone");
		String pwd = req.getParameter("pwd");
		String pwd1 = req.getParameter("pwd1");
		String code = req.getParameter("code");
		String code1 = (String)req.getSession().getAttribute("num");
		if(code.equalsIgnoreCase(code1)){
			if(userDao.findByPhone(phone)){
				req.setAttribute("error", "该手机号已被注册");
				req.getRequestDispatcher("reg.jsp").forward(req, resp);
			}else{
					UserBean userBean = new UserBean();
					userBean.setPhone(phone);
					userBean.setPwd(pwd);
					userDao.add(userBean);
					resp.sendRedirect("login.jsp");
			}
		}else{
			req.setAttribute("error2", "验证码错误");
			req.getRequestDispatcher("reg.jsp").forward(req, resp);
		}
		
	}
}
