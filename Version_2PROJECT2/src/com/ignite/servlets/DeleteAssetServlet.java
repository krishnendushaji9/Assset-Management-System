package com.ignite.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ignite.jdbcdao.Asset_detJdbcDao;

/**
 * Servlet implementation class DeleteAssetServlet
 */
public class DeleteAssetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAssetServlet() {
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
			int ad_id = Integer.parseInt(request.getParameter("ad_id"));
			try {
				Asset_detJdbcDao assetDao = new Asset_detJdbcDao();
				if(assetDao.delete(ad_id)){
					assetDao.save();
				}
				else{
					assetDao.undo();
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
