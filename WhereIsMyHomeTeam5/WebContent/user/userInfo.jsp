<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" ></c:set>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="${root}/css/info.css">
</head>

<body>
    <div class="login-box">
        <h2>회원정보</h2>
        <form>
            <div class="user-box">
                <input class="info" id="userId" type="text" name="userId" value="${mem.userId}" readonly>
                <!-- <div class="info" id="info-id"></div> -->
                <label>아이디</label>
            </div>
            <div class="user-box">
                <input class="info" id="userPw" type="password" name="userPw" value="${mem.userPw}" readonly>
                <!-- <div class="info" id="info-pw"></div> -->
                <label>비밀번호</label>
            </div>
            <div class="user-box">
                <input class="info" id="userName" type="text" name="userName" value="${mem.userName}" readonly>
                <!-- <div class="info" id="info-nm"></div> -->
                <label>이름</label>
            </div>
            <div class="user-box">
                <input class="info" id="userEmail" type="text" name="userEmail" value="${mem.userEmail}" readonly>
                <!-- <div class="info" id="info-e"></div> -->
                <label>email</label>
            </div>
            <div class="user-box">
                <input class="info" id="userPhoneNum" type="text" name="userPhoneNum" value="${mem.userPhoneNum}" readonly>
                <!-- <div class="info" id="info-ph"></div> -->
                <label>전화번호</label>
            </div>
            <a href="user?action=modifyform">수정</a>
            <a href="user?action=deletemember" >삭제</a> <!-- onclick="clearUser()" -->
        </form>
    </div>
    <!-- Header-->
    <!-- <header> -->
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="${root}/js/scripts.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

</html>