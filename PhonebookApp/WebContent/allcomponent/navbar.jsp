
<%@page import="com.entity.User" %>    

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="index.jsp"><i class="fa-solid fa-phone"></i>phonebook</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp"><i class="fa-solid fa-house"></i>home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="addcontact.jsp"><i class="fa-solid fa-plus"></i>add phone no</a>
      </li>
       
      <li class="nav-item active">
        <a class="nav-link " href="viewcontact.jsp"><i class="fa-solid fa-eye"></i>view contact</a>
      </li>
    </ul>
    <%
User u= (User)session.getAttribute("user");
    if(u==null){
%>
    <form class="form-inline my-2 my-lg-0">
    <a href="login.jsp" class="btn btn-success"><i class="fa-regular fa-user"></i>login</a>
    <a href="register.jsp" class="btn btn-danger ml-2"><i class="fa-solid fa-user"></i>register</a>
 
    </form>
    <%
    }else{
    %>
    <form class="form-inline my-2 my-lg-0">
    <button class="btn btn-success"><%=u.getName() %></button>
 <a data-toggle="modal" data-target="#exampleModal" class="btn btn-danger ml-2">logout</a>
    </form>
    <%
    }
    %>
    
 
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">do you want to logout</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
       <a href="logout"  class="btn btn-primary">logout</a>
      </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>
    
  </div>
</nav>