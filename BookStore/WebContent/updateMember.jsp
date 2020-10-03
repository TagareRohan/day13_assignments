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

<label>Current Member Id</label>
<input type="number" id="oldMemberId" name="oldMemberId">

<label>New Member Id</label>
<input type="number" id="memberId" name="memberId">
<label>Member Name</label>
<input type="text" id="memberName" name="memberName">
<label>Account Open Date</label>
<input type="text" id="accountOpenDate" name="accountOpenDate">
<label>Membership type</label>
<input type="text" id="membershipType" name="membershipType">
<label>Fees paid</label>
<input type="number" id="feesPaid" name="feesPaid">
<label>Max Book Allowed</label>
<input type="number" id="maxBookAllowed" name="maxBookAllowed">
<label>Penalty</label>
<input type="number" id="penalty" name="penalty">


<input type="submit" id="updateForm" name="submit" value="updateForm">


</form>

</body>
</html>