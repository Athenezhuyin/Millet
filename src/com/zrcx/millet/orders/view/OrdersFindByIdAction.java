package com.zrcx.millet.orders.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.orders.bean.OrdersBean;
import com.zrcx.millet.orders.dao.OrdersDao;

@WebServlet("/page/admin/page/page/ordersMg/ordersFindByIdAction.action")
public class OrdersFindByIdAction extends HttpServlet{
	private OrdersDao ordersDao = new OrdersDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		OrdersBean ordersBean = ordersDao.findById(id);
		req.setAttribute("ordersBean", ordersBean);
		req.getRequestDispatcher("modify.jsp").forward(req, resp);
	}
}
