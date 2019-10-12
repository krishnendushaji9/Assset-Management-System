package com.ignite.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ignite.beans.Asset_Master;

public interface Asset_MasterDao {
	boolean insert(Asset_Master ad) throws SQLException;
    boolean update(Asset_Master ad) throws SQLException;
    boolean delete(int ad_id) throws SQLException;
    
    Asset_Master find(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
    List<Asset_Master> findAll() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
} 