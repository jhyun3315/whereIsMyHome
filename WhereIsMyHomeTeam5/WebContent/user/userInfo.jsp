<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Business Frontpage - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" />
    <link rel="stylesheet" href="${root}/css/info.css">
    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" href="${root}/css/styles.css" />
    <link rel="stylesheet" href="${root}/css/main.css" />
</head>

<body>
    <!-- Responsive navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="position: fixed; width: 100%">
        <div class="container px-5">
            <a class="navbar-brand" href="${root}/index.jsp">구해줘 홈즈</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${root}/index.jsp">Home</a>
                    </li>
                    <li class="nav-item" id="login-suc"><a class="nav-link" href="user?action=loginform">로그인</a></li>
                    <li class="nav-item" id="reg-suc"><a class="nav-link" href="user?action=registmemberform">회원가입</a></li>
                    <li class="nav-item hide" id="logout"><a class="nav-link" href="#" onclick="logout()">로그아웃</a></li>
                    <li class="nav-item hide" id="info"><a class="nav-link" href="user?action=userinfo">마이페이지</a></li>
                    <li class="nav-item"><a class="nav-link" href="#!">공지사항</a></li>
                </ul>
            </div>
        </div>
    </nav>
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