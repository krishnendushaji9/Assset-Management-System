package com.ignite.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ignite.jdbcdao.Purchase_DetJdbcDao;

/**
 * Servlet implementation class DeleteAssetServlet
 */
public class DeletePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("username")!=null){
			int pd_id = Integer.parseInt(request.getParameter("pd_id"));
			try {
				Purchase_DetJdbcDao purchaseDao = new Purchase_DetJdbcDao();
				if(purchaseDao.delete(pd_id)){
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
		else{
			response.sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
