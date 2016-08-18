package com.zrcx.millet.gclass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrcx.millet.basic.BasicDao;
import com.zrcx.millet.gclass.bean.GclassBean;

public class GclassDao extends BasicDao {
	public static void main(String[] args) {
		GclassDao gclassDao = new GclassDao();
		for(int i=0; i<=125; i++){
			GclassBean gclassBean = new GclassBean();
			gclassBean.setName("car"+i);
			gclassDao.add(gclassBean);
		}
	}
	
	/**
	 * 
	 * @Description: 添加商品分类一条信息
	 * @param gclassBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月21日 下午1:28:33
	 */
	public boolean add(GclassBean gclassBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "insert into gclass(name) values(?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, gclassBean.getName());
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
	
	/**
	 * 
	 * @Description: 删除商品分类一条信息
	 * @param id
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月21日 下午1:29:53
	 */
	public boolean delete(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "delete from gclass where id=?";
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
	
	/**
	 * 
	 * @Description: 修改商品分类一条信息
	 * @param gclassBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月21日 下午1:42:44
	 */
	public boolean modify(GclassBean gclassBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "update gclass set name=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, gclassBean.getName());
			preparedStatement.setInt(2, gclassBean.getId());
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
	
	/**
	 * 
	 * @Description: 单挑查询
	 * @param id
	 * @return   
	 * GclassBean  
	 * @throws
	 * @author Guo
	 * @date 2016年6月21日 下午1:43:02
	 */
	public GclassBean findById(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select id,name from gclass where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				GclassBean gclassBean = new GclassBean();
				gclassBean.setId(resultSet.getInt(1));
				gclassBean.setName(resultSet.getString(2));
				return gclassBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {connection.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		return null;	
	}
	
	/**
	 * 
	 * @Description: 待条件查询所有
	 * @param name
	 * @return   
	 * List<GclassBean>  
	 * @throws
	 * @author Guo
	 * @date 2016年6月21日 下午1:43:19
	 */
	public List<GclassBean> getAll(String name){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<GclassBean> list = new ArrayList<GclassBean>();
		
		try {
			connection = getConnection(true);
			String sql = "select id,name from gclass where name like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				GclassBean gclassBean = new GclassBean();
				gclassBean.setId(resultSet.getInt(1));
				gclassBean.setName(resultSet.getString(2));
				list.add(gclassBean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {connection.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		return null;	
	}
	
	/**
	 * 
	 * @Description: 总记录数
	 * @param name
	 * @return   
	 * Integer  
	 * @throws
	 * @author Guo
	 * @date 2016年6月21日 下午1:43:39
	 */
	public Integer getCount(String name){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select count(id) from gclass where name like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {connection.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		return 0;	
	}
	
	/**
	 * 
	 * @Description: 分页
	 * @param name
	 * @param begin
	 * @param pageSize
	 * @return   
	 * List<GclassBean>  
	 * @throws
	 * @author Guo
	 * @date 2016年6月21日 下午1:43:53
	 */
	public List<GclassBean> getPage(String name, int begin, int pageSize){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<GclassBean> list = new ArrayList<GclassBean>();
		
		try {
			connection = getConnection(true);
			String sql = "select id,name from gclass where name like ? order by id desc limit ?, ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, pageSize);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				GclassBean gclassBean = new GclassBean();
				gclassBean.setId(resultSet.getInt(1));
				gclassBean.setName(resultSet.getString(2));
				list.add(gclassBean);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {resultSet.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {preparedStatement.close();} catch (SQLException e1) {e1.printStackTrace();}
			try {connection.close();} catch (SQLException e1) {e1.printStackTrace();}
		}
		return null;	
	}
}
