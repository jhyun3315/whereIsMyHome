<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="root" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
 	<%@ include file="/include/head.jsp"%>
	<link rel="stylesheet" href="${root}/css/aptInfo.css" />
</head>
<body>
	<!-- Responsive navbar-->
	<%@ include file="/include/nav.jsp"%>
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
						<th>index</th>
						<th>시/도</th>
						<th>구/군</th>
						<th>동</th>
						<th></th>
						<th></th>
					</tr>
					<tbody id="aptlist"> 
						<c:forEach var="obj" items="${instlist}">
								<tr class ="inst_tr_for_search" id="tr_${obj.idx}">  
									<td id="idx"><c:out value="${obj.idx}"></c:out></td>
									<td id="sidoName"><c:out value="${obj.sidoName}"></c:out> </td>
									<td id="gugunName"><c:out value="${obj.gugunName}"></c:out> </td>
									<td id= "dongName"><c:out value="${obj.dongName}"></c:out> </td> 
									<td><input type="button" class="inst_tr_map_btn" id="${obj.idx}" value="삭제" onclick="rm_tr_map_btn(this.id)"></td>
									
								</tr> 
						</c:forEach> 
					</tbody>
				</table>
			</div>
		</div>
			<div class="apt-info-map">
			<div id="map" style="width: 80%; height: 500px"></div>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1871958cf102bea477b49678891e9135&libraries=services">
		 </script>
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
	<script src="${root}/js/interest.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
