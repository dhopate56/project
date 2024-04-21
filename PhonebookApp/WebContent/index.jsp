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
<style type="text/css">
.back-img{
background: url("img/R.jpg");
width:100%;
height:80vh;
background-repeat: no-repeat;
background-size:cover;
}
</style>
</head>
<body>
<%@include file="allcomponent/navbar.jsp" %>



<div class="container-fluid back-img text-center text-success">
<h1 class="mt-3">welcome to phonebook app</h1>

</div>
<%@include file="allcomponent/footer.jsp" %>

</body>
</html>