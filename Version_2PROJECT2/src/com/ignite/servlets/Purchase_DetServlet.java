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
 * Servlet implementation class Purchase_DetServlet
 */
public class Purchase_DetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Purchase_DetServlet() {
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
			Purchase_DetJdbcDao purchaseDao = new Purchase_DetJdbcDao();
			Purchase_Det purchase_det = (Purchase_Det)request.getAttribute("purchase_det");
			if(purchaseDao.insert(purchase_det)){
				purchaseDao.save();
			}
			else{
				purchaseDao.undo();
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


