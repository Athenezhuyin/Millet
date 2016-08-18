package com.zrcx.millet.gorders.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrcx.millet.addr.bean.AddrBean;
import com.zrcx.millet.basic.BasicDao;
import com.zrcx.millet.gorders.bean.GordersBean;

public class GordersDao extends BasicDao{
	public static void main(String[] args) {
		GordersDao gordersDao = new GordersDao();
		List<GordersBean> list = gordersDao.getPage(1);
		for(GordersBean gordersBean : list){
			System.out.println(gordersBean);
		}
		Object[] objs = gordersDao.getNumberAllAndPriceAll(1);
		for(Object obj : objs){
			System.out.println(obj);
		}
	}
	
	public boolean add(GordersBean gordersBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "insert into gorders(goods_id,orders_id,number) values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, gordersBean.getGoods_id());
			preparedStatement.setInt(2, gordersBean.getOrders_id());
			preparedStatement.setInt(3, gordersBean.getNumber());
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
	
	public boolean modifyAddr(int orders_id,int addr_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "update gorders set addr_id=? where orders_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, addr_id);
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
	
	public List<GordersBean> getPage(int orders_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<GordersBean> list = new ArrayList<GordersBean>();
		
		try {
			connection = getConnection(true);
			String sql = "select c.id,c.goods_id,c.orders_id,c.number,c.name,c.image,c.price,d.code,d.time,d.state,d.user_id " 
					+"from (select a.id,a.goods_id,a.orders_id,a.number,b.name,b.image,b.price "
					+"from gorders a left join goods b on a.goods_id=b.id) c left join orders d on c.orders_id=d.id "
					+"where c.orders_id=? order by c.id desc";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orders_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				GordersBean gordersBean = new GordersBean();
				gordersBean.setId(resultSet.getInt(1));
				gordersBean.setGoods_id(resultSet.getInt(2));
				gordersBean.setOrders_id(resultSet.getInt(3));
				gordersBean.setNumber(resultSet.getInt(4));
				gordersBean.setName(resultSet.getString(5));
				gordersBean.setImage(resultSet.getString(6));
				gordersBean.setPrice(resultSet.getBigDecimal(7));
				gordersBean.setCode(resultSet.getString(8));
				gordersBean.setTime(resultSet.getTimestamp(9));
				gordersBean.setState(resultSet.getInt(10));
				gordersBean.setUser_id(resultSet.getInt(11));
				list.add(gordersBean);
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
	
	public AddrBean getAddrByOrdersId(int orders_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select a.id,a.name,a.province,a.city,a.district,a.street,a.postcode,a.phone,a.user_id "
					+"from addr a left join gorders b on a.id=b.addr_id left join orders c on c.id=b.orders_id "
					+"where b.orders_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orders_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				AddrBean addrBean = new AddrBean();
				addrBean.setId(resultSet.getInt(1));
				addrBean.setName(resultSet.getString(2));
				addrBean.setProvince(resultSet.getString(3));
				addrBean.setCity(resultSet.getString(4));
				addrBean.setDistrict(resultSet.getString(5));
				addrBean.setStreet(resultSet.getString(6));
				addrBean.setPostcode(resultSet.getString(7));
				addrBean.setPhone(resultSet.getString(8));
				addrBean.setUser_id(resultSet.getInt(9));
				return addrBean;
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
	
	public Object[] getNumberAllAndPriceAll(int orders_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Object[] objs = new Object[2];
		
		try {
			connection = getConnection(true);
			String sql = "select sum(a.number),sum(a.number*b.price) from gorders a left join goods b on a.goods_id=b.id"
					+" where a.orders_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orders_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				objs[0] = resultSet.getInt(1);
				objs[1] = resultSet.getInt(2);
				return objs;
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
}
