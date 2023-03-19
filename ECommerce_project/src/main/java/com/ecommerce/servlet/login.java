package com.ecommerce.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.Entity_class;
import com.ecommerce.user.User;

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			HttpSession session = request.getSession();
			String userEmail = request.getParameter("email");
			String userPassWord = request.getParameter("password");
		
			Entity_class entity_class = new  Entity_class();
	        User user = entity_class.getUserByEmailPass(userEmail , userPassWord );
	    
	        if(user==null) {
		        session.setAttribute("loginSms", "Incorrect user and pass");
		        response.sendRedirect("login.jsp");
		        return;
	        }
	        else {
	        	session.setAttribute("current-user",user);
	        	if(user.getUserType().equals("admin")) {
	        		response.sendRedirect("admin.jsp");
	        	}
	        	else if(user.getUserType().equals("normal")) {
	        		response.sendRedirect("index.jsp");
	        	}
	        }
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
