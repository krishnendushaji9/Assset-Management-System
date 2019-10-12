package com.ignite.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ignite.beans.Purchase_Det;
import com.ignite.jdbcdao.Purchase_DetJdbcDao;

/**
 * Servlet implementation class UpdateAssetServlet
 */
public class UpdatePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePurchaseServlet() {
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
			Purchase_DetJdbcDao purchase_detDao = new Purchase_DetJdbcDao();
			Purchase_Det purchase_det = (Purchase_Det)request.getAttribute("purchase_det");
			if(purchase_detDao.update(purchase_det)){
				purchase_detDao.save();
			}
			else{
				purchase_detDao.undo();
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
