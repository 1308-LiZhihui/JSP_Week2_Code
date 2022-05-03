
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>

<div id="contact-page" class="container">
<div class="row">  	
<div class="col-sm-2">
						<div class="single-widget">
							<h2>Modules</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="<%=basePath%>admin/home">Home</a></li>
								<li><a href="<%=basePath%>admin/productList">Product</a></li>
								<li><a href="<%=basePath%>admin/orderList">Order</a></li>
								<li><a href="<%=basePath%>admin/userList">User</a></li>
							</ul>
						</div>
					</div>
	    		<div class="col-sm-8">
	    			<div class="contact-form">
	    				<h2 class="title text-center">Add Product</h2>
	    				<div class="status alert alert-success" style="display: none"></div>
				    	<form id="main-contact-form" class="contact-form row" name="contact-form" method="post" enctype="multipart/form-data" action="<%=basePath %>admin/addProduct">
				            <div class="form-group col-md-6">
				                <input type="text" name="productName" class="form-control" required="required" placeholder="Product Name">
				            </div>
				            <div class="form-group col-md-6">
				                <input type="text" name="price" class="form-control" required="required" placeholder="Price">
				            </div>
				            <div class="form-group col-md-6">
				               	<select name="categoryId">
										<option >-- Category --</option>
											<!-- loop_start -->
											
										<option value=""></option>
										
										<!-- loop_end -->
										
										</select>
				            </div>
				            <div class="form-group col-md-6">
				                <input type="file" name="picture" class="form-control" required="required" placeholder="picture">
				            </div>
				         
				            <div class="form-group col-md-12">
				                <textarea name="productDescription" id="message"  class="form-control" cols="8" rows="8" placeholder="Product Description Here"></textarea>
				            </div>                        
				            <div class="form-group col-md-12">
				                <input type="submit" name="submit" class="btn btn-primary pull-right" value="Submit">
				            </div>
				        </form>
	    			</div>
	    		</div>
	    		</div>
	    		</div>
<%@include file="../footer.jsp"%>
