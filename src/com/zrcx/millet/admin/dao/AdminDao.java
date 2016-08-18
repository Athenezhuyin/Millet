package com.zrcx.millet.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrcx.millet.admin.bean.AdminBean;
import com.zrcx.millet.basic.BasicDao;
import com.zrcx.millet.util.MD5Util;
/**
 * 
 * @Title: AdminDao.java
 * @Package com.zrcx.millet.admin.dao
 * @Description: 后台管理员Dao data object
 * @author Guo
 * @date 2016年6月19日 下午11:05:12
 * @version 1.0
 */
public class AdminDao extends BasicDao{
	/**
	 * 
	 * @Description: 测试
	 * @param args   
	 * void  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:13:14
	 */
	public static void main(String[] args) {
		AdminDao adminDao = new AdminDao();
		for(int i=0;i<136;i++){
			AdminBean adminBean = new AdminBean();
			adminBean.setEmail(i+"@qq.com");
			adminBean.setImage("admin_" + i+".jpg");
			adminBean.setPwd("123456"+i);
			System.out.println(adminDao.add(adminBean));
		}
		/*AdminBean adminBean = new AdminBean();
		adminBean.setEmail("1@163.com");
		adminBean.setImage("1.jpg");
		adminBean.setPwd("123456");
		System.out.println(adminDao.add(adminBean));*/
		/*System.out.println(adminDao.delete(135));*/
		/*AdminBean adminBean = adminDao.findById(1);
		adminBean.setPwd("123456");
		System.out.println(adminDao.modify(adminBean));*/
		/*System.out.println(adminDao.getCount("%%"));*/
		/*System.out.println(adminDao.getPage("%%", 0, 10));*/
		/*System.out.println(adminDao.findByNameAndPwd("asdf@1630","123456"));*/
	}
	/**
	 * 
	 * @Description: 添加操作
	 * @param adminBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:05:23
	 */
	public boolean add(AdminBean adminBean){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "insert into admin(email,pwd,image) values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, adminBean.getEmail());
			preparedStatement.setString(2, MD5Util.getMD5Str(adminBean.getPwd()));
			preparedStatement.setString(3, adminBean.getImage());
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		} finally {
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;
	}
	
	/**
	 * 
	 * @Description: 删除
	 * @param id
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:07:33
	 */
	public boolean delete(int id){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "delete from admin where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		} finally {
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;
	}
	
	/**
	 * 
	 * @Description: 单挑查询
	 * @param id
	 * @return   
	 * AdminBean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:09:33
	 */
	public AdminBean findById(int id){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select id,email,pwd,image from admin where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				AdminBean adminBean = new AdminBean();
				adminBean.setId(resultSet.getInt(1));
				adminBean.setEmail(resultSet.getString(2));
				adminBean.setPwd(resultSet.getString(3));
				adminBean.setImage(resultSet.getString(4));
				return adminBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return null;
	}
	
	/**
	 * 
	 * @Description: 修改操作
	 * @param adminBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:10:01
	 */
	public boolean modify(AdminBean adminBean){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "update admin set pwd = ? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, MD5Util.getMD5Str(adminBean.getPwd()));
			preparedStatement.setInt(2, adminBean.getId());
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		} finally {
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;
	}
	
	/**
	 * 
	 * @Description: 总记录数
	 * @param email
	 * @return   
	 * Integer  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:10:31
	 */
	public Integer getCount(String email){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select count(id) from admin where email like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			return resultSet.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return 0;
	}
	
	/**
	 * 
	 * @Description: 分页
	 * @param email
	 * @param begin
	 * @param pageSize
	 * @return   
	 * List<AdminBean>  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:11:13
	 */
	public List<AdminBean> getPage(String email,int begin,int pageSize){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AdminBean> list = new ArrayList<AdminBean>();
		
		try {
			connection = getConnection(true);
			String sql = "select id,email,pwd,image from admin where email like ? order by id desc limit ?,?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, pageSize);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				AdminBean adminBean = new AdminBean();
				adminBean.setId(resultSet.getInt(1));
				adminBean.setEmail(resultSet.getString(2));
				adminBean.setPwd(resultSet.getString(3));
				adminBean.setImage(resultSet.getString(4));
				list.add(adminBean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return null;
	}
	
	/**
	 * 
	 * @Description: 按照用户名和密码查询 登陆用
	 * @param email
	 * @param pwd
	 * @return   
	 * AdminBean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:12:04
	 */
	public AdminBean findByNameAndPwd(String email,String pwd){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select id,email,pwd,image from admin where email=? and pwd=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, MD5Util.getMD5Str(pwd));
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				AdminBean adminBean = new AdminBean();
				adminBean.setId(resultSet.getInt(1));
				adminBean.setEmail(resultSet.getString(2));
				adminBean.setPwd(resultSet.getString(3));
				adminBean.setImage(resultSet.getString(4));
				return adminBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return null;
	}
}
