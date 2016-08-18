package com.zrcx.millet.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DataPacket;
import org.apache.commons.fileupload.FileUploadCom;

import com.zrcx.millet.admin.bean.AdminBean;
import com.zrcx.millet.admin.dao.AdminDao;

@WebServlet("/page/admin/page/page/adminMg/adminAddAction.action")
public class AdminAddAction extends HttpServlet{
	private AdminDao adminDao = new AdminDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//涉及图片上传，所以用DataPacket
		DataPacket dataPacket = FileUploadCom.upload(req);
		String email = dataPacket.getValue("email");
		String pwd = dataPacket.getValue("pwd");
		String image = dataPacket.getValue("image");
		AdminBean adminBean = new AdminBean();
		adminBean.setEmail(email);
		adminBean.setPwd(pwd);
		adminBean.setImage(image);
		adminDao.add(adminBean);
		//注意：必须把图片上传到服务器
		dataPacket.write("image", "/upload/admin/"+image);
		resp.sendRedirect("adminTableAction.action");
	}
}
