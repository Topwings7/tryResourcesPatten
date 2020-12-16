<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="user" items="${userlist }">
		${user.id }<br>
		${user.userId}<br>
		${user.name }<br>
		${user.password }<br>
		${user.phone }<br>
		${user.address }<br>
		${user.birthDate }<br>
		${user.regDate }<br>
		<hr>
	</c:forEach>
</body>
</html>