<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="${root}/css/login.css">
    <script type="text/javascript">
	    window.onload = function() {
	        document.querySelector("#loginbutton").addEventListener("click", function() {
	            if(document.getElementById("userId").value.length <= 0) {
	                alert("아이디를 입력하세요.");
	                document.getElementById("userId").focus();
	                return;            
	            } else if(document.getElementById("userPw").value.length <= 0) {
	                alert("비밀번호를 입력하세요.");
	                return;
	            }
	            document.getElementById("regform").submit();
	        }, true);
	    };
	</script>
</head>

<body>
    <div class="login-box">
        <h2>로그인</h2>
        <form action="user" method="GET" id="regform">
        	<input type="hidden" name="action" value="login">
            <div class="user-box">
                <input id="userId" type="text" name="userId" required="">
                <label>아이디</label>
            </div>
            <div class="user-box">
                <input id="userPw" type="password" name="userPw" required="">
                <label>비밀번호</label>
            </div>
            <a id="loginbutton" href="#">로그인</a>
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