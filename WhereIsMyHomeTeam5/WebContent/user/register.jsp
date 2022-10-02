<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" ></c:set>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="${root}/css/login.css">
    <script type="text/javascript">
	    window.onload = function() {
	        document.querySelector("#registbutton").addEventListener("click", function() {
	            if(document.getElementById("userId").value.length <= 0) {
	                alert("아이디를 입력하세요.");
	                document.getElementById("userId").focus();
	                return;            
	            } else if(document.getElementById("userPw").value.length <= 3) {
	                alert("아이디를 4자 이상 입력해주세요.");
	                document.getElementById("userId").focus();
	                return;
	            } else if(document.getElementById("userPw").value.length <= 0) {
	                alert("비밀번호를 입력하세요.");
	                document.getElementById("userPw").focus();
	                return;
	            } else if(document.getElementById("userPw").value.length <= 5) {
	                alert("비밀번호를 6자 이상 입력해주세요.");
	                document.getElementById("usePw").focus();
	                return;
	            } else if(document.getElementById("userName").value.length <= 0) {
	                alert("이름을 입력하세요.");
	                document.getElementById("userName").focus();
	                return;
	            } else if(document.getElementById("userEmail").value.length <= 0) {
	                alert("이메일을 입력하세요.");
	                document.getElementById("userEmail").focus();
	                return;
	            } else if(document.getElementById("userPhoneNum").value.length <= 0) {
	                alert("전화번호를 입력하세요.");
	                document.getElementById("userPhoneNum").focus();
	                return;
	            }
	            document.getElementById("regform").submit();
	        }, true);
	    };
	</script>
</head>

<body>
    <div class="login-box">
        <h2>회원가입</h2>
        <form action="user" method="GET" id="regform">
        	<input type="hidden" name="action" value="registmember">
            <div class="user-box">
                <input id="userId" type="text" name="userId" required="">
                <label>아이디<span style="color: #c95050;">*</span></label>
            </div>
            <div class="user-box">
                <input id="userPw" type="password" name="userPw" required="">
                <label>비밀번호<span style="color: #c95050;">*</span></label>
            </div>
            <div class="user-box">
                <input id="userName" type="text" name="userName" required="">
                <label>이름<span style="color: #c95050;">*</span></label>
            </div>
            <div class="user-box">
                <input id="userEmail" type="text" name="userEmail" required="">
                <label>email<span style="color: #c95050;">*</span></label>
            </div>
            <div class="user-box">
                <input id="userPhoneNum" type="text" name="userPhoneNum" required="">
                <label>전화번호<span style="color: #c95050;">*</span></label>
            </div>
            <a id="registbutton" href="#">등록</a>
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