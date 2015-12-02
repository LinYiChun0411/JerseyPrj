<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Search Result</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/dashboard.css" rel="stylesheet">
	
</head>
<body>
	<jsp:include page="./header.jsp" />
	<div class="row">
		<c:forEach var="movielist" items="${requestScope.movielist}"
			varStatus="status">
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<div class="col-sm-5">Movie ID: ${movielist.getMovie_id()}</div>
							<div class="col-sm-5">Title: ${movielist.getTitle()}</div>
						</div>

					</div>
					<div class="panel-body">
						<p>${movielist.getStoryline()}</p>
						<a href="./addwatchlist?movie_id=${movielist.getMovie_id()}"
							type="button" class="btn btn-default">Add to watch_list</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="./js/bootstrap.js"></script>
	


</body>
</html>