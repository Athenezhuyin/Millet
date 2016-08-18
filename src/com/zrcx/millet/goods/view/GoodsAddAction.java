package com.zrcx.millet.goods.view;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DataPacket;
import org.apache.commons.fileupload.FileUploadCom;

import com.zrcx.millet.gclass.bean.GclassBean;
import com.zrcx.millet.gclass.dao.GclassDao;
import com.zrcx.millet.goods.bean.GoodsBean;
import com.zrcx.millet.goods.dao.GoodsDao;

@WebServlet("/page/admin/page/page/goodsMg/goodsAddAction.action")
public class GoodsAddAction extends HttpServlet{
	private GoodsDao goodsDao = new GoodsDao();
	private GclassDao gclassDao = new GclassDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		DataPacket dataPacket = FileUploadCom.upload(req);
		int gclass_id = Integer.parseInt(dataPacket.getValue("gclass_id"));
		String name = dataPacket.getValue("name");
		String image = dataPacket.getValue("image");
		BigDecimal price = new BigDecimal(dataPacket.getValue("price"));
		String description = dataPacket.getValue("description");
		
		GoodsBean goodsBean = new GoodsBean();
		goodsBean.setGclass_id(gclass_id);
		goodsBean.setName(name);
		goodsBean.setImage(image);
		goodsBean.setPrice(price);
		goodsBean.setDescription(description);
		GclassBean gclassBean = gclassDao.findById(gclass_id);
		String gname = gclassBean.getName();
		goodsBean.setGname(gname);
		goodsDao.add(goodsBean);
		if(dataPacket.write("image", "/upload/goods/"+image))
			System.out.println("ok");
		else
			System.out.println("no");
		resp.sendRedirect("goodsTableAction.action");
	}
}
