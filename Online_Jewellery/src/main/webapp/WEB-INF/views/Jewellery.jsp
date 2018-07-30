<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="template/navbar.jsp"%>
<div>
	<div class="row"
		style="margin-top: 150px; margin-left: 150px; margin-right: 100px; margin-bottom: 100px;">
		<c:forEach items="${prodlist}" var="product">
			<div class="col-lg-4">
				<img alt=""
					src="${pageContext.request.contextPath}/resources/images/product/${product.code}/1.jpg"
					height="150px" width="150px"> <br />
				<strong>${product.name}</strong>
				<div>&#8377;${product.price}</div>
				${product.brand} 
				<br>
				 <a href="${pageContext.request.contextPath}/viewSingle/${product.sid}"
					class="btn btn-info">View</a>
			</div>

		</c:forEach>
	</div>
</div>
