<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Movie Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/dashboard.css" rel="stylesheet">
	
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a  class="navbar-brand" href="./home">Home</a>
			</div>

			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="./upload">Create moive</a></li>
					<li><a href="./search">Search</a></li>				
					<li><a href="./watchlist">Watch list</a></li>
					<li><a href="./index">Logout</a></li>					
				</ul>
			</div>
			<!--/.nav-collapse -->

		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">			
				<ul class="nav nav-sidebar">
					<li><a href="http://www.123kubo.com/">123KUBO</a></li>
					<li><a href="http://www.tw116.com/">TW116</a></li>
					<li><a href="http://www89.eyny.com/">enyn</a></li>
					<li><a href="http://www.youku.com/">youku</a></li>
					<li><a href="http://www.lovetvshow.com/">loveTVshow</a></li>					
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				
				<c:catch var="member"  >
					<h2 class="sub-header">WelCome to Alan's movie Cloud</h2>
					<h3>Member Information</h3>					
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Username</th>
								<th>Email</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>${member.getFirst_name()}</td>
								<td>${member.getLast_name()}</td>
								<td>${member.getUsername()}</td>
								<td>${member.getEmail()}</td>								
							</tr>
					</table>
				</c:catch>
				<footer class="footer">
					<div class="container">
						<p class="text-muted">copyright &copy; 2015 林宜駿 </p>
					</div>
				</footer>
			</div>
		</div>
	</div>
	
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="./js/bootstrap.js"></script>


</body>
</html>