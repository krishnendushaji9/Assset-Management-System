package com.ignite.jdbcdao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.ignite.beans.Purchase_Det;


import com.ignite.dao.Purchase_DetDao;

public class Purchase_DetJdbcDao extends Dao implements Purchase_DetDao {

	public Purchase_DetJdbcDao() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insert(Purchase_Det pd) throws SQLException {
		
		boolean res = false;
		
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO Purchase_det(pd_order,pd_type,pd_qty,pd_vendor,pd_date,pd_ddate,pd_status,isactive) VALUES(?,?,?,?,?,?,?,'Y')");
		pstmt.setString(1, pd.getPd_order());
		pstmt.setString(2, pd.getPd_type());
		pstmt.setInt(3, pd.getPd_qty());
		pstmt.setString(4, pd.getPd_vendor());
		pstmt.setDate(5,Date.valueOf(pd.getPd_date()));
		pstmt.setDate(6,Date.valueOf(pd.getPd_ddate()));
		pstmt.setString(7, pd.getPd_status());
		if(1==pstmt.executeUpdate()){
			res = true;
		}
		return res;
	}

	@Override
	public boolean delete(int pd_id) throws SQLException {
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("UPDATE purchase_det SET isactive='N' WHERE pd_id=?");
		pstmt.setInt(1,pd_id);
		if(1==pstmt.executeUpdate()){
			res = true;
		}
		return res;
	}
	

	@Override
	public Purchase_Det find(int pd_id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Purchase_Det purchase_det= null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try{
			con = getConnection();
			con.commit();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM purchase_det WHERE pd_id = "+pd_id);
			if(rs.next()){
				
				purchase_det = new Purchase_Det();
				purchase_det.setPd_id(rs.getInt("pd_id"));
				purchase_det.setPd_order(rs.getString("pd_order"));
				purchase_det.setPd_type(rs.getString("pd_type"));
				purchase_det.setPd_qty(rs.getInt("pd_qty"));
				purchase_det.setPd_vendor(rs.getString("pd_vendor"));
				purchase_det.setPd_status(rs.getString("pd_status"));
				
				
				java.util.Date pdDate = rs.getTimestamp("pd_date");
				java.util.Date pdDdate = rs.getTimestamp("pd_ddate");
				
			
				purchase_det.setPd_date(df.format(pdDate));
				purchase_det.setPd_ddate(df.format(pdDdate));
		
			
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
		return purchase_det;
	}

	

	@Override
	public boolean update(Purchase_Det pd) throws SQLException {
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("UPDATE purchase_det SET pd_order=?,pd_type=?,pd_qty=?,pd_vendor=?,pd_date=?,pd_ddate=?,pd_status=?  WHERE pd_id=?");
		
		pstmt.setString(1, pd.getPd_order());
		pstmt.setString(2, pd.getPd_type());
		pstmt.setInt(3, pd.getPd_qty());
		pstmt.setString(4, pd.getPd_vendor());
		pstmt.setDate(5,Date.valueOf(pd.getPd_date()));
		pstmt.setDate(6,Date.valueOf(pd.getPd_ddate()));
		pstmt.setString(7, pd.getPd_status());
		pstmt.setInt(8,pd.getPd_id());
		if(1==pstmt.executeUpdate()){
			res = true;
		}
		return res;
	}

	@Override
	public List<Purchase_Det> findAll() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<Purchase_Det> purchase_dets = new ArrayList<>() ;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		try{
			con = getConnection();
			con.commit();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM purchase_det where isactive='Y'");
			while(rs.next()){
				Purchase_Det purchase_det = new Purchase_Det();
				purchase_det.setPd_id(rs.getInt("pd_id"));
				purchase_det.setPd_order(rs.getString("pd_order"));
				purchase_det.setPd_type(rs.getString("pd_type"));
				purchase_det.setPd_qty(rs.getInt("pd_qty"));
				purchase_det.setPd_vendor(rs.getString("pd_vendor"));
				
				purchase_det.setPd_status(rs.getString("pd_status"));
				java.util.Date pdDate = rs.getTimestamp("pd_date");
				java.util.Date pdDdate = rs.getTimestamp("pd_ddate");
				
				
				purchase_det.setPd_date(df.format(pdDate));
				purchase_det.setPd_ddate(df.format(pdDdate));
				
				
				
				purchase_dets.add(purchase_det);
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
		return purchase_dets;
	}

}

