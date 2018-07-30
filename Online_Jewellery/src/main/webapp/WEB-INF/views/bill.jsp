<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="template/navbar.jsp"%>
<br>

<div class="" style="margin-top: 100px; margin-left: 100px;">
	<h1>
		<a href="#" class="text-info">E-GENERATED BILL</a>
	</h1>
	<br> <br>
	<h1>Delivery Address </h1>
	<div>
		<h1>
			<a href="#" class="text-secondary">${user.name}</a>
		</h1>
		<h1>
			<a href="#" class="text-warning">${user.address}</a>
		</h1>
	</div>
	<c:set var="availableCount" value="${userModel.cart.cartLines}" />
	<br>
	<div class="container" style="border: 0.5px solid gray"></div>

	<c:if test="${not empty message}">

		<div class="alert alert-info">
			<h3 class="text-center">${message}</h3>
		</div>

	</c:if>

	<c:choose>
		<c:when test="${not empty cartLines}">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartLines}" var="cartLine">
						<c:if test="${cartLine.available == false}">
							<c:set var="availableCount" value="${availableCount - 1}" />
						</c:if>

						<tr>
							<td data-th="Product">

								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img src="${images}/product/${cartLine.product.code}/1.jpg"
											alt="${cartLine.product.name}" class="img-fluid dataTableImg" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin">${cartLine.product.name}
											<c:if test="${cartLine.available == false}">
												<strong style="color: red">(Not Available)</strong>
											</c:if>
										</h4>
										<p>Brand : ${cartLine.product.brand}</p>

									</div>
								</div>
							</td>
							<td data-th="Price">&#8377; ${cartLine.buyingPrice} /-</td>
							<td data-th="Quantity">${cartLine.productCount}</td>
							<td data-th="Subtotal" class="text-center">&#8377;
								${cartLine.total} /-</td>

						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total &#8377;
								${cart.grandTotal}</strong></td>
					</tr>
					<tr>
						<td><a href="#" class="btn btn-warning"
							onclick="window.print()"><span
								class="glyphicon glyphicon-chevron-left"></span>Print Bill</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total
								&#8377; ${cart.grandTotal}/-</strong></td>


					</tr>

				</tfoot>
			</table>

		</c:when>

		<c:otherwise>

			<div class="jumbotron">

				<h3 class="text-center">Your Cart is Empty!</h3>

			</div>

		</c:otherwise>

	</c:choose>


	<br> <br>
	<!-- <button class="btn btn-info" onclick="window.print()"
		style="margin-left: 10px";>
		<span class="glyphicon glyphicon-chevron-left"></span>Print Bill
	</button> -->
</div>