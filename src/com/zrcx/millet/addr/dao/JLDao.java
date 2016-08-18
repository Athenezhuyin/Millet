package com.zrcx.millet.addr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zrcx.millet.basic.BasicDao;




public class JLDao extends BasicDao{

	/**
	 * 
	 * @Description: 在province表中获得所有省的id和省名
	 * @return   
	 * List<Object[]>  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午12:11:08
	 */
	public List<Object[]> getProvince(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object[]> list = new ArrayList<Object[]>();
		
		try {
			conn = getConnection(true);
			String sql = "select provinceid ,provincename from province order by provinceid ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Object[] object = new Object[2];
				object[0]=rs.getInt(1);
				object[1]=rs.getString(2);
				list.add(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {ps.close();} catch (SQLException e) {e.printStackTrace();}	
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}	
		}
		return list;
	}
	
	/**
	 * 
	 * @Description: 在city表中，找到给定省的所有城市id和市名
	 * @param provinceid
	 * @return   
	 * List<Object[]>  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午12:12:01
	 */
	public List<Object[]> getCity(int provinceid){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object[]> list = new ArrayList<Object[]>();
		
		
		try {
			conn = getConnection(true);
			String sql = "select cityid,cityname from city where provinceid=? order by cityid";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, provinceid);
			rs = ps.executeQuery();
			while(rs.next()){
				Object[] object = new Object[2];
				object[0]=rs.getInt(1);
				object[1]=rs.getString(2);
				list.add(object);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {ps.close();} catch (SQLException e) {e.printStackTrace();}	
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}	
		} 
		return null;
	}
	
	/**
	 * 
	 * @Description: 在district表中，找出给定城市的所有区县id和区县名
	 * @param cityid
	 * @return   
	 * List<Object[]>  
	 * @throws
	 * @author Guo
	 * @date 2016年7月1日 上午12:12:57
	 */
	public List<Object[]> getDistrict(int cityid){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object[]> list = new ArrayList<Object[]>();
		
		try {
			conn = getConnection(true);
			String sql = "select districtid,districtname from district where cityid=? order by districtid";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cityid);
			rs = ps.executeQuery();
			while(rs.next()){
				Object[] object = new Object[2];
				object[0]=rs.getInt(1);
				object[1]=rs.getString(2);
				list.add(object);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {ps.close();} catch (SQLException e) {e.printStackTrace();}	
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}	
		} 
		return null;
	}
}
