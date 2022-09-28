<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="position: fixed; width: 100%">
        <div class="container px-5">
            <a class="navbar-brand" href="${root}/index.jsp">구해줘 홈즈</a>
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
                    <c:if test="${empty userinfo}">
                    	<li class="nav-item" id="login-suc"><a class="nav-link" href="user?action=loginform">로그인</a></li>
                    	<li class="nav-item" id="reg-suc"><a class="nav-link" href="user?action=registmemberform">회원가입</a></li>
                    </c:if>
                    <c:if test="${!empty userinfo}">
                   		<li class="nav-item" id="logout"><a class="nav-link" href="user?action=logout">로그아웃</a></li>
                    	<li class="nav-item" id="info"><a class="nav-link" href="user?action=userinfo">마이페이지</a></li>
                    </c:if>
                    <li class="nav-item"><a class="nav-link" href="#!">공지사항</a></li>
                </ul>
            </div>
        </div>
    </nav>