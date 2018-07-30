<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url value="/resources/css" var="css"></spring:url>
<spring:url value="/resources/js" var="js"></spring:url>
<spring:url value="/resources/images" var="images"></spring:url>



<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Full Width Pics - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<!-- Custom styles for this template -->
<%-- <link href="${css}/shop-homepage.css" rel="stylesheet"> --%>
<link href="${css}/all.css" rel="stylesheet">
<link href="${css}/homepageslider.css" rel="stylesheet">
<link href="${css}/Payment-Style.css" rel="stylesheet">
</head>

<body>



	<div class="wrapper">

		<c:if test="${UserClickedHome==true}">
			<%@include file="home.jsp"%>
		</c:if>

		<c:if test="${UserClickedAbout==true}">
			<%@include file="about.jsp"%>
		</c:if>


		<c:if test="${UserClickedSupplier==true}">
			<%@include file="Supplier.jsp"%>
		</c:if>
		<c:if test="${UserClickedCategory==true}">
			<%@include file="Category.jsp"%>
		</c:if>
		<c:if test="${UserClickedProduct==true}">
			<%@include file="product.jsp"%>
		</c:if>
		<c:if test="${UserClickedUser==true}">
			<%@include file="user.jsp"%>
		</c:if>
		<c:if test="${UserClickedSingle==true}">
			<%@include file="Jewellery.jsp"%>
		</c:if>
		<c:if test="${UserClickedSingleProduct==true}">
			<%@include file="Singleview.jsp"%>
		</c:if>
		<c:if test="${UserClickedContact==true}">
			<%@include file="contact.jsp"%>
		</c:if>

		<c:if test="${UserClickedLogin==true}">
			<%@include file="login.jsp"%>
		</c:if>
		<c:if test="${UserClickedProfile==true}">
			<%@include file="profile.jsp"%>
		</c:if>
		<c:if test="${UserClickedPayment==true}">
			<%@include file="payment.jsp"%>
		</c:if>
		<c:if test="${UserClickedCart==true}">
			<%@include file="cart.jsp"%>
		</c:if>
		<c:if test="${UserClickedBill==true}">
			<%@include file="bill.jsp"%>
		</c:if>
	</div>
	<!-- Footer -->

	<!-- <div class="container  footer py-5 bg-dark">
		<footer>
			<div class="row">
				<div class="col-lg-12">
				<p><a href="http://www.facebook.com/Online_Jewellery/"><i class="fa fa-facebook" style="padding-right:10px;" aria-hidden="true">
				</i>
				</a>
				<a href="http://www.twitter.com/Online_Jewellery/"><i class="fa fa-twitter" style="padding-right:10px;" aria-hidden="true">
				</i>Connect With Us
				</a>
				</p>
					<p class="m-0 text-center text-white">Copyright &copy; Your
						Website 2018</p>
				</div>
			</div>
		</footer>
	</div> -->
	<!-- /.container -->


	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>
	<script src="${js}/swipper.js"></script>



</body>

</html>
