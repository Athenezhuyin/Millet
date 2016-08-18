package com.zrcx.millet.gclass.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.gclass.bean.GclassBean;
import com.zrcx.millet.gclass.dao.GclassDao;

@WebServlet("/page/admin/page/page/gclassMg/gclassModifyAction.action")
public class GclassModifyAction extends HttpServlet{
	private GclassDao gclassDao = new GclassDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		GclassBean gclassBean = new GclassBean();
		gclassBean.setId(id);
		gclassBean.setName(name);
		gclassDao.modify(gclassBean);
		resp.sendRedirect("gclassTableAction.action");
	}
}
