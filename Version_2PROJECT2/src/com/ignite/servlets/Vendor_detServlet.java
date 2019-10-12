package com.ignite.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignite.beans.Vendor_Det;
import com.ignite.jdbcdao.Vendor_detJdbcDao;

/**
 * Servlet implementation class Vendor_detServlet
 */
public class Vendor_detServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vendor_detServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			Vendor_detJdbcDao vendorDao = new Vendor_detJdbcDao();
			Vendor_Det vendor_det = (Vendor_Det)request.getAttribute("vendor_det");
			if(vendorDao.insert(vendor_det)){
				vendorDao.save();
			}
			else{
				vendorDao.undo();
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