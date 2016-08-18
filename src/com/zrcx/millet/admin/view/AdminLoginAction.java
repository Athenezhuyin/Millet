package com.zrcx.millet.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.admin.bean.AdminBean;
import com.zrcx.millet.admin.dao.AdminDao;

@WebServlet("/page/admin/login/adminLoginAction.action")
public class AdminLoginAction extends HttpServlet{
	AdminDao adminDao = new AdminDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String code = req.getParameter("code");
		String code1 = (String)req.getSession().getAttribute("num");
		if(code.equalsIgnoreCase(code1)){
			//忽略大小写，验证码正确
			AdminBean adminBean = adminDao.findByNameAndPwd(email, pwd);
			if(adminBean != null){
				//管理员登录成功，进入后台
				req.getSession().setAttribute("adminBean", adminBean);
				resp.sendRedirect("../page/main/main.jsp");
			}else{
				//登录不成功，重新登录，打印错误信息
				req.setAttribute("error1", "邮箱错误或者密码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}else{
			//验证码不正确，打印错误信息
			req.setAttribute("error", "验证码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
