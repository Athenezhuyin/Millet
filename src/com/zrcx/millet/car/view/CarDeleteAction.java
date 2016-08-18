package com.zrcx.millet.car.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.car.dao.CarDao;
import com.zrcx.millet.user.bean.UserBean;

@WebServlet("/page/user/page/carDeleteAction.action")
public class CarDeleteAction extends HttpServlet{
	private CarDao carDao = new CarDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//删除特定用户特定商品的个数
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		int user_id = userBean.getId();
		int goods_id = Integer.parseInt(req.getParameter("goods_id"));
		carDao.delete(user_id, goods_id);
		resp.sendRedirect("carListAction.action");
	}
}
