package com.zrcx.millet.gorders.view;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.addr.bean.AddrBean;
import com.zrcx.millet.addr.dao.AddrDao;
import com.zrcx.millet.car.bean.CarBean;
import com.zrcx.millet.car.dao.CarDao;
import com.zrcx.millet.gorders.bean.GordersBean;
import com.zrcx.millet.gorders.dao.GordersDao;
import com.zrcx.millet.orders.bean.OrdersBean;
import com.zrcx.millet.orders.dao.OrdersDao;
import com.zrcx.millet.user.bean.UserBean;

@WebServlet("/page/user/page/showCarGordersAction2.action")
public class ShowCarGordersAction2 extends HttpServlet{
	private OrdersDao ordersDao = new OrdersDao();
	private CarDao carDao = new CarDao();
	private GordersDao gordersDao = new GordersDao();
	private AddrDao addrDao = new AddrDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//传参
		int orders_id = Integer.parseInt(req.getAttribute("orders_id").toString());
		Timestamp time = new Timestamp(new Date().getTime());
		List<GordersBean> list = gordersDao.getPage(orders_id);
		for(GordersBean gordersBean : list){
			gordersBean.setTime(time);
			OrdersBean ordersBean = ordersDao.findById(gordersBean.getOrders_id());
			ordersBean.setTime(time);	
		}
		
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		int user_id = userBean.getId();
		List<AddrBean> list2 = addrDao.findByUser_id(user_id);
		Object[] objs = gordersDao.getNumberAllAndPriceAll(orders_id);
		req.setAttribute("list2", list2);
		req.setAttribute("objs", objs);
		req.setAttribute("orders_id", orders_id);
		req.getRequestDispatcher("ordersSubmit.jsp").forward(req, resp);
		
	}
			
}
