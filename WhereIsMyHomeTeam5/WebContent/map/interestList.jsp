<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Business Frontpage - Start Bootstrap Template</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet" />
<link rel="stylesheet" href="${root}/css/main.css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link rel="stylesheet" href="${root}/css/styles.css" />
<link rel="stylesheet" href="${root}/css/aptInfo.css" />
</head>
<body>
	<!-- Responsive navbar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
		style="position: fixed; width: 100%">
		<div class="container px-5">
			<a class="navbar-brand" href="index.html">구해줘 홈즈</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.html">Home</a></li>
					<li class="nav-item" id="login-suc"><a class="nav-link"
						href="login.html">로그인</a></li>
					<li class="nav-item" id="reg-suc"><a class="nav-link"
						href="register.html">회원가입</a></li>
					<li class="nav-item hide" id="logout"><a class="nav-link"
						href="#" onclick="logout()">로그아웃</a></li>
					<li class="nav-item hide" id="info"><a class="nav-link"
						href="userInfo.html">마이페이지</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">공지사항</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Header-->
	<!-- <header> -->
	<header class="py-5">
		<div style="margin-top: 20px">
			<div class="main-title">
				<p>관심 지역</p>
			</div>
		</div>
		<div class="apt-info-graph">
			<div style="width: 80%;">
				<table class="table table-hover text-center" id="apt-table-graph" style="">
					<tr>
						<th>시/도</th>
						<th>구/군</th>
						<th>동</th>
					</tr>
					<tbody id="aptlist">
						<tr>
							<td>1</td>
							<td>2</td>
							<td>3</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</header>
	<!-- Features section-->
	<section class="py-3 border-bottom" id="features"></section>
	<!-- Footer-->
	<footer class="py-3 bg-dark">
		<div class="container px-5">
			<p class="m-0 text-center text-white">Copyright &copy; SSAFY</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="${root}/js/scripts.js"></script>
	<script src="${root}/js/aptList.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
