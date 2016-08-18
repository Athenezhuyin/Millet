package com.zrcx.millet.car.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrcx.millet.basic.BasicDao;
import com.zrcx.millet.car.bean.CarBean;

public class CarDao extends BasicDao{
	public static void main(String[] args) {
		CarDao carDao = new CarDao();
		List<CarBean> list = carDao.getPage(1);
		for(CarBean carBean : list){
			System.out.println(carBean);
		}
		Object[] objs = carDao.getNumberAndPrice(1);
		for(Object obj : objs){
			System.out.println(obj);
		}
	}
	
	/**
	 * 
	 * @Description: 在car表中查询特定用户，特定商品的数目
	 * @param user_id
	 * @param goods_id
	 * @return   
	 * int  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午9:12:48
	 */
	public int findByUser_idAndGoods_id(int user_id, int goods_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select number from car where user_id=? and goods_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			preparedStatement.setInt(2, goods_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e){e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e){e.printStackTrace();}
			try {connection.close();} catch (SQLException e){e.printStackTrace();}
		}
		return 0;
	}
	
	/**
	 * 
	 * @Description: 添加
	 * @param carBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午9:13:54
	 */
	public boolean add(CarBean carBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "insert into car(user_id,goods_id,number) values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, carBean.getUser_id());
			preparedStatement.setInt(2, carBean.getGoods_id());
			preparedStatement.setInt(3, carBean.getNumber());
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1){e.printStackTrace();}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e){e.printStackTrace();}
			try {connection.close();} catch (SQLException e){e.printStackTrace();}
		}
		return false;
	}
	
	/**
	 * 
	 * @Description: 删除
	 * @param user_id
	 * @param goods_id
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午9:14:53
	 */
	public boolean delete(int user_id, int goods_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "delete from car where user_id=? and goods_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			preparedStatement.setInt(2, goods_id);
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1){e.printStackTrace();}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e){e.printStackTrace();}
			try {connection.close();} catch (SQLException e){e.printStackTrace();}
		}
		return false;
	}
	
	/**
	 * 
	 * @Description: 在car表中修改特定用户，特定商品的数目
	 * @param user_id
	 * @param goods_id
	 * @param number
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午9:15:04
	 */
	public boolean modify(int user_id, int goods_id, int number){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "update car set number=? where user_id=? and goods_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, number);
			preparedStatement.setInt(2, user_id);
			preparedStatement.setInt(3, goods_id);
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1){e.printStackTrace();}
			e.printStackTrace();
		}finally{
			try {preparedStatement.close();} catch (SQLException e){e.printStackTrace();}
			try {connection.close();} catch (SQLException e){e.printStackTrace();}
		}
		return false;
	}
	
	/**
	 * 
	 * @Description: 分页
	 * @param user_id
	 * @return   
	 * List<CarBean>  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午9:15:42
	 */
	public List<CarBean> getPage(int user_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<CarBean> list = new ArrayList<CarBean>();
		
		try {
			connection = getConnection(true);
			String sql = "select a.id,a.user_id,a.goods_id,a.number,b.name,b.image,b.price "
					+ "from car a left join goods b on a.goods_id=b.id where a.user_id=? order by a.id desc";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				CarBean carBean = new CarBean();
				carBean.setId(resultSet.getInt(1));
				carBean.setUser_id(resultSet.getInt(2));
				carBean.setGoods_id(resultSet.getInt(3));
				carBean.setNumber(resultSet.getInt(4));
				carBean.setName(resultSet.getString(5));
				carBean.setImage(resultSet.getString(6));
				carBean.setPrice(resultSet.getBigDecimal(7));
				list.add(carBean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e){e.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e){e.printStackTrace();}
			try {connection.close();} catch (SQLException e){e.printStackTrace();}
		}
		return null;
	}
		
	/**
	 * 
	 * @Description: 获得特定用户购物车中的商品数目和总价
	 * @param user_id
	 * @return   
	 * Object[]  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午9:15:52
	 */
		public Object[] getNumberAndPrice(int user_id){
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = getConnection(true);
				String sql = "select sum(a.number),sum(a.number*b.price) from car a left join goods b "
						+ "on a.goods_id=b.id where a.user_id=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, user_id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()){
					Object[] objs = new Object[2];
					objs[0] = resultSet.getInt(1);
					objs[1] = resultSet.getBigDecimal(2);
					return objs;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {resultSet.close();} catch (SQLException e){e.printStackTrace();}
				try {preparedStatement.close();} catch (SQLException e){e.printStackTrace();}
				try {connection.close();} catch (SQLException e){e.printStackTrace();}
			}
			return null;
		}
		
		public boolean deleteAll(int user_id){
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = getConnection(false);
				String sql = "delete from car where user_id=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, user_id);
				preparedStatement.executeUpdate();
				connection.commit();
				return true;
			} catch (Exception e) {
				try {connection.rollback();} catch (SQLException e1){e.printStackTrace();}
				e.printStackTrace();
			}finally{
				try {preparedStatement.close();} catch (SQLException e){e.printStackTrace();}
				try {connection.close();} catch (SQLException e){e.printStackTrace();}
			}
			return false;
		}
}
