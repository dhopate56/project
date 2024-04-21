package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.Dbconnect;
import com.dao.Userdao;
import com.entity.User;
@WebServlet("/register")

	public class Registerservlet extends HttpServlet {
		
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	User u= new User(name,email,password);
	Userdao dao= new Userdao(Dbconnect.getconn());
	boolean f=dao.userregister(u);
	HttpSession session=request.getSession();
	if(f) {
		session.setAttribute("success", "user registered successfully");
		response.sendRedirect("register.jsp");
		}else {
			session.setAttribute("error", "user registeration failed");
			response.sendRedirect("register.jsp");

		}

	}
	}


