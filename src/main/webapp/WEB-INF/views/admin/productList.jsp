<%@ page import="com.LiZhihui.model.Product" %>
<%@ page import="java.sql.Connection" %>
<%@include file="../header.jsp" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<section id="cart_items">
		<div class="container">
		<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="<%=basePath %>admin/home">Admin</a></li>
				  <li class="active">Product</li>
				</ol>
			</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Modules</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="<%=basePath%>admin/home">Home</a></li>
								<li><a href="<%=basePath%>admin/productList.jsp">Product</a></li>
								<li><a href="<%=basePath%>admin/orderList.jsp">Order</a></li>
								<li><a href="<%=basePath%>admin/userList.jsp">User</a></li>
							</ul>
						</div>
					</div>
		<div class="table-responsive col-sm-10">
		<h2 class="title text-center">Product <strong>List</strong></h2> 
					<table class="table table-condensed">
					
					<thead>
					<tr class="cart_menu">
							<td colspan="5">&nbsp;</td>
							<td  colspan="1">  <a class="btn btn-default update" id="buttonSubmit1" href="<%=basePath %>admin/addProduct">Add Product</a></td>
							
						</tr>
						<tr class="cart_menu">
							<td class="image"><strong>Item</strong></td>
							<td class="description"></td>
							<td class="price"><strong>Price</strong></td>
							<td class="quantity"><strong>Category</strong></td>
							
							<td class="total"><strong>Description</strong></td>
							<td></td>
							
						</tr>
						</thead><tbody>
					<!-- loop_start -->
					    <c:forEach var="p" items="${productList}">
						<tr>
							<td class="cart_product">
								<a href=""><img src="<%=basePath %>getImg?id=${p.productId}"
								style="border: 1px solid #F7F7F0; height: 100px;width: 80px;"/></a>
							</td>
							<td class="cart_description">
								<h4>${p.productName} </h4>
								<p>Web ID: ${p.productId}</p>
							</td>
								<td class="cart_price">
								<p>${p.price}</p>
							</td>
							<%
								com.LiZhihui.model.Product p = (Product) pageContext.findAttribute("p");
								int pid = p.getProductId();
								Connection con = (Connection) application.getAttribute("con");
								String catName = com.LiZhihui.model.Category.findByCategoryId(con,pid);
							%>
							<td class="cart_quantity"><%=catName%></td>
						
							<td class="cart_quantity">${p.categoryId}</td>
							
							<td class="cart_total">
								<p class="cart_total_price">${p.productDescription}</p>
							</td>
							<td class="">
							<a class="cart_quantity_delete" href="<%=basePath%>admin/productEdit?productId=${p.productId}" >
							<i class="fa fa-edit">Edit</i></a>&nbsp;
							<a class="cart_quantity_delete" href="<%=basePath%>admin/productDelete?productId=${p.productId}">
							<i class="fa fa-times">Delete</i></a>
							</td>
							</tr>
						</c:forEach >
							<!-- loop_end -->
							
							<tr class="cart_menu">
							<td colspan="5">&nbsp;</td>
							<td  colspan="1">  <a class="btn btn-default update" id="buttonSubmit" href="<%=basePath %>admin/addProduct">Add Product</a></td>
							
						</tr>
						</tbody>
</table>
		<ul class="pagination">
		
		<li><a href="">&laquo;</a></li>
							<li class="active"><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">&raquo;</a></li>
						</ul>
		</div>
		</div>
		</section>
 <%@include file="../footer.jsp" %>