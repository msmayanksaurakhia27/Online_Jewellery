<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="template/navbar.jsp"%>

<div class="row" style="margin-top: 100px;">

	<img alt=""
		src="${pageContext.request.contextPath}/resources/images/product/${product.code}/1.jpg"
		height="500px" width="400px">

</div>
<div class="row">
	<div class="row" style="margin-left: 100px;">
		<img alt=""
			src="${pageContext.request.contextPath}/resources/images/product/${product.code}/2.jpg"
			height="100px" width="100px"> <img alt=""
			src="${pageContext.request.contextPath}/resources/images/product/${product.code}/3.jpg"
			height="100px" width="100px"> <img alt=""
			src="${pageContext.request.contextPath}/resources/images/product/${product.code}/4.jpg"
			height="100px" width="100px">
	</div>
</div>
<!-- <div class="row"> -->
<div class="row" style="margin-left: 100px;">
	<br /> <strong><span style="font-size: 40px">${product.name}</span></strong>
</div>
<div class="row" style="margin-left: 100px;">
	<br /> <span class=""></span> <span style="font-size: 50px"><div>&#8377;${product.price}</span>
</div>
</div>
<div class="row" style="margin-left: 100px;">
	<br /> <span style="font-size: 30px">${product.brand}</span>
</div>
<<c:if test="${user.role!='ROLE_ADMIN'}">
<div style="margin-left: 100px;">
	<a
		href="${pageContext.request.contextPath}/addtocart/${product.sid}?qty=1"
		type="button" class="btn btn-success fas fa-cart-arrow-down " value="ADD TO CART">
		<span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart
	</a>
</div>
</c:if>
<%-- <div class="row" style="margin-left: 100px;">

	<a href="${pageContext.request.contextPath}/addtocart/${product.sid}?qty=1"
		class="btn btn-Warning fas fa-cart-arrow-down" value="ADD TO CART" />
</div> --%>