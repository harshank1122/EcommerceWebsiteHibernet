package com.ecommerce.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.Entity_class;
import com.ecommerce.user.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String userName = request.getParameter("name");
			String userEmail = request.getParameter("email");
			String userPassWord = request.getParameter("password");
			String userNumber = request.getParameter("number");
			String userAddress = request.getParameter("address");
			
			
			// Creating User object to store data
	        User user = new User(userName, userEmail,userPassWord, userNumber, "defult.jsp", userAddress , "normal" );
	        Entity_class entity_class = new  Entity_class();
	        if(entity_class.saveuser(user)) {
	        	HttpSession session = request.getSession();
		        session.setAttribute("message", "Registration successful!");
		        response.sendRedirect("register.jsp");
		        return;
	        }
	        else {
	        	HttpSession session = request.getSession();
		        session.setAttribute("message", "Alrady register");
		        response.sendRedirect("register.jsp");
		        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
