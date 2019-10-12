package com.ignite.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ignite.beans.Purchase_Det;

public interface Purchase_DetDao {
	boolean insert(Purchase_Det pd) throws SQLException;
    boolean update(Purchase_Det pd) throws SQLException;
    boolean delete(int pd_id) throws SQLException;
    
    Purchase_Det find(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
    List<Purchase_Det> findAll() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
}