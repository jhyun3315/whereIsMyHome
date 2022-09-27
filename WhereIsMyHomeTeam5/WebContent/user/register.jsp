<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="../css/login.css">
    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" href="../css/styles.css" />
    <link rel="stylesheet" href="../css/main.css" />
</head>

<body>
    <!-- Responsive navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="position: fixed; width: 100%">
        <div class="container px-5">
            <a class="navbar-brand" href="../index.html">구해줘 홈즈</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="../index.html">Home</a>
                    </li>
                    <li class="nav-item" id="login-suc"><a class="nav-link" href="login.html">로그인</a></li>
                    <li class="nav-item" id="reg-suc"><a class="nav-link" href="register.html">회원가입</a></li>
                    <li class="nav-item hide" id="logout"><a class="nav-link" href="#">로그아웃</a></li>
                    <li class="nav-item hide" id="info"><a class="nav-link" href="#">마이페이지</a></li>
                    <li class="nav-item"><a class="nav-link" href="#!">공지사항</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="login-box">
        <h2>회원가입</h2>
        <form>
            <div class="user-box">
                <input id="id" type="text" name="" required="">
                <label>아이디<span style="color: #c95050;">*</span></label>
            </div>
            <div class="user-box">
                <input id="password" type="password" name="" required="">
                <label>비밀번호<span style="color: #c95050;">*</span></label>
            </div>
            <div class="user-box">
                <input id="name" type="text" name="" required="">
                <label>이름<span style="color: #c95050;">*</span></label>
            </div>
            <div class="user-box">
                <input id="email" type="email" name="" required="">
                <label>email<span style="color: #c95050;">*</span></label>
            </div>
            <div class="user-box">
                <input id="phonenumber" type="text" name="" required="">
                <label>전화번호<span style="color: #c95050;">*</span></label>
            </div>
            <a href="#" onclick="regist()">등록</a>
        </form>
    </div>
    <!-- Header-->
    <!-- <header> -->
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="../js/scripts.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>

</html>