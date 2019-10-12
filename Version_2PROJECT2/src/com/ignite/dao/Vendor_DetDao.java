package com.ignite.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ignite.beans.Vendor_Det;

public interface Vendor_DetDao {

	boolean insert(Vendor_Det vd) throws SQLException;
    boolean update(Vendor_Det vd) throws SQLException;
    boolean delete(int vd_id) throws SQLException;
    
    Vendor_Det find(int vd_id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
    List<Vendor_Det> findAll() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
}
