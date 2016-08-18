package com.zrcx.millet.basic;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @Title: 调用数据库的基本类
 * @Package com.zrcx.millet.basic
 * @Description: TODO
 * @author Teacher Chen
 * @date 2016年7月1日 上午9:11:46
 * @version 1.0
 */
public class BasicDao {
	public Connection getConnection(boolean tag) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql:///millet", "root", "123456");
		connection.setAutoCommit(tag);
		return connection;
	}
}
