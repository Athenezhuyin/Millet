package com.zrcx.millet.gclass.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.gclass.bean.GclassBean;
import com.zrcx.millet.gclass.dao.GclassDao;

@WebServlet("/page/admin/page/page/gclassMg/gclassFindByIdAction.action")
public class GclassFindByIdAction extends HttpServlet{
	private GclassDao gclassDao = new GclassDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		GclassBean gclassBean = gclassDao.findById(id);
		req.setAttribute("gclassBean", gclassBean);
		req.getRequestDispatcher("modify.jsp").forward(req, resp);
	}
}
