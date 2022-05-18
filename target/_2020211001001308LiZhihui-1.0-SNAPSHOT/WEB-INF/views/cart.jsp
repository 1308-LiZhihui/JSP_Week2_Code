<%@include file="header.jsp" %>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="<%=basePath%>home">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					
				
					<tbody>
					<c:choose>
					<c:when test="${ empty cart}"><!--no item in cart-->

					<tr><td colspan="5">
					
					<div class="content-404 text-center">
			<img src="<%=basePath %>images/cart/empty_cart.png" class="img-responsive" alt="" />
			<h1>You have no items in your shopping cart.</h1>
		
			<h2><a href="<%=basePath%>shop">Click here to Continue shopping</a></h2>
		</div>
					
					</td></tr></c:when>
					<c:otherwise>
					<!-- loop_start -->
						<c:set var="cal" value="0.0"/>
					    <c:forEach var="c" items="${cart}">
						<tr>
							<td class="cart_product">
								<a href="productDetails?productId=${c.product.productId} "><img src="getImg?id=${c.product.productId}" alt="" style="height: 150px; width: 150px"></a>
							</td>
							<td class="cart_description">
								<h4><a href="">${c.product.productName }</a></h4>
								<p>Web ID: ${c.product.productId }</p>
							</td>
							<td class="cart_price">
								<p>${c.product.price}</p>
							</td>
							<td class="cart_price">
								<p>${c.quantity}</p>
								
							</td>
							<td class="cart_total">
							
								<p id="total" class="cart_total_price">${c.quantity*c.product.price}</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="<%=basePath%>cart?action=remove&productId=${c.product.productId}"><i class="fa fa-times"></i></a>
							</td>
						</tr>
						cal culate Grand Total
						<c:set var="cal" value="${cal+(c.quantity*c.product.price)}"/>
						</c:forEach>
					<!--loop_end-->
						</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->
<c:if test="${!(empty cart)}">
	<section id="do_action">
		<div class="container">
			
			<div class="row">
			<div class="col-sm-6"></div>
									<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Cart Sub Total <span><c:out value="${cal}"/></span></li>
							<!--<li>Eco Tax <span>$2</span></li>-->
							<li>Shipping Cost <span>Free</span></li>
							<li>Total <span><c:out value="${cal}"/> </span></li>
						</ul>
							<a class="btn btn-default update" href="<%=basePath%>shop">Update</a>
							<a class="btn btn-default check_out" href="<%=basePath%>order">Order</a>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->
</c:if>

	

<%@include file="footer.jsp" %>