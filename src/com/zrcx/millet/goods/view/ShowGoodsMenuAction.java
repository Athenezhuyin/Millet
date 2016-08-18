package com.zrcx.millet.goods.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.goods.bean.GoodsBean;
import com.zrcx.millet.goods.dao.GoodsDao;

@WebServlet("/page/user/login/showGoodsMenuAction.action")
public class ShowGoodsMenuAction extends HttpServlet{
	private GoodsDao goodsDao = new GoodsDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(req.getParameter("id"));
		GoodsBean goodsBean = goodsDao.findById(id);
		req.setAttribute("goodsBean", goodsBean);
		req.setAttribute("path", req.getContextPath()+"/upload/goods/");
		req.getRequestDispatcher("goodsMenu.jsp").forward(req, resp);
	}
}
