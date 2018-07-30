<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="template/navbar.jsp"%>
<br>
<br>
<br>
<div class="" style="margin-left:"100px;">
<h1>Shoping Cart</h1>
</div>
<c:set var="availableCount" value="${userModel.cart.cartLines}" />
<div class="container">


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
						<th style="width:50%">Product</th>
						<th style="width:10%">Price</th>
						<th style="width:8%">Quantity</th>
						<th style="width:22%" class="text-center">Subtotal</th>
						<th style="width:10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartLines}" var="cartLine">
					<c:if test="${cartLine.available == false}">
						<c:set var="availableCount" value="${availableCount - 1}"/>
					</c:if>
					
					<tr>
						<td data-th="Product">
						
							<div class="row">
								<div class="col-sm-2 hidden-xs">
									<img src="${images}/product/${cartLine.product.code}/1.jpg"  alt="${cartLine.product.name}" class="img-fluid dataTableImg"/></div>
								<div class="col-sm-10">
									<h4 class="nomargin">${cartLine.product.name} 
										<c:if test="${cartLine.available == false}">
											<strong style="color:red">(Not Available)</strong> 
										</c:if>
									</h4>
									<p>Brand : ${cartLine.product.brand}</p>
									
								</div>
							</div>
						</td>
						<td data-th="Price"> &#8377; ${cartLine.buyingPrice} /-</td>
						<td data-th="Quantity">
						<form action="${pageContext.request.contextPath}/update/${cartLine.id}" method="post">
							<input type="number" id="count_${cartLine.id}" name="qty" class="form-control text-center" value="${cartLine.productCount}" min="1" max="3">
						</td>
						<td data-th="Subtotal" class="text-center">&#8377; ${cartLine.total} /-</td>
						<td class="actions" data-th="">
							<c:if test="${cartLine.available == true}">
								<button type="submit" name="refreshCart" class="btn btn-info btn-sm" >Update</button>
							</c:if>
							</form>												
							<a href="${pageContext.request.contextPath}/cart/${cartLine.id}/remove" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a>								
						</td>
					</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>Total &#8377; ${GrandTotal}</strong></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/Jewellery" class="btn btn-warning"><span class="glyphicon glyphicon-chevron-left"></span> Continue Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total &#8377; ${GrandTotal}/-</strong></td>
						
						<c:choose>
							<c:when test="${availableCount != 0}">
								<td><a href="${pageContext.request.contextPath}/profile" class="btn btn-success btn-block">Checkout <span class="glyphicon glyphicon-chevron-right"></span></a></td>
							</c:when>							
							<c:otherwise>
								<td><a href="javascript:void(0)" class="btn btn-success btn-block disabled"><strike>Checkout <span class="glyphicon glyphicon-chevron-right"></span></strike></a></td>
							</c:otherwise>
						</c:choose>						
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




</div>