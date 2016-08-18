package com.zrcx.millet.car.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.car.bean.CarBean;
import com.zrcx.millet.car.dao.CarDao;
import com.zrcx.millet.user.bean.UserBean;

@WebServlet("/page/user/page/carListAction.action")
public class CarListAction extends HttpServlet{
	private CarDao carDao = new CarDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		int user_id = userBean.getId();
		List<CarBean> list = carDao.getPage(user_id);		
		if(list.size() < 1){
			//购物车为空，“购物车空空如也”
			resp.sendRedirect("emptyCar.jsp");
		}else{
			//购物车不为空，传总价，总数，购物车内容，图片路径
			Object[] objs = carDao.getNumberAndPrice(user_id);
			req.setAttribute("sum", objs[1]);
			req.setAttribute("number", objs[0]);
			req.setAttribute("list", list);
			req.setAttribute("path", req.getContextPath()+"/upload/goods/");
			req.getRequestDispatcher("car.jsp").forward(req, resp);
		}
	}
}
