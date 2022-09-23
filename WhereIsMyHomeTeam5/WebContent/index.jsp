<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Business Frontpage - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" href="css/styles.css" />
    <link rel="stylesheet" href="css/main.css" />
  </head>
  <body>
    <!-- Responsive navbar-->
    <nav
      class="navbar navbar-expand-lg navbar-dark bg-dark"
      style="position: fixed; width: 100%"
    >
      <div class="container px-5">
        <a class="navbar-brand" href="index.html">구해줘 홈즈</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="index.html"
                >Home</a
              >
            </li>
            <li class="nav-item" id="login-suc">
              <a class="nav-link" href="user/login.html">로그인</a>
            </li>
            <li class="nav-item" id="reg-suc">
              <a class="nav-link" href="user/register.html">회원가입</a>
            </li>
            <li class="nav-item hide" id="logout">
              <a class="nav-link" href="#" onclick="logout()">로그아웃</a>
            </li>
            <li class="nav-item hide" id="info">
              <a class="nav-link" href="user/userInfo.html">마이페이지</a>
            </li>
            <li class="nav-item"><a class="nav-link" href="#!">공지사항</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- Header-->
    <!-- <header> -->
    <header class="bg-dark py-5">
      <div class="main-page-img">
        <img src="img/apt_img.jpg" alt="img" />
      </div>
    </header>
    <!-- Features section-->
    <section class="py-5 border-bottom" id="features">
      <div class="container px-5 my-5">
        <div class="row gx-10">
          <!-- <div class="col-lg-4 mb-5 mb-lg-0"> -->
          <div class="col-sm-4 sel-page">
            <div
              class="feature bg-primary bg-gradient text-white rounded-3 mb-3"
            >
              <i class="bi bi-building"></i>
            </div>
            <h2 class="h4 fw-bolder">아파트 실거래</h2>
            <p>아파트의 실거래가 정보를 제공합니다.</p>
            <br />
            <a class="text-decoration-none" href="#" onclick="checkLog()">
              조회하러 가기.
              <i class="bi bi-arrow-right"></i>
            </a>
          </div>

          <div class="col-sm-4 sel-page">
            <div
              class="feature bg-primary bg-gradient text-white rounded-3 mb-3"
            >
              <i class="bi bi-collection"></i>
            </div>
            <h2 class="h4 fw-bolder">관심지역</h2>
            <p>COMMING SOON!</p>
            <br />
            <a class="text-decoration-none" href="#!">
              조회하러 가기.
              <i class="bi bi-arrow-right"></i>
            </a>
          </div>

          <div class="col-sm-4 sel-page">
            <div
              class="feature bg-primary bg-gradient text-white rounded-3 mb-3"
            >
              <i class="bi bi-toggles2"></i>
            </div>
            <h2 class="h4 fw-bolder">대기오염정보</h2>
            <p>COMMING SOON!</p>
            <br />
            <a class="text-decoration-none" href="#!">
              조회하러 가기.
              <i class="bi bi-arrow-right"></i>
            </a>
          </div>
        </div>
      </div>
    </section>
    <!-- Footer-->
    <footer class="py-3 bg-dark">
      <div class="container px-5">
        <p class="m-0 text-center text-white">Copyright &copy; SSAFY</p>
      </div>
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <!-- * *                               SB Forms JS                               * *-->
    <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
  </body>
</html>
