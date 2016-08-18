package com.zrcx.millet.gorders.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.gorders.bean.GordersBean;
import com.zrcx.millet.gorders.dao.GordersDao;
import com.zrcx.millet.orders.dao.OrdersDao;
import com.zrcx.millet.user.bean.UserBean;
@WebServlet("/page/user/page/showGordersListAction.action")
public class ShowGordersListAction extends HttpServlet{
	private OrdersDao ordersDao = new OrdersDao();
	private GordersDao gordersDao = new GordersDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		int user_id = userBean.getId();
		List<Integer> list = ordersDao.findUserGordersId(user_id);
		List<List<GordersBean>> list3 = new ArrayList<List<GordersBean>>();
		List<Object[]> list4 = new ArrayList<Object[]>();
		for(int orders_id : list){
			List<GordersBean> list2 = gordersDao.getPage(orders_id);
			if(list2.size() > 0){
				list3.add(list2);
			}
			Object[] objs = gordersDao.getNumberAllAndPriceAll(orders_id);
			list4.add(objs);
		}
		req.setAttribute("list3", list3);
		req.setAttribute("list4", list4);
		req.setAttribute("path", req.getContextPath()+"/upload/goods");
		req.getRequestDispatcher("userGordersList.jsp").forward(req, resp);
	}
}
