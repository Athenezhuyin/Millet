package com.zrcx.millet.addr.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonUtil;

import com.zrcx.millet.addr.dao.JLDao;
@WebServlet("/page/user/page/addr/jLAction.action")
public class JLAction extends HttpServlet{
	private JLDao jLDao = new JLDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String method = req.getParameter("method");
		String str = "";
		if(method.equals("province")){
			str = JsonUtil.fromObject(jLDao.getProvince());
		} else if(method.equals("city")){
			str = JsonUtil.fromObject(jLDao.getCity(Integer.parseInt(req.getParameter("id"))));
		} else if(method.equals("district")){
			str = JsonUtil.fromObject(jLDao.getDistrict(Integer.parseInt(req.getParameter("id"))));
		}
		resp.getWriter().print(str);
	}
}
