package com.zrcx.millet.admin.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.admin.bean.AdminBean;
import com.zrcx.millet.admin.dao.AdminDao;
import common.Jpage;

@WebServlet("/page/admin/page/page/adminMg/adminTableAction.action")
public class AdminTableAction extends HttpServlet {
	private AdminDao adminDao = new AdminDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//分页显示
		String email = req.getParameter("email");
		if(email==null ||"".equals(email) || "null".equals(email)){
			email = "%%";
		}else {
			email = "%"+email+"%";
		}
		int currentPage = req.getParameter("currentPage")==null?1
				:Integer.parseInt(req.getParameter("currentPage"));
		int totalRow = adminDao.getCount(email);
		Jpage jpage = new Jpage(currentPage, totalRow, "&&email="+
				(req.getParameter("email")==null?"":req.getParameter("email")));
		List<AdminBean> list = adminDao.getPage(email, jpage.getBegin(), jpage.getPageSize());
		req.setAttribute("list", list);
		req.setAttribute("jpage", jpage);
		req.setAttribute("path", req.getContextPath() + "/upload/admin/");
		req.getRequestDispatcher("table.jsp").forward(req, resp);
		
	}
}
