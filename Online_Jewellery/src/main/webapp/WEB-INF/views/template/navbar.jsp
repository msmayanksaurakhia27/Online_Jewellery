<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/index"> MOODAG <span
			style="font-size: 30px"></span></a>
		<!-- <p class="text-gray">A DEMANDED PRODUCT</p> -->
		<p class="text-centre"></p>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>

		</button>

		<form class="form-inline" style="margin-left: 150px;"
			action="${pageContext.request.contextPath}/search">
			<input class="form-control mr-sm-2" type="text" name="s"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>

		<div class="collapse navbar-collapse " id="navbarResponsive">
			<ul class="navbar-nav ml-auto">

				<!-- <li class="nav-item active"><a class="nav-link" href="index">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="Jewellery">Jewellery</a>
				</li> -->
			
				<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/index">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/Jewellery">Jewellery</a>
				</li>
				
				
				<c:if test="${loggedin == true}">
					<c:if test="${user.role=='ROLE_ADMIN'}">

						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/supplier">Supplier</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/category">Category</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/product">Product</a>
						</li>
					</c:if>

					<c:if test="${user.role=='ROLE_USER'}">
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/cart">Cart</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/about">About</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a>
						</li>
					</c:if>
					<div class="dropdown">
					<button type="button" class="btn btn-dark dropdown-toggle"
						data-toggle="dropdown">${user.name}</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="${pageContext.request.contextPath}/profile">Profile</a> <a
							class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a>

					</div>
				</div>
					
				</c:if>

				<c:if test="${loggedin == null}">
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/user">User</a></li>

					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/about">About</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a>
					</li>
				</c:if>




				<%-- <li class="nav-item"><a class="nav-link">Welcome
						${user.name}</a></li> --%>

							</ul>

		</div>
	</div>
</nav>
