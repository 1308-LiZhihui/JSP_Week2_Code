<%@ page import="com.LiZhihui.model.Order" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.LiZhihui.dao.UserDao" %>
<%@include file="../header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
        <script>
           $(document).ready(function() {
	$('button').click(function() {
		var t = $(this).attr('id'); 
		$.ajax({
			url : '<%=basePath%>orderDetails',
			data : {
				orderId : t
			},
			success : function(responseText) {
				loadPopupBox();
				$('#container').html(responseText);
				 $("#container").dialog();
				 
			}
		});//ajax
	});//click
	 $('#popupBoxClose').click( function() {           
         unloadPopupBox();
     });
    
     $('#container').click( function() {
         unloadPopupBox();
     });
	
	   function unloadPopupBox() {    // TO Unload the Popupbox
            $('#popup_box').fadeOut("slow");
            $("#container").css({ // this is just for style       
                "opacity": "0.3" 
            });
        }   
        
	 function loadPopupBox() {    // To Load the Popupbox
            $('#popup_box').fadeIn("slow");
            $("#container").css({ // this is just for style
                "opacity": "1" 
            });        
        }       
});

        </script>
<section id="z`z`">
		<div class="container">
		<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="<%=basePath %>admin/home">Admin</a></li>
				  <li class="active">Order</li>
				</ol>
			</div>
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
			<div class="table-responsive col-sm-10">
				<table class="table table-condensed">
				<thead>
						<tr >
						<td><strong>Order ID</strong></td>
						<td><strong>Order Date</strong></td>
						<td><strong>Customer</strong></td>
						<td><strong>Address</strong></td>
						<td><strong>Payment Mode</strong></td> 
						<td>&nbsp;</td>
						</tr>
						</thead>
						<tbody>

						<!-- loop_start -->
						<c:forEach var="o" items="${orderList}">
							<tr>
								<td>OID:${o.orderId}</td>
								<td>${o.orderDate}</td>
								<%
									Order o=(Order) pageContext.findAttribute("o");
									int userId=o.getCustomerId();
									Connection con=(Connection) application.getAttribute("con");
									UserDao userDao=new UserDao();
									String customerName=userDao.findById(con, userId).getUsername();
								%>
								<td><%=customerName %></td>
								<td>
									<p>${o.firstName} ${o.lastName}<p>
									<p> ${o.address1}</p>
									<p>${o.address2}</p>
									<p>${o.city},${o.state},${o.country}-${o.postalCode}</p><p>${o.phone}</p></td>
								<td class="cart_total">${o.paymentId}
									<%
										int n=o.getPaymentId();
										String paymentType=com.LiZhihui.model.Payment.findByPaymentId(con,n);
									%>
									<p class="cart_total_price"><%=paymentType %></p>
								</td>
								<td><button class="btn btn-default update" id="${o.orderId }">Details</button></td>
							</tr>
						</c:forEach>
						<tr>
							<!-- loop_end -->
						
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
<div id="popup_box">    <!-- OUR PopupBox DIV-->
  
    <a id="popupBoxClose">Close</a>   

<div id="container"> <!-- Main Page -->
    </div>
</div>
	
  <style type="text/css"> /* popup_box DIV-Styles*/ 
   #popup_box {    
     display:none; /* Hide the DIV */     
     position:fixed;      
      _position:absolute; /* hack for internet explorer 6 */      
       height:500px;      
        width:700px;       
        background:#FFFFFF;      
         left: 300px;     
         top: 100px;  
         z-index:100; /* Layering ( on-top of others), if you have lots of layers: I just maximized, you can change it yourself */     
         margin-left: 15px;            /* additional features, can be omitted */     
         border:2px solid #FE980F;          
          padding:15px;       
          font-size:15px;       
          -moz-box-shadow: 0 0 5px #ff0000;   
            -webkit-box-shadow: 0 0 5px #ff0000;   
              box-shadow: 0 0 5px #ff0000;      } 
               #container {     background: #FFFFFF; /*Sample*/ overflow-y:auto;    width:100%;     height:100%; }  
               a{   cursor: pointer;   text-decoration:none;   }   /* This is for the positioning of the Close Link */ 
               #popupBoxClose {     font-size:15px;       line-height:15px;       right:5px;       top:5px;       position:absolute;       color:#6fa5e2;       font-weight:500;       }
                </style>    

 <%@include file="../footer.jsp" %>