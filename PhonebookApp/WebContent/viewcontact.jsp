<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="com.conn.Dbconnect" %>    
<%@page import="com.dao.Conatctdao" %>   
<%@page import=" java.util.List" %>
<%@page import="com.entity.*" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allcomponent/allcss.jsp" %>
<style type="text/css">
.c-ho:hover{
background-color:lightgrey;
}
</style>

</head>
<body>
<%@include file="allcomponent/navbar.jsp" %>
<%if(u==null){
		response.sendRedirect("login.jsp");
		HttpSession session2=request.getSession();
session2.setAttribute("logmsg","login please");
	}%>
	<%
					String updatemsg=(String)session.getAttribute("updatemsg");
					if(updatemsg!=null){
					%>
					<p class="text-center text-success"><%=updatemsg %></p>
					<%
					session.removeAttribute("updatemsg");

					}
					%>
					
					<%
					String deletemsg=(String)session.getAttribute("deletemsg");
					if(deletemsg!=null){
					%>
					<p class="text-center text-success"><%=deletemsg %></p>
					<%
					session.removeAttribute("deletemsg");

					}
					%>
					<%
					String deletemsg2=(String)session.getAttribute("deletemsg2");
					if(deletemsg2!=null){
					%>
					<p class="text-center text-success"><%=deletemsg2 %></p>
					<%
					session.removeAttribute("deletemsg2");

					}
					%>
					
	
	<%
	if(u!=null){
	Conatctdao dao= new Conatctdao(Dbconnect.getconn());
	List<Contact> contact= dao.getallcontact(u.getId());
	for (Contact c: contact){
	%>
				<div style="float:right;" class="container">
	
							<div  class="row p-4">	
	
	<div class="col-md-3">
	<div class="card c-ho">
	<div class="card-body">
	<h5>name:<%=c.getName() %></h5>
	<p>ph no:<%=c.getPhoneno() %></p>
	<p>email:<%=c.getEmail() %></p>
	<p>about:<%=c.getAbout() %></p>
	<div class="text-center">
	<a href="edit.jsp?cid=<%=c.getId() %>" class="btn btn-success btn-sm text-white">edit</a>
	<a href="delete?cid=<%=c.getId() %>" class="btn btn-danger btn-sm text-white">delete</a>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	<%
	}
	}
	%>
	
</body>
</html>