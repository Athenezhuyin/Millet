package com.zrcx.millet.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.util.CodeUtils;
@WebServlet("/page/admin/login/adminCodeAction.action")
public class AdminCodeAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//验证码
		CodeUtils.createCode(req, resp);
	}
}
