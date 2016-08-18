package com.zrcx.millet.goods.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.goods.bean.GoodsBean;
import com.zrcx.millet.goods.dao.GoodsDao;

@WebServlet("/page/user/login/showGoodsFindByGclassIdAction.action")
public class ShowGoodsFindByGclassIdAction extends HttpServlet{
	private GoodsDao goodsDao = new GoodsDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int gclass_id = Integer.parseInt(req.getParameter("gclass_id"));
		List<GoodsBean> list = goodsDao.findByGclass_id(gclass_id);
		req.setAttribute("list", list);
		req.setAttribute("path", req.getContextPath()+"/upload/goods/");
		req.getRequestDispatcher("gclassMenu.jsp").forward(req, resp);
	}
}
