package com.ignite.jdbcdao;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.ignite.beans.Vendor_Det;
import com.ignite.dao.Vendor_DetDao;


public class Vendor_detJdbcDao extends Dao implements Vendor_DetDao {

	public Vendor_detJdbcDao() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insert(Vendor_Det vd) throws SQLException {
		
		boolean res = false;
		
		
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO vendor_det(vd_name,vd_type,vd_atype,vd_from,vd_to,vd_addr,isactive) VALUES(?,?,?,?,?,?,'Y')");
		pstmt.setString(1,vd.getVd_name());
		pstmt.setString(2,vd.getVd_type());
		pstmt.setString(3,vd.getVd_atype());
		pstmt.setDate(4,java.sql.Date.valueOf(vd.getVd_from()));
		pstmt.setDate(5,java.sql.Date.valueOf(vd.getVd_to()));
		pstmt.setString(6,vd.getVd_addr());
		
		if(1==pstmt.executeUpdate()){
			res = true;
		}
		return res;
	}
	@Override
	public boolean update(Vendor_Det vd) throws SQLException {
		
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("UPDATE vendor_det SET vd_name=?,vd_type=?,vd_atype=?,vd_from=?,vd_to=?,vd_addr=? WHERE vd_id=?");
		pstmt.setString(1,vd.getVd_name());
		pstmt.setString(2,vd.getVd_type());
		pstmt.setString(3,vd.getVd_atype());
		pstmt.setDate(4,java.sql.Date.valueOf(vd.getVd_from()));
		pstmt.setDate(5,java.sql.Date.valueOf(vd.getVd_to()));
		pstmt.setString(6,vd.getVd_addr());
		pstmt.setInt(7, vd.getVd_id());
		if(1==pstmt.executeUpdate()){
			res = true;
		}
		return res;
	}

	@Override
	public boolean delete(int vd_id) throws SQLException {
		// TODO Auto-generated method stub
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("UPDATE vendor_det SET isactive='N' WHERE vd_id=?");
		pstmt.setInt(1,vd_id);
		if(1==pstmt.executeUpdate()){
			res = true;
		}
		return res;
	}

	@Override
	public Vendor_Det find(int vd_id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Vendor_Det vendor_det= null;
		Connection con = null;
		Statement stmt = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		ResultSet rs = null;
		
		try{
			con = getConnection();
			con.commit();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM vendor_det WHERE vd_id = "+vd_id);
			if(rs.next()){
				vendor_det = new Vendor_Det();
				vendor_det.setVd_id(rs.getInt("vd_id"));
				vendor_det.setVd_name(rs.getString("vd_name"));                            
				vendor_det.setVd_type(rs.getString("vd_type"));
				vendor_det.setVd_atype(rs.getString("vd_atype"));
				
				vendor_det.setVd_addr(rs.getString("vd_addr"));
				Date vdFrom = rs.getTimestamp("vd_from");
				Date vdTo = rs.getTimestamp("vd_to");
				
			
				vendor_det.setVd_from(df.format(vdFrom));
				vendor_det.setVd_to(df.format(vdTo));
				
				
			}}
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
		return vendor_det;
	}

	@Override
	public List<Vendor_Det> findAll() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		// TODO Auto-generated method stub
		ArrayList<Vendor_Det> vendor_dets = new ArrayList<>() ;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try{
			con = getConnection();
			con.commit();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM vendor_det where isactive='Y'");
			
			while(rs.next()){
				Vendor_Det vendor_det = new Vendor_Det();
				vendor_det.setVd_id(rs.getInt("vd_id"));
				vendor_det.setVd_name(rs.getString("vd_name"));                            
				vendor_det.setVd_type(rs.getString("vd_type"));
				vendor_det.setVd_atype(rs.getString("vd_atype"));
				vendor_det.setVd_addr(rs.getString("vd_addr"));
				Date vdFrom = rs.getTimestamp("vd_from");
				Date vdTo = rs.getTimestamp("vd_to");
				
				
				vendor_det.setVd_from(df.format(vdFrom));
				vendor_det.setVd_to(df.format(vdTo));
				
				vendor_dets.add(vendor_det);
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
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
		return vendor_dets;
	}

}