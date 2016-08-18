package com.zrcx.millet.gorders.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.addr.bean.AddrBean;
import com.zrcx.millet.addr.dao.AddrDao;
import com.zrcx.millet.car.dao.CarDao;
import com.zrcx.millet.gorders.bean.GordersBean;
import com.zrcx.millet.gorders.dao.GordersDao;
import com.zrcx.millet.orders.dao.OrdersDao;
import com.zrcx.millet.user.bean.UserBean;

@WebServlet("/page/user/page/showGordersMenuAction.action")
public class ShowGordersMenuAction extends HttpServlet{
	private GordersDao gordersDao = new GordersDao();
	private CarDao carDao = new CarDao();
	private OrdersDao ordersDao = new OrdersDao();
	private AddrDao addrDao = new AddrDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int orders_id = Integer.parseInt(req.getParameter("orders_id"));
		int addr_id = Integer.parseInt(req.getParameter("addr_id"));
		gordersDao.modifyAddr(orders_id, addr_id);
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		int user_id = userBean.getId();
		carDao.deleteAll(user_id);
		req.getSession().setAttribute("sum", 0);
		ordersDao.modifyState(orders_id, 1);
		List<GordersBean> list = gordersDao.getPage(orders_id);
		Object objs = gordersDao.getNumberAllAndPriceAll(orders_id);
		AddrBean addrBean = addrDao.getAddr(addr_id);
		req.setAttribute("list", list);
		req.setAttribute("objs", objs);
		req.setAttribute("path", req.getContextPath()+"/upload/goods/");
		req.setAttribute("addrBean", addrBean);
		req.getRequestDispatcher("gordersMenu.jsp").forward(req, resp);
	}
}
