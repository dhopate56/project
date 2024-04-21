package com.servlet;
import com.entity.*;
import com.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.Dbconnect;
import com.dao.Userdao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Conatctdao;
import com.entity.Contact;

/**
 * Servlet implementation class Updatec
 */
@WebServlet("/Updatec")
public class Updatec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid=Integer.parseInt(request.getParameter("userid2"));
		String email= request.getParameter("email");
		String phone= request.getParameter("phone");
		String about= request.getParameter("about");
		String name= request.getParameter("name");
		int cid=Integer.parseInt(request.getParameter("id"));
Contact c= new Contact();
c.setUserid(userid);
	c.setEmail(email);
	c.setPhoneno(phone);
	c.setAbout(about);
	c.setName(name);
	c.setId(cid);
	Conatctdao dao= new Conatctdao(Dbconnect.getconn());
	boolean f= dao.updatecontact(c);
	HttpSession session=request.getSession();

	if(f) {
		session.setAttribute("updatemsg", "update success");
		response.sendRedirect("viewcontact.jsp");
	}else {
		session.setAttribute("updatef", "update failed");
		response.sendRedirect("edit.jsp?cid="+cid);

}
	}

}
