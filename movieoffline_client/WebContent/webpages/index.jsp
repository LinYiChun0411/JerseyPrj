<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Webservice</title>
	<!-- Bootstrap -->
	<link href="./css/bootstrap.min.css" rel="stylesheet">
	<link href="./css/dashboard.css" rel="stylesheet">

</head>
<body background="./images/background.jpg">	
	<div class="container">
		<form class="form-signin" action="./login" method="post">
			<h2 class="form-signin-heading">Please sign in </h2>
			
			<label for="inputEmail" class="sr-only">Email address</label> 
			
			<input type="email" name="inputEmail" class="form-control"placeholder="Email address" required autofocus> <label
				for="inputPassword" class="sr-only">Password</label> 
			
			<input
				type="password" name="inputPassword" class="form-control"
				placeholder="Password" required>
				
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign	in</button>
	
		</form>
		
		<h3><font color="white">You Can Use Test Account</font></h3>
			<h3><font color="white">test@gmail.com</font></h3>
			<h3><font color="white">password:123</font></h3>	
		 
	</div>
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>

</html>