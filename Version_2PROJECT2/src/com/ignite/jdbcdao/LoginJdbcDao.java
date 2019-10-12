package com.ignite.jdbcdao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ignite.dao.LoginDao;

public class LoginJdbcDao extends Dao implements LoginDao {

	public LoginJdbcDao() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate(String username, String password)
			throws IOException, ClassNotFoundException, IOException, SQLException {
		Connection con = getConnection();

		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM login WHERE username=? AND password=?");
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}

}
