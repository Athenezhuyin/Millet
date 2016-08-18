package com.zrcx.millet.orders.view;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.admin.bean.AdminBean;
import com.zrcx.millet.admin.dao.AdminDao;
import com.zrcx.millet.orders.bean.OrdersBean;
import com.zrcx.millet.orders.dao.OrdersDao;

@WebServlet("/page/admin/page/page/ordersMg/ordersModifyAction.action")
public class OrdersModifyAction extends HttpServlet{
	private OrdersDao ordersDao = new OrdersDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String code = req.getParameter("code");
		Timestamp time = new Timestamp((new Date(req.getParameter("time")).getTime()));
		int state = Integer.parseInt(req.getParameter("state"));
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		OrdersBean ordersBean = new OrdersBean();
		ordersBean.setCode(code);
		ordersBean.setTime(time);
		ordersBean.setState(state);
		ordersBean.setUser_id(user_id);
		ordersDao.modifyAll(ordersBean);
		resp.sendRedirect("ordersTableAction.action");
	}
}
