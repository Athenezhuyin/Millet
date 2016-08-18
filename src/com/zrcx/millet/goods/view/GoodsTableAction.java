package com.zrcx.millet.goods.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zrcx.millet.goods.bean.GoodsBean;
import com.zrcx.millet.goods.dao.GoodsDao;

import common.Jpage;

@WebServlet("/page/admin/page/page/goodsMg/goodsTableAction.action")
public class GoodsTableAction extends HttpServlet{
	private GoodsDao goodsDao = new GoodsDao();
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
		int totalRow = goodsDao.getCount(name);
		Jpage jpage = new Jpage(currentPage, totalRow, "&&name="+
				(req.getParameter("name")==null?"":req.getParameter("name")));
		List<GoodsBean> list = goodsDao.getPage(name, jpage.getBegin(), jpage.getPageSize());
		req.setAttribute("list", list);
		req.setAttribute("jpage", jpage);
		req.setAttribute("path", req.getContextPath()+"/upload/goods/");
		
		req.getRequestDispatcher("table.jsp").forward(req, resp);
	}
}
