<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allcomponent/allcss.jsp"%>
</head>
<body style="background-color:grey">
	<%@include file="allcomponent/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center text-success">Registration page</h4>
					<%
					String success=(String)session.getAttribute("success");
					String error=(String)session.getAttribute("error");
					if(success!=null){
					%>
					<p class="text-center text-success"><%=success %></p>
					<%
					session.removeAttribute("success");

					}
					if(error!=null){
					%>
					<p class="text-center text-danger"><%=error %></p>
					<%
					session.removeAttribute("error");
					}
					%>
					
						<form action="register" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">enter name</label> <input name="name"
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" >
							</div>
							<div class="form-group">
								<label for="exampleInputEmail2">Email address</label> <input name="email"
									type="email" class="form-control" id="exampleInputEmail2"
									aria-describedby="emailHelp" >
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input name="password"
									type="password" class="form-control" id="exampleInputPassword1"
									>
							</div>
<div class="text-center">
							<button type="submit" class="btn btn-primary">register</button>
	</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<div style="margin-top:200px">
	<%@include file="allcomponent/footer.jsp" %>
	
	</div>
</body>
</html>