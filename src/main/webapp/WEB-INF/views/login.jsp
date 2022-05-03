
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
					<h2>Login to your account</h2>
                        <%
    if(!(request.getAttribute("message")==null)){
    out.println("<h2>"+request.getAttribute("message")+"</h2>");
}%>
<%
    Cookie[] cookies=request.getCookies();
    String username="";
    String password="";
    String rememberMe="";
    if (cookies!=null){
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("cUsername")){
                username=cookie.getValue();
            }
            if (cookie.getName().equals("cPassword")){
                password=cookie.getValue();
            }
            if (cookie.getName().equals("cRememberMe")){
                rememberMe=cookie.getValue();
            }
        }
    }
    //update 5 user basepath
%>

<form method="post" action="<%=request.getContextPath()+"/login"%>">
    <input type="text" name="username" placeholder="Username" value="<%=username%>"><br>
   <input type="password" name="password" placeholder="password" value="<%=password%>">
    <br/>
    <span>
		<input type="checkbox" class="checkbox" name="remember" value="1" <%="1".equals(rememberMe)? "checked":""%>/> Keep me signed in
   </span>
    <button type="submit" class="btn btn-default">Login</button>
</form>	
					</div><!--/login form-->
				</div>
				
				
			</div>
		</div>
	</section><!--/form-->
<%@include file="footer.jsp"%>
