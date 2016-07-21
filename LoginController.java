package com.niit.shoppingcart;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UserID = request.getParameter("UserID");
		String Password = request.getParameter("Password");
		
		LoginDAO loginDAO = new LoginDAO();
		RequestDispatcher dispatcher;
		if(loginDAO.isValidUser(UserID, Password) == true)
		{
			//Navigate to Home Page
			dispatcher = request.getRequestDispatcher("Home.html");
			dispatcher.forward(request, response);
		}
		else
		{
			//Navigate to Login Page with Error message
			dispatcher = request.getRequestDispatcher("Login.html");
			PrintWriter writer = response.getWriter();
			writer.append("Invalid credentials...Please try again");
			dispatcher.include(request, response);
		}
	}

}
