package com.zrcx.millet.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrcx.millet.basic.BasicDao;
import com.zrcx.millet.user.bean.UserBean;
import com.zrcx.millet.util.MD5Util;

public class UserDao extends BasicDao{
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		for(int i=0; i<147; i++){
			UserBean userBean = new UserBean();
			userBean.setPwd("123456");
			userBean.setPhone("123456"+i);
			userDao.add(userBean);
		}
	}
	
	/**
	 * 
	 * @Description: 添加操作
	 * @param UserBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:05:23
	 */
	public boolean add(UserBean userBean){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "insert into user(pwd,phone) values(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, MD5Util.getMD5Str(userBean.getPwd()));
			preparedStatement.setString(2, userBean.getPhone());
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
			String sql = "delete from user where id=?";
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
	 * UserBean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:09:33
	 */
	public UserBean findById(int id){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select id,pwd,phone from user where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				UserBean userBean = new UserBean();
				userBean.setId(resultSet.getInt(1));
				userBean.setPwd(resultSet.getString(2));
				userBean.setPhone(resultSet.getString(3));
				return userBean;
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
	 * @param UserBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:10:01
	 */
	public boolean modify(UserBean userBean){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "update user set pwd = ?, phone =?  where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, MD5Util.getMD5Str(userBean.getPwd()));
			preparedStatement.setString(2, userBean.getPhone());
			preparedStatement.setInt(3, userBean.getId());
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
	public Integer getCount(String phone){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select count(id) from user where phone like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phone);
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
	 * List<UserBean>  
	 * @throws
	 * @author Guo
	 * @date 2016年6月19日 下午11:11:13
	 */
	public List<UserBean> getPage(String phone,int begin,int pageSize){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<UserBean> list = new ArrayList<UserBean>();
		
		try {
			connection = getConnection(true);
			String sql = "select id,pwd,phone from user where phone like ? order by id desc limit ?,?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phone);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, pageSize);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UserBean userBean = new UserBean();
				userBean.setId(resultSet.getInt(1));
				userBean.setPwd(resultSet.getString(2));
				userBean.setPhone(resultSet.getString(3));
				list.add(userBean);
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
	 * @Description: 客户唯一性校验
	 * @param phone
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月22日 上午9:53:33
	 */
	public boolean findByPhone(String phone){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select id from user where phone=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phone);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;
	}
	
	/**
	 * 
	 * @Description: 通过手机号和密码查看该用户有没有
	 * @param phone
	 * @param pwd
	 * @return   
	 * UserBean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月22日 上午9:57:55
	 */
	public UserBean findByPhoneAndPwd(String phone, String pwd){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select id,pwd,phone from user where phone=? and pwd=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phone);
			preparedStatement.setString(2, MD5Util.getMD5Str(pwd));
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				UserBean userBean = new UserBean();
				userBean.setId(resultSet.getInt(1));
				userBean.setPwd(resultSet.getString(2));
				userBean.setPhone(resultSet.getString(3));
				return userBean;
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
