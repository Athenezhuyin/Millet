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
import com.zrcx.millet.gorders.bean.GordersBean;
import com.zrcx.millet.gorders.dao.GordersDao;
@WebServlet("/page/user/page/showUserGordersMenuAction.action")
public class ShowUserGordersMenuAction extends HttpServlet{
	private GordersDao gordersDao = new GordersDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int orders_id = Integer.parseInt(req.getParameter("orders_id"));
		AddrBean addrBean = gordersDao.getAddrByOrdersId(orders_id);
		List<GordersBean> list = gordersDao.getPage(orders_id);
		Object[] objs = gordersDao.getNumberAllAndPriceAll(orders_id);
		
		req.setAttribute("addrBean", addrBean);
		req.setAttribute("list", list);
		req.setAttribute("objs", objs);
		req.setAttribute("path", req.getContextPath()+"/upload/goods/");
		req.getRequestDispatcher("userGordersMenu.jsp").forward(req, resp);
	}
}
