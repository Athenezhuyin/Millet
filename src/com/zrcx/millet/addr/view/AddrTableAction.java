package com.zrcx.millet.addr.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.addr.bean.AddrBean;
import com.zrcx.millet.addr.dao.AddrDao;
import com.zrcx.millet.user.bean.UserBean;

@WebServlet("/page/user/page/addr/addrTableAction.action")
public class AddrTableAction extends HttpServlet{
	private AddrDao addrDao = new AddrDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//获得特定客户的所有地址信息
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		int user_id = userBean.getId();
		List<AddrBean> list = addrDao.findByUser_id(user_id);
		req.setAttribute("list", list);
		req.getRequestDispatcher("table.jsp").forward(req, resp);
	}
}
