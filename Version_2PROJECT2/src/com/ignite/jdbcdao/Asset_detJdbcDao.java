package com.ignite.jdbcdao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ignite.beans.Asset_det;
import com.ignite.dao.Asset_detDao;

public class Asset_detJdbcDao extends Dao implements Asset_detDao {

	public Asset_detJdbcDao() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insert(Asset_det ad) throws SQLException {
		
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO asset_det(ad_name,ad_type,ad_class,isactive) VALUES(?,?,?,'Y')");
		pstmt.setString(1, ad.getAd_name());
		pstmt.setString(2, ad.getAd_type());
		pstmt.setString(3, ad.getAd_class());
		
		if(1==pstmt.executeUpdate()){
			res = true;
		}
		return res;
	}

	@Override
	public boolean delete(int ad_id) throws SQLException {
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("UPDATE asset_det SET isactive='N' WHERE ad_id=?");
		pstmt.setInt(1,ad_id);
		if(1==pstmt.executeUpdate()){
			res = true;
		}
		return res;
	}

	@Override
	public Asset_det find(int ad_id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Asset_det asset_det= null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			con.commit();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM asset_det WHERE ad_id = "+ad_id);
			if(rs.next()){
				asset_det = new Asset_det();
				asset_det.setAd_id(rs.getInt("ad_id"));
				asset_det.setAd_name(rs.getString("ad_name"));
				asset_det.setAd_type(rs.getString("ad_type"));
				asset_det.setAd_class(rs.getString("ad_class"));
			}
		}
		finally{
			try{
				rs.close();
			}
			catch(SQLException e){
				throw e;
			}
			try{
				stmt.close();
			}
			catch(SQLException e){
				throw e;
			}
			try{
				con.close();
			}
			catch(SQLException e){
				throw e;
			}
		}
		return asset_det;
	}

	

	@Override
	public boolean update(Asset_det ad) throws SQLException {
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("UPDATE asset_det SET ad_name=?, ad_type=?, ad_class=? WHERE ad_id=?");
		pstmt.setString(1, ad.getAd_name());
		pstmt.setString(2, ad.getAd_type());
		pstmt.setString(3, ad.getAd_class());
		pstmt.setInt(4, ad.getAd_id());
		if(1==pstmt.executeUpdate()){
			res = true;
		}
		return res;
	}

	@Override
	public List<Asset_det> findAll() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<Asset_det> asset_dets = new ArrayList<>() ;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			con = getConnection();
			con.commit();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM asset_det where isactive='Y'");
			while(rs.next()){
				Asset_det asset_det = new Asset_det();
				asset_det.setAd_id(rs.getInt("ad_id"));
				asset_det.setAd_name(rs.getString("ad_name"));
				asset_det.setAd_type(rs.getString("ad_type"));
				asset_det.setAd_class(rs.getString("ad_class"));
				
				asset_dets.add(asset_det);
			}
			
		}
		finally{
			try{
				rs.close();
			}
			catch(SQLException e){
				throw e;
			}
			try{
				stmt.close();
			}
			catch(SQLException e){
				throw e;
			}
			try{
				con.close();
			}
			catch(SQLException e){
				throw e;
			}
		}
		return asset_dets;
	}

	}

