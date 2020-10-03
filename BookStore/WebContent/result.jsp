<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>

<h1>Your Result</h1>
<br><br>

<c:out value="${result}"></c:out>

<form action="BookServlet" method="post">

<input type="submit" id="find" name="submit" value="Find Member">
<input type="submit" id="findAll" name="submit" value="Find All Members">
<input type="submit" id="add" name="submit" value="Add Member">
<input type="submit" id="remove" name="submit" value="Remove Member">
<input type="submit" id="update" name="submit" value="Update Member">

</form>

</body>
</html>