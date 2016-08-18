package com.zrcx.millet.goods.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.gclass.bean.GclassBean;
import com.zrcx.millet.gclass.dao.GclassDao;
import com.zrcx.millet.goods.bean.GoodsBean;
import com.zrcx.millet.goods.dao.GoodsDao;

@WebServlet("/page/admin/page/page/goodsMg/goodsFindByGclassAllIdAction.action")
public class GoodsFindByGclassAllIdAction extends HttpServlet{
	private GclassDao gclassDao = new GclassDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		List<GclassBean> list = gclassDao.getAll("%%");
		req.setAttribute("list", list);
		req.getRequestDispatcher("add.jsp").forward(req, resp);
	}
}
