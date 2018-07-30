<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="template/navbar.jsp" %>

<div class="container">
<br>
<br>
<br>
<br>
<h1>Supplier</h1>
<br>
<br>
<center>
<form:form modelAttribute="supplier" action="${pageContext.request.contextPath}/${url}" method="post">

<form:hidden path="pid"/>
	<form:input path="name" placeholder=" Enter Supplier Name"/>
	<form:input path="discription" placeholder=" Enter Discription"/>
	<br>
	<br>
	<input type="submit" " class="btn btn-danger">
</form:form>

<br>
<br>

<table class="table">
  <thead class="thead-dark">
<tr>
	<th>SNo</th>
	<th>Name</th>
	<th>Discription</th>
	<th colspan="2">Action</th>
</tr>
</thead>

<tbody>
	<c:forEach items="${suplist}" var="sup">
		<tr>
			<td>${sup.pid}</td>
			<td>${sup.name}</td>
			<td>${sup.discription}</td>
			<td><a href="${pageContext.request.contextPath}/editSupplier/${sup.pid}" class="btn btn-info">Edit</a></td>
			<td><a href="${pageContext.request.contextPath}/DeleteSupplier/${sup.pid}" class="btn btn-danger">Delete</a></td>
		</tr>
	</c:forEach>
</tbody>

</table>
</center>

<hr/>
</div>