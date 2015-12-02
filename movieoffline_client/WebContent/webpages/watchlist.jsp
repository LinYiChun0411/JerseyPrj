<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>WatchList</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/dashboard.css" rel="stylesheet">
	
</head>
<body>
	<jsp:include page="./header.jsp" />
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Movie ID</th>
				<th>Title</th>
				<th>Status</th>
				<th>ModifiedDate</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="watchList" items="${requestScope.watchList}"
				varStatus="status">
				<tr>
					<td>${watchList.getMovie_id()}</td>
					<td>${watchList.getTitle()}</td>
					<td>${watchList.getStatus()}</td>
					<td>${watchList.getModifiedDate()}</td>

				</tr>

			</c:forEach>
		</tbody>
	</table>



	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="./js/bootstrap.js"></script>
	


</body>
</html>