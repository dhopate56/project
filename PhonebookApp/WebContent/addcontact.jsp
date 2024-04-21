<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
<%@page import="com.conn.Dbconnect" %>    
<%@page import="com.entity.User" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allcomponent/allcss.jsp" %>
</head>
<body>
<%@include file="allcomponent/navbar.jsp" %>
<%if(u==null){
		response.sendRedirect("login.jsp");
		HttpSession session2=request.getSession();
session2.setAttribute("logmsg","login please");
	}%>
<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-success">add contact page</h4>
					<%
					String success=(String)session.getAttribute("conmsg");
					String error=(String)session.getAttribute("failmsg");
					if(success!=null){
					%>
					<p class="text-center text-success"><%=success %></p>
					<%
					session.removeAttribute("conmsg");

					}
					if(error!=null){
					%>
					<p class="text-center text-danger"><%=error %></p>
					<%
					session.removeAttribute("failmsg");
					}
					%>
				<%if(u!=null){
				%>
					<input type="hidden" value="<%=u.getId() %>" name="userid">
					<%
				}
					%>
							<form action="addcontactservlet" method="post">
							
							<%if(u!=null){
				%>
							
							<div class="form-group">
								<label for="exampleInputEmail1"></label> <input name="userid2"
									type="hidden" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" value="<%=u.getId() %>" >
							</div>
							<%
				}
					%>
						
							
							
							<div class="form-group">
								<label for="exampleInputEmail1">enter name</label> <input name="name"
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  >
							</div>
							
							<div class="form-group">
								<label for="exampleInputEmail2"> enter Email address</label> <input name="email"
									type="email" class="form-control" id="exampleInputEmail2"
									aria-describedby="emailHelp" >
							</div>
								<div class="form-group">
								<label for="exampleInputEmail3"> enter phone no</label> <input name="phone"
									type="text" class="form-control" id="exampleInputEmail3"
									aria-describedby="emailHelp" >
							</div>
							<textarea rows="10" cols="60" placeholder="enter about" name="about"></textarea>
							
<div class="text-center">
							<button type="submit" class="btn btn-primary">add contact</button>
	</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>