package com.ignite.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ignite.beans.Asset_det;

public interface Asset_detDao {
	boolean insert(Asset_det ad) throws SQLException;
    boolean update(Asset_det ad) throws SQLException;
    boolean delete(int ad_id) throws SQLException;
    
    Asset_det find(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
    List<Asset_det> findAll() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
}