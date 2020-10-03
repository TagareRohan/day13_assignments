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

<form action="${pageContext.request.contextPath}/BookServlet" method="post">

<label>Member Id</label>
<input type="number" id="memberId" name="memberId">

<input type="submit" id="removeForm" name="submit" value="removeForm">

</form>

</body>
</html>