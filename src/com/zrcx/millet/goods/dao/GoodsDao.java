package com.zrcx.millet.goods.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrcx.millet.basic.BasicDao;
import com.zrcx.millet.goods.bean.GoodsBean;

public class GoodsDao extends BasicDao{
	public static void main(String[] args) {
		GoodsDao goodsDao = new GoodsDao();
		for(int i=0; i<45;i++){
			GoodsBean goodsBean = new GoodsBean();
			goodsBean.setName("小米"+i);
			goodsBean.setImage(i+".jpg");
			goodsBean.setPrice(new BigDecimal(2344));
			goodsBean.setDescription("good"+i);
			goodsBean.setGclass_id(1);
			goodsDao.add(goodsBean);
		}
	}
	
	public boolean add(GoodsBean goodsBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "insert into goods(name, image, price, description, gclass_id) values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, goodsBean.getName());
			preparedStatement.setString(2, goodsBean.getImage());
			preparedStatement.setBigDecimal(3, goodsBean.getPrice());
			preparedStatement.setString(4, goodsBean.getDescription());
			preparedStatement.setInt(5, goodsBean.getGclass_id());
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {connection.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		return false;
	}
	
	public boolean delete(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "delete from goods where id =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {connection.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		return false;
	}
	
	public boolean modify(GoodsBean goodsBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "update goods set name=?,price = ?,image=? where id =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, goodsBean.getName());
			preparedStatement.setBigDecimal(2, goodsBean.getPrice());
			preparedStatement.setString(3, goodsBean.getImage());
			preparedStatement.setInt(4, goodsBean.getId());
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {e1.printStackTrace();}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {connection.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		return false;
	}
	
	public GoodsBean findById(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select id,name,image,price,description,gclass_id from goods where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				GoodsBean goodsBean = new GoodsBean();
				goodsBean.setId(resultSet.getInt(1));
				goodsBean.setName(resultSet.getString(2));
				goodsBean.setImage(resultSet.getString(3));
				goodsBean.setPrice(resultSet.getBigDecimal(4));
				goodsBean.setDescription(resultSet.getString(5));
				goodsBean.setGclass_id(resultSet.getInt(6));
				return goodsBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {connection.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		return null;
	}
	
	
	public Integer getCount(String name){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select count(id) from goods where name like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {connection.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		return 0;
	}
	
	public List<GoodsBean> getPage (String name, int begin, int pageSize){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		
		try {
			connection = getConnection(true);
			String sql = "select a.id,a.name,a.image,a.price,a.description,a.gclass_id,b.name from goods a left join gclass b on a.gclass_id=b.id where a.name like ? order by a.id desc limit ?,?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, pageSize);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				GoodsBean goodsBean = new GoodsBean();
				goodsBean.setId(resultSet.getInt(1));
				goodsBean.setName(resultSet.getString(2));
				goodsBean.setImage(resultSet.getString(3));
				goodsBean.setPrice(resultSet.getBigDecimal(4));
				goodsBean.setDescription(resultSet.getString(5));
				goodsBean.setGclass_id(resultSet.getInt(6));
				goodsBean.setGname(resultSet.getString(7));
				list.add(goodsBean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {connection.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		return null;
	}
	
	public List<GoodsBean> findByGclass_id (int gclass_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		
		try {
			connection = getConnection(true);
			String sql = "select id,name,image,price,description,gclass_id from goods where gclass_id=? order by id desc";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, gclass_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				GoodsBean goodsBean = new GoodsBean();
				goodsBean.setId(resultSet.getInt(1));
				goodsBean.setName(resultSet.getString(2));
				goodsBean.setImage(resultSet.getString(3));
				goodsBean.setPrice(resultSet.getBigDecimal(4));
				goodsBean.setDescription(resultSet.getString(5));
				goodsBean.setGclass_id(resultSet.getInt(6));
				list.add(goodsBean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {connection.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		return null;
	}
}
