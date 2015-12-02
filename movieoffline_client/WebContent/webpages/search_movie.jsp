<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Movie Search</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/dashboard.css" rel="stylesheet">
	
</head>
<body>
	<jsp:include page="./header.jsp" />
	<h2 class="sub-header">Movie Search Engine</h2>
	<div class="container-fluid">
		<div class="form-group">
		<label for="movie_title">Search Movie ID:</label>
			<form method="post" action="./search_result">
				<input name="searchInput" required
					placeholder="search Movid ID or Title"></input>
				<button type="submit" class="btn btn-default">Search</button>
			</form>
		</div>
		
		
						
		<div class="list-group">
			<label for="movie_genre">Search Movie Genre:</label>
			<c:forEach var="genrelist" items="${requestScope.genrelist}"
				varStatus="status">
				<a id="#${genrelist.getGenre_id()}" href="./search_genre?genre_id=${genrelist.getGenre_id()}"
					class="list-group-item">${genrelist.getGenre_name()}</a>
			</c:forEach>
		</div>
		<div class="form-group">
		<label for="total_movie">Show All Movie</label>
			<a href="./movielist" type="button" class="btn btn-primary">Get All Movie</a>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="./js/bootstrap.js"></script>	


</body>
</html>