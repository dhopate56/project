package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.Dbconnect;
import com.dao.Conatctdao;

/**
 * Servlet implementation class DeleteC
 */
@WebServlet("/delete")
public class DeleteC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid=Integer.parseInt(request.getParameter("cid"));
		Conatctdao dao=new Conatctdao(Dbconnect.getconn());
		boolean f=dao.deletecontact(cid);
		HttpSession session=request.getSession();

		if(f) {
			session.setAttribute("deletemsg", "delete success");
			response.sendRedirect("viewcontact.jsp");
		}
		else {
			session.setAttribute("deletemsg2", "delete failed");
			response.sendRedirect("viewcontact.jsp");
	}

}
}
