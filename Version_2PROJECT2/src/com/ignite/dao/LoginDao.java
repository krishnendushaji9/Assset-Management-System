package com.ignite.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface LoginDao {
	boolean validate(String username, String password) throws IOException, ClassNotFoundException, IOException, SQLException;
}
