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

@WebServlet("/addcontactservlet")
public class AddCservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int userid=Integer.parseInt(request.getParameter("userid"));
		int userid=Integer.parseInt(request.getParameter("userid2"));
		String email= request.getParameter("email");
		String phone= request.getParameter("phone");
		String about= request.getParameter("about");
		String name= request.getParameter("name");
//		System.out.println(name );

		Contact c =new Contact(name,phone,email,about,userid);
		Conatctdao dao= new Conatctdao(Dbconnect.getconn());
		boolean f= dao.addcontact(c);
		HttpSession session=request.getSession();

		if(f) {
			System.out.println("contact add success");
			session.setAttribute("conmsg", "conatact added success");
			response.sendRedirect("addcontact.jsp");
		}else {
			System.out.println("contact add failed");
			session.setAttribute("failmsg", "conatact added fail");
			response.sendRedirect("addcontact.jsp");

	}

}
}
