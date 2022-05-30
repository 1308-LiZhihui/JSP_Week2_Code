		<%@include file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.LiZhihui.model.User" %>
	<section id="z`z`">
		<div class="container">
			<div class="step-one">
				<h2 class="heading">User Account Info</h2>
			</div>
 	
			<div class="col-sm-6">
				<div class="total_area">
					<%
						if(!(request.getAttribute("user")==null)){
								User u=(User)request.getAttribute("user");
					%>
						<ul>
							<li>Username :<span><%=u.getUsername()%></span></li>
							<li>Password :<span><%=u.getPassword()%></span></li>
							<li>Email :<span><%=u.getEmail()%></span></li>
							<li>Gender :<span><%=u.getGender()%></span></li>
							<li>Birthdate :<span><%=u.getBirthdate()%></span></li>
						</ul>
   						<a class="btn btn-default update" href="updateUser?id=<%=u.getId()%>">Update</a>
					<%}%>
	    					
	    				
	    		</div>
    		</div> 
    			  
    		
			<div class="table-responsive cart_info">
			
			<div  class="step-one" style="margin-top: 330px">
				<h2 class="heading" style="text-align: left">Order Info</h2>
			</div>	
						<div class="table-responsive col-sm-12">
			
				<table class="table table-condensed">
				
					
						<thead>
						<tr >
						<td><strong>Order ID</strong></td>
						<td><strong>Order Date</strong></td>
						<!-- <td><strong>Customer</strong></td> -->
						<td><strong>Address</strong></td>
						<td><strong>Payment Mode</strong></td> 
							<td>&nbsp;</td>
						</tr></thead>
						<tbody>
						<c:choose>
					<c:when test="${ empty orderList}">
						<tr><td colspan="6">
						<div class="content-404 text-center">
			<img src="<%=basePath %>images/cart/no_order.png" class="img-responsive" alt="" />
			<h1>No Order Found.</h1>
		
		</div></td></tr>
						<!-- loop_start -->
					</c:when>
					<c:otherwise>
						<c:forEach var="o" items="${orderList}">
							<tr>
								<td>OID:${o.orderId}</td>
								<td>${o.orderDate}</td>
								<td><p>${o.firstName} ${o.lastName}</p>
									<p> ${o.address1}</p>
									<p>${o.address2}</p>
									<p>${o.city},${o.state},${o.country}-${o.postalCode}</p>
									<p>${o.phone}</p>
								</td>
								<td class="cart_total">
									<%
										com.LiZhihui.model.Order o=(com.LiZhihui.model.Order)pageContext.findAttribute("o");
										int n=o.getPaymentId();
										java.sql.Connection con=(java.sql.Connection)application.getAttribute("con");
										String paymentType=com.LiZhihui.model.Payment.findByPaymentId(con,n);
									%>
									<p class="cart_total_price"><%=paymentType %></p>
								</td>
								<td><button class="btn btn-default update" id="${o.orderId }">Details</button></td>

							</tr>
						</c:forEach>
						<!-- loop_end -->
							</c:otherwise></c:choose>
						
						<tr><td colspan="5">
							<ul class="pagination">
		
		<li><a href="">&laquo;</a></li>
							<li class="active"><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">&raquo;</a></li>
						</ul>
							</td></tr>
					</tbody>
				</table>
				
						
		</div>
		
			
		
			</div>
		</div>
	</section> <!--/#cart_items-->
	
<div id="popup_box">    <!-- OUR PopupBox DIV-->
  
    <a id="popupBoxClose">Close</a>   

<div id="container"> <!-- Main Page -->
    </div>
</div>
	
   <style type="text/css"> /* popup_box DIV-Styles*/ #popup_box {    
     display:none; /* Hide the DIV */     
     position:fixed;      
      _position:absolute; /* hack for internet explorer 6 */      
       height:500px;      
        width:700px;       
        background:#FFFFFF;      
         left: 450px;     
         top: 50px;     
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
	<%@include file="footer.jsp" %>
	

