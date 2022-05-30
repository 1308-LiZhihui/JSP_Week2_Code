<!DOCTYPE html>
 <%response.setContentType("text/html");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | E-Shopper</title>
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/prettyPhoto.css" rel="stylesheet">
    <link href="<%=basePath%>css/price-range.css" rel="stylesheet">
    <link href="<%=basePath%>css/animate.css" rel="stylesheet">
	<link href="<%=basePath%>css/main.css" rel="stylesheet">
	<link href="<%=basePath%>css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="<%=basePath%>js/html5shiv.js"></script>
    <script src="<%=basePath%>js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="<%=basePath%>images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=basePath%>images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=basePath%>images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=basePath%>images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%=basePath%>images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->
<body>

<section id="z`z`">
<div>
						<div class="table-responsive col-sm-12">
						 <h4>Order ID :${ param.orderId } Items</h4> 
					<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image"><strong>Item</strong></td>
							<td class="description"></td>
							<td class="price"><strong>Price</strong></td>
							<td class="quantity"><strong>Quantity</strong></td>
							
							<td class="total"><strong>Total</strong></td>
							
							
						</tr>
						</thead><tbody>
						<c:set var="cal" value="0.0"/>
						<c:forEach var="i" items="${itemList}">
					<tr>
						
							<td class="cart_product">
								<a href=""><img src="<%=basePath%>getImg?id=${i.product.productId}" alt="" style="border: 1px solid #F7F7F0; height: 100px;width: 80px;"></a>
							</td>
							<td class="cart_description">
								<h4>${ i.product.productName}</h4>
								<p>Web ID: ${ i.product.productId}</p>
							</td>
								<td class="cart_price">
								<p>${ i.product.price}</p>
							</td>
							<td class="cart_quantity"> ${ i.quantity}
								
							</td>
							
							<td class="cart_total">
								<p class="cart_total_price"> ${ i.product.price*i.quantity}</p>
							</td>
							</tr>
							<c:set var="cal" value="${ cal+i.product.price*i.quantity}"/>
							</c:forEach>
							
							<tr>
							<td colspan="2">&nbsp;</td>
							<td colspan="3">
								<table class="table table-condensed total-result">
									<tr>
										<td>Cart Sub Total</td>
										<td>${cal }</td>
									</tr>
									
									<tr class="shipping-cost">
										<td>Shipping Cost</td>
										<td>Free</td>										
									</tr>
									<tr>
										<td>Total</td>
										<td><span>${cal }</span></td>
									</tr>
								</table>
							</td>
						</tr>
						</tbody>
</table>	</div>
			
			</div>		
						
		
		</section>
		</body>
		</html>