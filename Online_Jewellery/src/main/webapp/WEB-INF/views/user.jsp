<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="template/navbar.jsp"%>

<div class="container">
	<br> <br> <br> <br>
	<h1>User</h1>
	<center>
		<form:form modelAttribute="user"
			action="${pageContext.request.contextPath}/${url}" method="post">
			<form:hidden path="sid" />
			<form:input path="name" placeholder=" Enter Name." />
			<form:input path="email" placeholder=" Enter Email."  />
			<form:input path="password" type="password" placeholder=" Enter Password." />
			<form:input path="address"  placeholder=" Enter Address." />
			
			<form:input path="mobile" placeholder=" Enter Mobile No." />
			<form:input path="one_time_password" type="password" placeholder=" Enter OTP." />
			</br>
			</br>
			
			</br>
			<input type="submit" class="btn btn-success" />
			<input type="button" class="btn btn-danger" value="OTP Verify" />
		</form:form>
</center>

	<hr />
</div>