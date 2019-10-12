package com.ignite.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ignite.jdbcdao.Vendor_detJdbcDao;
/**
 * Servlet implementation class DeleteVendorServlet
 */
@WebServlet("/deletevendor")
public class DeleteVendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteVendorServlet() {
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
			int vd_id = Integer.parseInt(request.getParameter("vd_id"));
			try {
				Vendor_detJdbcDao vendorDao = new Vendor_detJdbcDao();
				if(vendorDao.delete(vd_id)){
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
