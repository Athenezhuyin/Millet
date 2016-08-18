package com.zrcx.millet.addr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrcx.millet.addr.bean.AddrBean;
import com.zrcx.millet.basic.BasicDao;

public class AddrDao extends BasicDao{
	public static void main(String[] args) {
		AddrDao addrDao = new AddrDao();
		List<AddrBean> list = addrDao.findByUser_id(2);
		for(AddrBean addrBean : list){
			System.out.println(addrBean);
		}
		System.out.println(addrDao.getProvinceAndCityAndDistrict(120));
	}
	
	/**
	 * 
	 * @Description: 在addr表中通过user_id找到该用户所有地址信息
	 * @param user_id
	 * @return   
	 * List<AddrBean>  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午12:05:39
	 */
	public List<AddrBean> findByUser_id(int user_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<AddrBean> list = new ArrayList<AddrBean>();
		
		try {
			connection = getConnection(true);
			String sql = "select id,name,province,city,district,street,postcode,phone,user_id from addr where user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
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
				list.add(addrBean);
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
	
	/**
	 * 
	 * @Description: province表，city表，district表相连，通过district_id找到完整的地址信息
	 * @param district_id
	 * @return   
	 * AddrBean  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午12:06:31
	 */
	public AddrBean getProvinceAndCityAndDistrict(int district_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select c.ProvinceName,b.CityName,a.DistrictName from district a left join city b on a.CityID=b.CityID "
					+ "left join province c on b.ProvinceID=c.ProvinceID where a.DistrictID=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, district_id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				AddrBean addrBean = new AddrBean();
				addrBean.setProvince(resultSet.getString(1));
				addrBean.setCity(resultSet.getString(2));
				addrBean.setDistrict(resultSet.getString(3));
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
	
	/**
	 * 
	 * @Description: 单挑查询
	 * @param id
	 * @return   
	 * AddrBean  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午12:08:03
	 */
	public AddrBean findById(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select id,name,province,city,district,street,postcode,phone,user_id from addr where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
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
	
	/**
	 * 
	 * @Description: 添加一条地址信息
	 * @param addrBean
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午12:08:20
	 */
	public boolean add(AddrBean addrBean){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "insert into addr(name,province,city,district,street,postcode,phone,user_id) values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, addrBean.getName());
			preparedStatement.setString(2, addrBean.getProvince());
			preparedStatement.setString(3, addrBean.getCity());
			preparedStatement.setString(4, addrBean.getDistrict());
			preparedStatement.setString(5, addrBean.getStreet());
			preparedStatement.setString(6, addrBean.getPostcode());
			preparedStatement.setString(7, addrBean.getPhone());
			preparedStatement.setInt(8, addrBean.getUser_id());
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
	
	/**
	 * 
	 * @Description: 删除一天记录
	 * @param id
	 * @return   
	 * boolean  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午12:08:35
	 */
	public boolean delete(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection(false);
			String sql = "delete from addr where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
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
	
	/**
	 * 
	 * @Description: 单挑查询（重复可删）
	 * @param addr_id
	 * @return   
	 * AddrBean  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午12:09:02
	 */
	public AddrBean getAddr(int addr_id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(true);
			String sql = "select id,name,province,city,district,street,postcode,phone,user_id from addr where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, addr_id);
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
	
}
