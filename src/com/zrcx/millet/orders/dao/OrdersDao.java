package com.zrcx.millet.orders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zrcx.millet.admin.bean.AdminBean;
import com.zrcx.millet.basic.BasicDao;
import com.zrcx.millet.orders.bean.OrdersBean;

public class OrdersDao extends BasicDao{
	public static void main(String[] args) {
		OrdersDao ordersDao = new OrdersDao();
//		OrdersBean ordersBean = ordersDao.findByCode("1234");
//		System.out.println(ordersBean.getId());
		System.out.println(ordersDao.findUserGordersId(1));
	}
	
	public boolean add(OrdersBean ordersBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "insert into orders(code,time,state,user_id) values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ordersBean.getCode());
			preparedStatement.setTimestamp(2, ordersBean.getTime());
			preparedStatement.setInt(3, ordersBean.getState());
			preparedStatement.setInt(4, ordersBean.getUser_id());
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;
	}
	
	public boolean delete(int id){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "delete from orders where id=?";
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
	
	public boolean modifyAll(OrdersBean ordersBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "update orders set time=?,state=?,user_id=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setTimestamp(1, ordersBean.getTime());
			preparedStatement.setInt(2, ordersBean.getState());
			preparedStatement.setInt(3, ordersBean.getUser_id());
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;
	}
	public OrdersBean findById(int id){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select id,code,time,state,user_id from orders where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				OrdersBean ordersBean = new OrdersBean();
				ordersBean.setId(resultSet.getInt(1));
				ordersBean.setCode(resultSet.getString(2));
				ordersBean.setTime(resultSet.getTimestamp(3));
				ordersBean.setState(resultSet.getInt(4));
				ordersBean.setUser_id(resultSet.getInt(5));
				return ordersBean;
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
	
	public OrdersBean findByCode(String code){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select id,code,time,state,user_id from orders where code=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, code);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				OrdersBean ordersBean = new OrdersBean();
				ordersBean.setId(resultSet.getInt(1));
				ordersBean.setCode(resultSet.getString(2));
				ordersBean.setTime(resultSet.getTimestamp(3));
				ordersBean.setState(resultSet.getInt(4));
				ordersBean.setUser_id(resultSet.getInt(5));
				return ordersBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return null;
	}

	public boolean modifyState(int orders_id, int state){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "update orders set state=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, state);
			preparedStatement.setInt(2, orders_id);
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;
	}
	
	public boolean modifyTime(int orders_id, Timestamp time){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "update orders set time=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setTimestamp(1, time);
			preparedStatement.setInt(2, orders_id);
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return false;
	}
	

	public Integer getCount(String code){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select count(id) from orders where code like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, code);
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
	
	
	public List<OrdersBean> getPage(String code,int begin,int pageSize){
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<OrdersBean> list = new ArrayList<OrdersBean>();
		
		try {
			connection = getConnection(true);
			String sql = "select id,code,time,state,user_id from orders where code like ? order by id desc limit ?,?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, code);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, pageSize);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				OrdersBean ordersBean = new OrdersBean();
				ordersBean.setId(resultSet.getInt(1));
				ordersBean.setCode(resultSet.getString(2));
				ordersBean.setTime(resultSet.getTimestamp(3));
				ordersBean.setState(resultSet.getInt(4));
				ordersBean.setUser_id(resultSet.getInt(5));
				list.add(ordersBean);
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
	
	public List<Integer> findUserGordersId(int user_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Integer> list = new ArrayList<Integer>();
		
		try {
			connection = getConnection(true);
			String sql = "select id from orders where user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				list.add(resultSet.getInt(1));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e) {e.printStackTrace();}
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return null;
	}
}
