<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" ></c:set>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="${root}/css/info.css">
    <script type="text/javascript">
	    window.onload = function() {
	        document.querySelector("#modifybutton").addEventListener("click", function() {
	            if(document.getElementById("userPw").value.length <= 0) {
	                alert("비번은 4자 이상");
	                return;
	            }
	            if(document.getElementById("userName").value.length <= 0) {
	                alert("이름을 입력해주세요.");
	                return;
	            }
	            if(document.getElementById("userEmail").value.length <= 0) {
	                alert("이메일을 입력해주세요.");
	                return;
	            }
	            if(document.getElementById("userPhoneNum").value.length <= 0) {
	                alert("전화번호를 입력해주세요.");
	                return;
	            } 
	            document.getElementById("modiform").submit();
	        }, true);
	    };
	</script>
</head>

<body>
    <div class="login-box">
    	<h2>회원정보 수정</h2>
        <form action="user" method="GET" id="modiform">
        	<input type="hidden" name="action" value="modifymember">
            <div class="user-box">
                <input class="info" id="userId" type="text" name="userId" value="${userinfo}" readonly>
                <label>아이디</label>
            </div>
            <div class="user-box">
                <input class="info" id="userPw" type="password" name="userPw" value="">
                <label>비밀번호</label>
            </div>
            <div class="user-box">
                <input class="info" id="userName" type="text" name="userName" value="">
                <label>이름</label>
            </div>
            <div class="user-box">
                <input class="info" id="userEmail" type="email" name="userEmail" value="">
                <label>email</label>
            </div>
            <div class="user-box">
                <input class="info" id="userPhoneNum" type="text" name="userPhoneNum" value="">
                <label>전화번호</label>
            </div>
            <a id="modifybutton" href="#">확인</a>
            <a href="user?action=userinfo">취소</a>
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