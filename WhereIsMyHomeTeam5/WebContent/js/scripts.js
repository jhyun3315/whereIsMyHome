///*!
//* Start Bootstrap - Business Frontpage v5.0.8 (https://startbootstrap.com/template/business-frontpage)
//* Copyright 2013-2022 Start Bootstrap
//* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-business-frontpage/blob/master/LICENSE)
//*/
//// This file is intentionally blank
//// Use this file to add JavaScript to your project
//
////const hideToggle = () => {
////    document.querySelector("#logout").classList.toggle("hide");
////    document.querySelector("#info").classList.toggle("hide");
////    document.querySelector("#login-suc").classList.toggle("hide");
////    document.querySelector("#reg-suc").classList.toggle("hide");
////}
//
//let isLogin = localStorage.getItem("isLogin");
//
//if (isLogin === null) {
//    localStorage.setItem("isLogin", "false");
//} else if (isLogin === "true") {
//    hideToggle();
//}
//
//function regist() {
//    let id = document.getElementById("id").value;
//    let password = document.getElementById("password").value;
//    let name = document.getElementById("name").value;
//    let email = document.getElementById("email").value;
//    let phonenumber = document.getElementById("phonenumber").value;
//
//    if (!id || !password || !name || !email || !phonenumber) {
//        alert("빈칸이 없도록 입력해주세요.");
//        return;
//    } else {
//        const user = {
//            id: id,
//            password: password,
//            name: name,
//            email: email,
//            phonenumber: phonenumber,
//        };
//
//        localStorage.setItem("user", JSON.stringify(user));
//        alert("회원 등록 성공");
//        window.location.replace("/user/login.html");
//    }
//}
//
//function login() {
//    let id = document.getElementById("id").value;
//    let password = document.getElementById("password").value;
//
//    const user = JSON.parse(localStorage.getItem("user"));
//    if (
//        user != null &&
//        user.id != null &&
//        user.id &&
//        user.password &&
//        user.id === id &&
//        user.password === password
//    ) {
//        alert("로그인 성공");
//        hideToggle();
//        localStorage.setItem("isLogin", "true");
//        window.location.replace("/index.html");
//    } else {
//        console.log(user);
//        alert("아이디 혹은 비밀번호를 잘못 입력하였습니다.");
//    }
//}
//
//function logout() {
//    hideToggle();
//    localStorage.setItem("isLogin", "false");
//    window.location.replace("/index.html");
//}
//
//const user = JSON.parse(localStorage.getItem("user")); 
//
//// let setId = document.getElementById('info-id');
//// setId.innerText = user.id;
//document.getElementById('info-id').value = user.id;
//
//// let setPw = document.getElementById('info-pw');
//// setPw.innerText = user.password;
//document.getElementById('info-pw').value = user.password;
//
//// let setNm = document.getElementById('info-nm');
//// setNm.innerText = user.name;
//document.getElementById('info-nm').value = user.name;
//
//// let setE = document.getElementById('info-e');
//// setE.innerText = user.email;
//document.getElementById('info-e').value = user.email;
//
//// let setPh = document.getElementById('info-ph');
//// setPh.innerText = user.phonenumber;
//document.getElementById('info-ph').value = user.phonenumber;
//
//
//function modify() {
//    let infoId = document.getElementById("info-id").value;
//    let infoPw = document.getElementById("info-pw").value;
//    let infoNm = document.getElementById("info-nm").value;
//    let infoE = document.getElementById("info-e").value;
//    let infoPh = document.getElementById("info-ph").value;
//
//    const user = {
//        id: infoId,
//        password: infoPw,
//        name: infoNm,
//        email: infoE,
//        phonenumber: infoPh,
//    };
//
//    localStorage.setItem("user", JSON.stringify(user));
//    // const user2 = JSON.parse(localStorage.getItem("user"));
//    // console.log(user2);
//    alert("회원정보 수정 성공");
//    window.location.replace("/user/userInfo.html");
//}
//
//function clearUser() {
//    localStorage.clear();
//    alert("회원정보를 삭제합니다.");
//    window.location.replace("/index.html");
//}
//
//function checkLog() {
//    console.log(isLogin);
//    if (isLogin === "true") {
//        window.location.replace("/aptRealList.html");
//    } else {
//        alert("로그인이 필요합니다.");
//        window.location.replace("/user/login.html");
//    }
//}