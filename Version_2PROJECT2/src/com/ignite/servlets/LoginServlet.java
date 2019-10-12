package com.ignite.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ignite.jdbcdao.LoginJdbcDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginJdbcDao loginDao;
		try {
			loginDao = new LoginJdbcDao();
			if(loginDao.validate(username, password)){
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				RequestDispatcher rd = request.getRequestDispatcher("Homepage.jsp");
				rd.forward(request, response);
			}
			else{
				String err="Invalid Username or Password";
				response.sendRedirect("Login.jsp?error="+err);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// This exception should be logged
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// This exception should be logged
			e.printStackTrace();
		}
		
	}

}
