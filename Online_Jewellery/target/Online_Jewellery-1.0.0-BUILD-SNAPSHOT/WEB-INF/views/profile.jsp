<%@include file="template/navbar.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="template/navbar.jsp"%>
<br>
<br>
<br>
<br>
<div class="container" style="margin-left:"90px;">
	<h1>
		<a href="#" class="text-info">User Profile</a>
	</h1>
	<br>
	<div class="row" style="margin-left:"400px;">
		<div>
			<form:form modelAttribute="user"
				action="${pageContext.request.contextPath}/userupdate" method="post">
				<form:hidden path="sid" />


				<form:input path="name" placeholder=" Enter Name." />

				<form:input path="email" placeholder=" Enter Email." />
				<form:hidden path="password" />

				<form:input path="address" placeholder=" Enter Address." />

				<form:input path="mobile" placeholder=" Enter Mobile No." />
				<form:hidden path="one_time_password" />
				<form:hidden path="enable" />
				<form:hidden path="role" />
				</br>
				</br>
				<input type="submit" class="btn btn-warning" />

				<div class="<div class=col-xs-12 col-md-8"
					style="font-size: 12pt; line-height: 2em;">

					<h1>User Details:</h1>
					<ul>
						<li>
							<p>Name : ${user.name}</p>
						</li>

						<li><p>Email : ${user.email}</p></li>

						<li><p>Mobile : ${user.mobile}</p></li>

						<li><p>Address : ${user.address}</p></li>


					</ul>
				</div>
		</div>
		</form:form>
	</div>