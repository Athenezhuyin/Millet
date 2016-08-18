package com.zrcx.millet.gclass.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.gclass.bean.GclassBean;
import com.zrcx.millet.gclass.dao.GclassDao;

@WebServlet("/page/admin/page/page/gclassMg/gclassAddAction.action")
public class GclassAddAction extends HttpServlet{
	private GclassDao gclassDao = new GclassDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		GclassBean gclassBean = new GclassBean();
		gclassBean.setName(name);
		gclassDao.add(gclassBean);
		resp.sendRedirect("gclassTableAction.action");
	}
}
