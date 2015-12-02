<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Upload result</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/dashboard.css" rel="stylesheet">
</head>
<body>
	<h1>Upload Success</h1>
	<jsp:include page="./header.jsp" />
	<c:catch var="movie">
		<table class="table table-bordered">
			<tr>
				<td>Movie ID</td><td>${movie.getMovie_id()}</td>
			</tr>
			<tr>
				<td>Title</td><td>${movie.getTitle()}</td>
			</tr>
			<tr>
				<td>Genre</td><td>${movie.getGenre_id()}</td>
			</tr>
			<tr>
				<td>Age Rating</td><td>${movie.getAge_rating()}</td>
			</tr>
			<tr>
				<td>storyline</td><td>${movie.getStoryline()}</td>
			</tr>
		</table>						
	</c:catch>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="./js/bootstrap.js"></script>	
</body>
</html>