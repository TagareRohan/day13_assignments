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

<label>Member ID</label>
<input type="number" id="memberId" name="memberId">
<br><br>
<input type="submit" name="submit" id="findForm" value="findForm">

</form>


</body>
</html>