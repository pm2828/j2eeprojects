<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.User"%>
    <%@page import="model.User"%>
<%@page import="model.Cart"%>
<%@page import="model.Product"%>
<%@page  import=" java.util.List" %>
<%@page import="java.util.*"%>
     <%
    
 User auth  = (User) request.getSession().getAttribute("auth");
    
    if(auth != null){
    	request.setAttribute("auth", auth);
    	
    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	 List<Cart> cartProduct = null;
	 if (cart_list != null) {
	 	request.setAttribute("cart_list", cart_list);
	 }
    %>
<!DOCTYPE html>
<html>
<head>


<title>Shopping Cart Log In</title>
<%@include file="includes/header.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

<div class="container text-bold">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="user-login" method="post">
					<div class="form-group">
						<label>Email address</label> 
						<input type="email" name="login-email" id="username" class="form-control" placeholder="Enter email" autocomplete="off" required>
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="login-password" id="password" class="form-control" placeholder="Password" autocomplete="off"  required>
						
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>



<%@include file="includes/footer.jsp" %>
</body>

</html>