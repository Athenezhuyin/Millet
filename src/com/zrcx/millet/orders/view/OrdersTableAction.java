package com.zrcx.millet.orders.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.admin.bean.AdminBean;
import com.zrcx.millet.admin.dao.AdminDao;
import com.zrcx.millet.orders.bean.OrdersBean;
import com.zrcx.millet.orders.dao.OrdersDao;

import common.Jpage;

@WebServlet("/page/admin/page/page/ordersMg/ordersTableAction.action")
public class OrdersTableAction extends HttpServlet {
	private OrdersDao ordersDao = new OrdersDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String code = req.getParameter("code");
		if(code==null ||"".equals(code) || "null".equals(code)){
			code = "%%";
		}else {
			code = "%"+code+"%";
		}
		int currentPage = req.getParameter("currentPage")==null?1
				:Integer.parseInt(req.getParameter("currentPage"));
		int totalRow = ordersDao.getCount(code);
		Jpage jpage = new Jpage(currentPage, totalRow, "&&code="+
				(req.getParameter("code")==null?"":req.getParameter("code")));
		List<OrdersBean> list = ordersDao.getPage(code, jpage.getBegin(), jpage.getPageSize());
		req.setAttribute("list", list);
		req.setAttribute("jpage", jpage);
		req.setAttribute("path", req.getContextPath() + "/upload/admin/");
		req.getRequestDispatcher("table.jsp").forward(req, resp);
		
	}
}
