
<nav class="navbar navbar-expand-xl navbar-dark bg-dark border">
  <div class="container">
    <a class="navbar-brand" href="index.jsp">
      <img src="https://cdn.pixabay.com/photo/2019/04/26/07/14/store-4156934_1280.png " alt="Logo"  height="100" width="100" class="mr-2 navbar-logo rounded-circle">
      PM SHOP
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
      data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false"
      aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto ">
				<li class="nav-item mr-3"><a class="nav-link" href="index.jsp" style="font-family: Arial, sans-serif;color:white;">Home</a></li>
				<li class="nav-item mr-3"><a class="nav-link" href="cart.jsp" style="font-family: Arial, sans-serif;color:white;"><i class="fas fa-shopping-cart white-icon"></i><span class="badge badge-danger">${cart_list.size()}</span> </a></li>
				<%
				if (auth != null) {
				%>
				<li class="nav-item mr-3"><a class="nav-link" href="orders.jsp" style="font-family: Arial, sans-serif;color:white">Orders</a></li>
				<li class="nav-item mr-3"><a class="nav-link" href="log-out" style="font-family: Arial, sans-serif;color:white">Logout</a></li>
				<%
				} else {
				%>
				<li class="nav-item mr-2"><a class="nav-link" href="login.jsp" style="font-family: Arial, sans-serif;color:white">Login</a></li>
				<%
				}
				%>
				<li class="nav-item mr-2">
					<form class="form-inline my-2 my-lg-0">
						<input  id="searchInput" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
						<button  id="searchBtn" class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
					</form>
				</li>
			</ul>
		
		</div>
	</div>
</nav>
