<%@include file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<section id="advertisement">
		<div class="container">
			<img src="images/shop/advertisement.jpg" alt="" />
		</div>
	</section>
	
	<section>
		<div class="container">
			<div class="row">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="<%=basePath%>home">Home</a></li>
				  <li class="active">Shop</li>
				</ol>
			</div><!--/breadcrums-->
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<!-- Loop_start -->		
										<c:forEach var="c" items="${categoryList}">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="<%=basePath%>shop?categoryId=${c.categoryId}">${c.categoryName} </a></h4>
								</div>
								
							</div>
										</c:forEach>
							
							<!-- Loop_end -->
						
						</div><!--/category-productsr-->
									
						<div class="price-range"><!--price-range-->
							<h2>Price Range</h2>
							<div class="well">
								 <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
								 <b>$ 0</b> <b class="pull-right">$ 600</b>
							</div>
						</div><!--/price-range-->
						
						<div class="shipping text-center"><!--shipping-->
							<img src="<%=basePath%>images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
						
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Features Items</h2>
						<!-- loop_start -->
							<c:forEach var="p" items="${productList}">
						<div class="col-sm-4 padding-right">
						
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="<%=basePath%>getImg?id=${p.productId}" alt="" style="height: 150px; width: 150px"/>
										<h2>${p.price} </h2>
										<p>${p.productName}</p>
										<a href="<%=basePath %>cart?productId=${p.productId}&action=add" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
									
								</div>
							<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="<%=basePath%>productDetails?id=${p.productId}"><i class="fa fa-plus-square"></i>Product-Details</a></li>
									</ul>
								</div>
							</div>
							
						</div>
									</c:forEach>
				<!-- loop_end -->
						
					</div><!--features_items-->
					<ul class="pagination">
							<li><a href="">&laquo;</a></li><li class="active"><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">&raquo;</a></li>
						</ul>
				</div>
			</div>
		</div>
	</section>
	<br/>
	<%@include file="footer.jsp" %>
	

  
  