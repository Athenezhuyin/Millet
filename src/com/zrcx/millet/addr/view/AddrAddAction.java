package com.zrcx.millet.addr.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.addr.bean.AddrBean;
import com.zrcx.millet.addr.dao.AddrDao;
import com.zrcx.millet.user.bean.UserBean;

@WebServlet("/page/user/page/addr/addrAddAction.action")
public class AddrAddAction extends HttpServlet{
	private AddrDao addrDao = new AddrDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//将填入的地址信息存起来，添加到addr表中
		String name = req.getParameter("name");
		int district_id = Integer.parseInt(req.getParameter("districtid"));
		AddrBean addrBean = addrDao.getProvinceAndCityAndDistrict(district_id);
		String street = req.getParameter("street");
		String postcode = req.getParameter("postcode");
		String phone = req.getParameter("phone");
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		int user_id = userBean.getId();
	
		addrBean.setName(name);
		addrBean.setStreet(street);
		addrBean.setPostcode(postcode);
		addrBean.setPhone(phone);
		addrBean.setUser_id(user_id);
		addrDao.add(addrBean);
		
		String orders_id = req.getParameter("orders_id");
		//orders_id为空，说明是从“地址管理”过来的，直接查看所有保存的地址
		if(orders_id == null){
			resp.sendRedirect("addrTableAction.action");
		}else{
			//orders_id不为空，说明是从“订单”过来的，跳到订单详情
			req.setAttribute("orders_id", orders_id);
			req.getRequestDispatcher("../showCarGordersAction2.action").forward(req, resp);
		}
		//resp.sendRedirect("showCarGordersAction.action");
	}
}
