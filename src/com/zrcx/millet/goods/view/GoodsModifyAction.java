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

import com.zrcx.millet.goods.bean.GoodsBean;
import com.zrcx.millet.goods.dao.GoodsDao;

@WebServlet("/page/admin/page/page/goodsMg/goodsModifyAction.action")
public class GoodsModifyAction extends HttpServlet{
	private GoodsDao goodsDao = new GoodsDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		DataPacket dataPacket = FileUploadCom.upload(req);
		int id = Integer.parseInt(dataPacket.getValue("id"));
		String name = dataPacket.getValue("name");
		BigDecimal price = new BigDecimal(dataPacket.getValue("price"));
		String image = dataPacket.getValue("image");
		GoodsBean goodsBean = goodsDao.findById(id);
		goodsBean.setId(id);
		goodsBean.setName(name);
		goodsBean.setPrice(price);
		goodsBean.setImage(image);

		goodsDao.modify(goodsBean);
		dataPacket.write("image","/upload/goods/"+image);
		resp.sendRedirect("goodsTableAction.action");
	}
}
