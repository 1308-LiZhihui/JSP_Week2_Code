	<%@include file="header.jsp" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<section id="z`z`">
			<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="<%=basePath%>/home">Home</a></li>
				  <li class="active">Order</li>
				</ol>
			</div><!--/breadcrums-->

			<div class="step-one">
				<h2 class="heading">Shopper Information</h2>
			</div>
			
			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-5 clearfix">
						<div class="bill-to">
							<p>Bill To</p>
							<div class="form-one">
								<form action="<%=basePath%>order" method="post">
								<c:if test="${!empty user}">
								
								    <input type="hidden" name="customerId" value="${user.id}">
									</c:if>
									<input type="text" name="firstName" placeholder="First Name *">
									<input type="text"  name="lastName" placeholder="Last Name *">
									<input type="text" name="phone" placeholder="Phone/Mobile *">
									<input type="text" name="address1" placeholder="Address 1 *">
									<input type="text" name="address2" placeholder="Address 2">
									<input type="text" name="postalCode" placeholder="Zip / Postal Code *">
									<input type="text" name="city" placeholder="City *">
									
							</div>
							<div class="form-two form-one">
									<select name="country">
										<option>-- Country --</option>
										<option value="china">China</option>
										<option value="US">United States</option>
										<option value="UK">UK</option>
										<option>India</option>
										<option>Pakistan</option>
										<option>Ucrane</option>
										<option>Canada</option>
										<option>Dubai</option>
									</select><br/><br/>
									<select name="state">
										<option>-- State / Province / Region --</option>
										<option value="JiangXi">JiangXi</option>
										<option>Bangladesh</option>
										<option>UK</option>
										<option>India</option>
										<option>Pakistan</option>
										<option>Ucrane</option>
										<option>Canada</option>
										<option>Dubai</option>
									</select><br/><br/>
									
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="order-message">
							<p>Shipping Note</p>
							<textarea name="notes"  placeholder="Notes about your order, Special Notes for Delivery" rows="16"></textarea>
						</div>	
					</div>					
				</div>
			</div>
			<div class="review-payment">
				<h2>Review & Payment</h2>
			</div>

			<section id="cart_items">
		<div class="container">
			
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
					<c:when test="${ empty cart}">
					<tr><td colspan="5">
							<div class="content-404 text-center">
								<img src="<%=basePath %>images/cart/empty_cart.png" class="img-responsive" alt="" />
								<h1>You have no items in your shopping cart.</h1>
								<h2><a href="<%=basePath%>shop">Click here to Continue shopping</a></h2>
							</div>
					</td></tr>
					</c:when>
					<c:otherwise>
					<!-- loop_start -->
						<c:set var="cal" value="0.0"/>
						<c:forEach var="c" items="${cart}">
						<tr>
							<td class="cart_product">
								<a href="">
								<img src="getImg?id=${c.product.productId}" alt="" style="height: 150px; width: 150px"></a>
							</td>
							<td class="cart_description">
								<h4><a href="">${c.product.productName} </a></h4>
								<p>Web ID: ${c.product.productId} </p>
							</td>
							<td class="cart_price">
								<p>${c.product.price}</p>
							</td>
							<td class="cart_price">
								<p>${c.quantity}</p>
							</td>
							<td class="cart_total">
								<p id="total" class="cart_total_price">${c.product.price}*${c.quantity}</p>
							</td>
							<td class="cart_delete">
		<a class="cart_quantity_delete" href="<%=basePath%>cart?action=remove&productId=${c.product.productId}"><i class="fa fa-times"></i></a>
							</td>
						</tr>
							<c:set var="cal" value="${cal+(c.product.price*c.quantity)}"/>
						</c:forEach>
					<!--loop_end-->
						</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->
<c:if test="${!empty cart }">
	<section id="do_action">
		<div class="container">
			
			<div class="row">
			<div class="col-sm-6"></div>
									<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Cart Sub Total <span><c:out value="${cal }"/></span></li>
							<!--<li>Eco Tax <span>$2</span></li>-->
							<li>Shipping Cost <span>Free</span></li>
						<input type="hidden" name="orderTotal" value="${cal}"/>
							<li>Total <span><c:out value="${cal}"/></span></li>
						</ul>
							<a class="btn btn-default update" href="<%=basePath%>shop">Update</a>
							
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->

	
			<div class="payment-options">
			<!-- loop_start -->
			<c:forEach var="pType" items="${paymentTypeList}">
					<span>
						<label><input name="paymentId" type="checkbox" varStatus="status"  value="${pType.paymentId}">${pType.paymentType} </label>
					</span>
			</c:forEach>
					<!-- loop_end -->

					<span>
					<input type="submit" name="submit" class="btn btn-primary pull-right" value="Submit"></span>
				</div>
				</c:if>
		</div>
		
		</form>
	</section> <!--/#cart_items-->
<%@include file="footer.jsp" %>