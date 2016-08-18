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

@WebServlet("/page/user/page/showCarGordersAction.action")
public class ShowCarGordersAction extends HttpServlet{
	private OrdersDao ordersDao = new OrdersDao();
	private CarDao carDao = new CarDao();
	private GordersDao gordersDao = new GordersDao();
	private AddrDao addrDao = new AddrDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1、自动生成订单内容
		OrdersBean ordersBean = new OrdersBean();
		String code = UUID.randomUUID().toString().replace("-", "");
		Timestamp time = new Timestamp(new Date().getTime());
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		if(userBean == null){
			resp.sendRedirect("../login/login.jsp");
		}else{
		int user_id = userBean.getId();
		ordersBean.setCode(code);
		ordersBean.setState(0);
		ordersBean.setTime(time);
		ordersBean.setUser_id(user_id);
		ordersDao.add(ordersBean);
		String goods_ids = req.getParameter("goods_id");
		//2、通过订单编号反找订单orders_id
		OrdersBean ordersBean2 = ordersDao.findByCode(code);
		int orders_id = ordersBean2.getId();
		//购物车
		if(goods_ids == null){
			List<CarBean> list = carDao.getPage(user_id);
			//生成订单详情表
			for(CarBean carBean : list){
				GordersBean gordersBean2 = new GordersBean();
				gordersBean2.setGoods_id(carBean.getGoods_id());
				gordersBean2.setNumber(carBean.getNumber());
				gordersBean2.setOrders_id(orders_id);
				gordersDao.add(gordersBean2);
			}
		}else{//直接购买
			int goods_id = Integer.parseInt(goods_ids);
			GordersBean gordersBean2 = new GordersBean();
			gordersBean2.setGoods_id(goods_id);
			gordersBean2.setNumber(1);
			gordersBean2.setOrders_id(orders_id);
			gordersDao.add(gordersBean2);
		}
		
		
		//4.看数据库是否有该客户的收货地址
		List<AddrBean> list2 = addrDao.findByUser_id(user_id);
		if(list2.size() < 1){
			//resp.sendRedirect("ordersComfirm.jsp");
			req.setAttribute("orders_id", orders_id);
			req.getRequestDispatcher("ordersComfirm.jsp").forward(req, resp);
		}else{
		//5.展示数据
			Object[] objs = gordersDao.getNumberAllAndPriceAll(orders_id);
			req.setAttribute("list2", list2);
			req.setAttribute("objs", objs);
			req.setAttribute("orders_id", orders_id);
			req.getRequestDispatcher("ordersSubmit.jsp").forward(req, resp);
		}
		}
	}
			
}
