package com.ignite.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignite.beans.Vendor_Det;
import com.ignite.jdbcdao.Vendor_detJdbcDao;

/**
 * Servlet implementation class UpdateVendorServlet
 */
@WebServlet("/updatevendor")
public class UpdateVendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVendorServlet() {
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
		// TODO Auto-generated method stub
		try {
			Vendor_detJdbcDao vendor_detDao = new Vendor_detJdbcDao();
			Vendor_Det vendor_det = (Vendor_Det)request.getAttribute("vendor_det");
			if(vendor_detDao.update(vendor_det)){
				vendor_detDao.save();
			}
			else{
				vendor_detDao.undo();
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
