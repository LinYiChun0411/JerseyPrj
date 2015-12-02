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

	
</head>
<body>
<jsp:include page="./header.jsp" />
<form method="post" action="./show_upload_moive">
	<div class="form-group">
		<label for="movie_title">Movie ID:</label>
		 <input type="text" class="form-control" name="movie_id">
	</div>
	<div class="form-group">
		<label for="movie_title">Movie title:</label>
		 <input type="text" class="form-control" name="movie_title">
	</div>
	<div class="form-group">
		<label for="sel1">Select genre:</label> 
		<select class="form-control" name="genre_id" id="sel1">		
			<c:forEach var="genreList" items="${requestScope.genreList}">
		 		<option value="${genreList.getGenre_id()}">${genreList.getGenre_name()}</option>
			</c:forEach>						
		</select>
	</div>
	<div class="form-group">
		<label for="sel2">Select agr_rating:</label>
		<select class="form-control" name="age_rating" id="sel2">
			<c:forEach var="movieRatingList" items="${requestScope.movieRatingList}">
		 		<option value="${movieRatingList.getMv_rating_id()}">
		 		${movieRatingList.getRating_simbol()} ${movieRatingList.getDescription()}		 	
		 		</option>
			</c:forEach>
			
		</select>
	</div>
	<div class="form-group">
		<label for="storyline">StoryLine:</label>
		<textarea name="storyline" class="form-control" rows="5" id="storyline"></textarea>
	</div>

	<button type="submit" class="btn btn-primary">Submit</button>
</form>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="./js/bootstrap.js"></script>
	<script src="./js/bootstrap-datetimepicker.min.js"></script>


</body>
</html>