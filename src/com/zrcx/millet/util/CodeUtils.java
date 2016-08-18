package com.zrcx.millet.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeUtils {
	//10.得到随机数
	private static char[] chars = "abdefghijkmnpqrstuvwxyABCDEFGHIJKLMNPQRSTUVWXY3456789".toCharArray();
	private static Random random = new Random();
	private static String getNum(int length){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++){
			sb.append(chars[random.nextInt(chars.length)]);
		}
		return sb.toString();
	}
	public static void main(String[] args) throws Exception {
		//1.创建画布
		BufferedImage bufferedImage = new BufferedImage(120, 34, BufferedImage.TYPE_INT_RGB);
		//2.创建画笔
		Graphics2D graphics2d = bufferedImage.createGraphics();
		//6.设置背景颜色  ， 先设置画笔颜色  ，在把画布涂满
		graphics2d.setColor(new Color(20, 123, 228));
		//7.涂满画布
		graphics2d.fillRect(0, 0, 120, 34);
		//8.更新画笔颜色
		graphics2d.setColor(new Color(246, 129, 50));
		//9.设置字体
		graphics2d.setFont(new Font("Dope Crisis", Font.PLAIN, 40));
		String num = getNum(4);
		//3.写字
		graphics2d.drawString(num, 25,30);
		//4.收笔
		graphics2d.dispose();
		//5.保存到硬盘上
		ImageIO.write(bufferedImage, "jpg", new File("c:\\abc.jpg"));
	}
	//11.保存到服务器上
	public static void createCode(HttpServletRequest req,HttpServletResponse resp){
		try {
			//1.创建画布
			BufferedImage bufferedImage = new BufferedImage(120, 34, BufferedImage.TYPE_INT_RGB);
			//2.创建画笔
			Graphics2D graphics2d = bufferedImage.createGraphics();
			//6.设置背景颜色  ， 先设置画笔颜色  ，在把画布涂满
			graphics2d.setColor(new Color(249, 250, 108));
			//7.涂满画布
			graphics2d.fillRect(0, 0, 120, 34);
			//8.更新画笔颜色
			graphics2d.setColor(new Color(62, 128, 27));
			//9.设置字体
			graphics2d.setFont(new Font("Dope Crisis", Font.PLAIN, 40));
			String num = getNum(4);
			//12.保存到sesssion中
			req.getSession().setAttribute("num", num);
			//3.写字
			graphics2d.drawString(num, 25,30);
			//4.收笔
			graphics2d.dispose();
			//5.保存到服务器上
			ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
