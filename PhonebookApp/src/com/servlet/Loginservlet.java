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
@WebServlet("/login")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String email= request.getParameter("email");
String password= request.getParameter("password");
Userdao dao= new Userdao(Dbconnect.getconn());
User u= dao.login(email, password);
HttpSession session=request.getSession();

if (u!=null) {
	System.out.println("user is available"+u);
	session.setAttribute("user", u);
	response.sendRedirect("index.jsp");
	}else {
		session.setAttribute("failed", "user login failed");
		response.sendRedirect("login.jsp");
		System.out.println("user is not available"+u);

}
	}
}
