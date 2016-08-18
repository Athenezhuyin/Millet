package com.zrcx.millet.gclass.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zrcx.millet.gclass.bean.GclassBean;
import com.zrcx.millet.gclass.dao.GclassDao;

import common.Jpage;

@WebServlet("/page/admin/page/page/gclassMg/gclassTableAction.action")
public class GclassTableAction extends HttpServlet{
	private GclassDao gclassDao = new GclassDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		if(name == null || "".equals(name) || "null".equals(name)){
			name = "%%";
		}else{
			name = "%"+name+"%";
		}
		
		int currentPage = req.getParameter("currentPage")==null?
				1:Integer.parseInt(req.getParameter("currentPage"));
		int totalRow = gclassDao.getCount(name);
		Jpage jpage = new Jpage(currentPage, totalRow, "&&name="+
				(req.getParameter("name")==null?"":req.getParameter("name")));
		List<GclassBean> list = gclassDao.getPage(name, jpage.getBegin(), jpage.getPageSize());
		req.setAttribute("list", list);
		req.setAttribute("jpage", jpage);
		req.getRequestDispatcher("table.jsp").forward(req, resp);
	}
}
