<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="index"> MOODAG <span
			style="font-size: 30px"></span></a>
		<!-- <p class="text-gray">A DEMANDED PRODUCT</p> -->
		<p class="text-centre"></p>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">

				<li class="nav-item active"><a class="nav-link" href="index">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="Jewellery">Jewellery</a>
				</li>


				<c:if test="${user.role=='ROLE_ADMIN'}">

					<li class="nav-item"><a class="nav-link" href="supplier">Supplier</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="category">Category</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="product">Product</a>
					</li>
				</c:if>


				<c:if test="${user.role!='ROLE_USER'}">

					<li class="nav-item"><a class="nav-link" href="user">User</a></li>

					<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
				</c:if>


				<li class="nav-item"><a class="nav-link" href="about">About</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="contact">Contact</a>
				</li>
				<!-- <li class="nav-item"><a class="nav-link" href="bill">Bill</a>
				</li> -->
				<c:if test="${user.role=='ROLE_USER'}">
					<li class="nav-item"><a class="nav-link" href="cart">Cart</a>
					</li>
				</c:if>
				<c:if test="${user.role=='ROLE_ADMIN'}">
					<li class="nav-item"><a class="nav-link" href="cart">Cart</a>
					</li>
				</c:if>




				<%-- <li class="nav-item"><a class="nav-link">Welcome
						${user.name}</a></li> --%>

				<div class="dropdown">
					<button type="button" class="btn btn-dark dropdown-toggle"
						data-toggle="dropdown">${user.name}</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="profile">Profile</a>
						<a class="dropdown-item" href="logout">Logout</a>
						
					</div>
				</div>
			</ul>
		</div>
	</div>
</nav>
