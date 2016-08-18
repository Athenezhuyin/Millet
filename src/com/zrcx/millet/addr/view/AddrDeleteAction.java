package com.zrcx.millet.addr.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.addr.dao.AddrDao;
import com.zrcx.millet.admin.bean.AdminBean;
import com.zrcx.millet.admin.dao.AdminDao;
@WebServlet("/page/user/page/addr/addrDeleteAction.action")
public class AddrDeleteAction extends HttpServlet{
	private AddrDao addrDao = new AddrDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//删除一条特定地址信息，跳到地址显示页面
		int id = Integer.parseInt(req.getParameter("id"));
		addrDao.delete(id);
		resp.sendRedirect("addrTableAction.action");
	}
}
