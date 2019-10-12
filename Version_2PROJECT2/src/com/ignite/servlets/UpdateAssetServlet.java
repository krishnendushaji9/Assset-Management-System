package com.ignite.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignite.beans.Asset_det;
import com.ignite.jdbcdao.Asset_detJdbcDao;

/**
 * Servlet implementation class UpdateAssetServlet
 */
public class UpdateAssetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAssetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Asset_detJdbcDao asset_detDao = new Asset_detJdbcDao();
			Asset_det asset_det = (Asset_det)request.getAttribute("asset_det");
			if(asset_detDao.update(asset_det)){
				asset_detDao.save();
			}
			else{
				asset_detDao.undo();
			}
			RequestDispatcher rd = request.getRequestDispatcher("Homepage.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// Properly log this exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// Properly log this exception
			e.printStackTrace();
		}
		
	}
}
