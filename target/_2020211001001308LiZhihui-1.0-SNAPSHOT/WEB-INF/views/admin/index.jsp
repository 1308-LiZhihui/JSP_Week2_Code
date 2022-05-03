
<%@include file="../header.jsp"%>
<div class="container">
	    	<div class="row">    		
	    		<div class="col-sm-12">    			   			
					<h2 class="title text-center">Administrator <strong>Home</strong></h2>    			    				    				
					</div>			 		
<div class="col-sm-8"  style="left: 25%">
						<div class="col-sm-3" style="height: 350px;">
							<div class="video-gallery text-center" >
								<a href="<%=basePath%>admin/productList">
									<div class="iframe-img">
										<img src="<%=basePath%>images/home/productmgmt.png" alt="" />
									</div>
									
								</a>
								<h2>Product Management</h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="<%=basePath%>admin/orderList">
									<div class="iframe-img">
										<img src="<%=basePath%>images/home/ordermgmt.png" alt="" />
									</div>
									
								</a>
								<h2>Order Management</h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="<%=basePath%>admin/userList">
									<div class="iframe-img">
										<img src="<%=basePath%>images/home/usermgmt.png" alt="" />
									</div>
									</a>
								<h2>User Management</h2>
							</div>
						</div>
					</div>
					</div></div>
<div style="height: 194px; "></div>

 <%@include file="../footer.jsp" %>
