<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" ></c:set>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="login-box" style="text-align: center; color:white">
		<h3>잘못된 접근입니다.</h3>
		<h6>${msg}</h6>
		<h6>${exception}</h6>
		<h6>${comments}</h6>
		<form>
			<a href="${root}/index.jsp">메인페이지로</a>
		</form>
	</div>
</body>
</html>