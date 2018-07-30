<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="template/navbar.jsp"%>

<div class="container">
	<br> <br> <br> <br>
	<h1>Product</h1>
	<vr class="container">
	<center>
		<form:form modelAttribute="product"
			action="${pageContext.request.contextPath}/${url}" method="post"
			enctype="multipart/form-data">
			<form:hidden path="sid" />
			NAME    :<form:input path="name" placeholder="Enter Name" />
			<br />
			</br>
			PRICE   :<form:input path="price" placeholder="Enter price" />
			<br />
			</br>
			STOCK   :<form:input path="stock" placeholder=" Enter Stock." />
			<br />
			</br>
			BRAND   :<form:input path="brand" placeholder=" Enter Brand." />
			<br />
			</br>
			CATEGORY:<form:select path="categoryId"  items="${catlist}" itemLabel="name" itemValue="pid" />
			<br />
			</br>
			SUPPLIER:<form:select path="supplierId" items="${supplist}" itemLabel="name" itemValue="pid" />
			<br />
			</br>
			</br>
			Image 1<input name="file1" type="file" />
			<br />
			Image 2<input name="file2" type="file">
			<br />
			Image 3<input name="file3" type="file">
			<br />
			Image 4<input name="file4" type="file">
			<br/>
			<br>
			<input type="submit" class="btn btn-success" />
		</form:form>
		<br> <br>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>SNo</th>
					<th>Name</th>
					<th>Price</th>
					<th>Stock</th>
					<th>Brand</th>
					<th>CategoryID</th>
					<th>SupplierID</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${prodlist}" var="prod">
					<tr>
						<td>${prod.sid}</td>
						<td>${prod.name}</td>
						<td>${prod.price}</td>
						<td>${prod.stock}</td>
						<td>${prod.brand}</td>
						<td>${prod.categoryId}</td>
						<td>${prod.supplierId}</td>
						<td><img class="slide-image"
							src="${pageContext.request.contextPath}/resources/images/product/${prod.code}/1.jpg"
							alt="" height="200px" width="200px"></td>
						<td><a
							href="${pageContext.request.contextPath}/editProduct/${prod.sid}"
							class="btn btn-info">Edit</a></td>
						<td><a
							href="${pageContext.request.contextPath}/DeleteProduct/${prod.sid}"
							class="btn btn-danger">Delete</a></td>
					</tr>
					<div class="item"></div>
				</c:forEach>
			</tbody>

		</table>
	</center>

	<hr />
</div>
</vr>