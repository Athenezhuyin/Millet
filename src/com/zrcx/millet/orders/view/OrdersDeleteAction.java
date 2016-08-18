package com.zrcx.millet.orders.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.admin.bean.AdminBean;
import com.zrcx.millet.admin.dao.AdminDao;
import com.zrcx.millet.orders.dao.OrdersDao;
@WebServlet("/page/admin/page/page/ordersMg/ordersDeleteAction.action")
public class OrdersDeleteAction extends HttpServlet{
	private OrdersDao ordersDao = new OrdersDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		ordersDao.delete(id);
		resp.sendRedirect("ordersTableAction.action");
	}
}
