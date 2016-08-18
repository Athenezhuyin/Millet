package com.zrcx.millet.gclass.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.millet.gclass.bean.GclassBean;
import com.zrcx.millet.gclass.dao.GclassDao;
import com.zrcx.millet.goods.dao.GoodsDao;

@WebServlet("/page/user/login/showGclassTableAction.action")
public class ShowGclassTableAction extends HttpServlet{
	private GclassDao gclassDao = new GclassDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		if(name==null || "".equals(name) || "null".equals(name)){
			name = "%%";
		}else{
			name = "%"+name+"%";
		}
		List<GclassBean> list = gclassDao.getAll(name);
		req.setAttribute("list", list);
		req.getRequestDispatcher("gclassTable.jsp").forward(req, resp);
	}
}
