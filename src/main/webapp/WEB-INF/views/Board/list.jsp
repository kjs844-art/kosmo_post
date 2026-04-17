<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
<h1>Board List Page</h1>

<c:forEach items="${list}" var="dto">
	<div>
		<span>${dto.boardNum}</span>
		<span>${dto.boardTitle}</span>
		<span>${dto.boardWriter}</span>
	</div>
</c:forEach>
</body>
</html>
