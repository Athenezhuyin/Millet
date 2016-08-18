package com.zrcx.millet.car.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.car.bean.CarBean;
import com.zrcx.millet.car.dao.CarDao;
import com.zrcx.millet.user.bean.UserBean;

@WebServlet("/page/user/page/carAddAction.action")
public class CarAddAction extends HttpServlet{
	private CarDao carDao = new CarDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		if(userBean == null){
			//若没登陆就想加入购物车，则需要跳转到登录页面先登录
			resp.sendRedirect("../login/login.jsp");
		}else{
		int user_id = userBean.getId();
		int goods_id = Integer.parseInt(req.getParameter("goods_id"));
		int number = carDao.findByUser_idAndGoods_id(user_id, goods_id);
		if(number < 1){
			//购物车为空，新建一个购物车，加入内容
			CarBean carBean = new CarBean();
			carBean.setUser_id(user_id);
			carBean.setGoods_id(goods_id);
			carBean.setNumber(1);
			carDao.add(carBean);
		}else{
			//购物车不为空，直接商品数加1
			carDao.modify(user_id, goods_id, number+1);
		}
		resp.sendRedirect("carListAction.action");
		}
	}
}
