<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
    <link rel="stylesheet" href="css/main.css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/aptInfo.css" />
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
            <a class="nav-link" href="login.html">로그인</a>
            </li>
            <li class="nav-item" id="reg-suc">
              <a class="nav-link" href="register.html">회원가입</a>
            </li>
            <li class="nav-item hide" id="logout">
              <a class="nav-link" href="#" onclick="logout()">로그아웃</a>
            </li>
            <li class="nav-item hide" id="info">
              <a class="nav-link" href="userInfo.html">마이페이지</a>
            </li>
            <li class="nav-item"><a class="nav-link" href="#!">공지사항</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- Header-->
    <!-- <header> -->
    <header class="py-5">
        <div style="margin-top: 20px">
            <div class="main-title">
            <p>아파트 실거래가</p>
            </div>
        </div>
        <div class="apt-info-section" style="display:flex; justify-content: center;">
          <div class="row col-md-12 justify-content-center mb-2" style="width: 80%;">
              <div class="form-group col-md-2">
                  <select class="form-select bg-secondary text-light" id="sido">
                  <option value="">시도선택</option>
                  </select>
              </div>
              <div class="form-group col-md-2">
                  <select class="form-select bg-secondary text-light" id="gugun">
                  <option value="">구군선택</option>
                  </select>
              </div>
              <div class="form-group col-md-2">
                  <select class="form-select bg-secondary text-light" id="dong">
                  <option value="">동선택</option>
                  </select>
              </div>
              <div class="form-group col-md-2">
                  <select class="form-select bg-dark text-light" id="year"></select>
              </div>
              <div class="form-group col-md-2">
                  <select class="form-select bg-dark text-light" id="month">
                  <option value="">매매월선택</option>
                  </select>
              </div>
              <div class="form-group col-md-2" style="margin-bottom:20px; text-align: center;">
                  <button type="button" id="list-btn" class="btn btn-outline-primary">
                  아파트 매매정보 가져오기
                  </button>
              </div>
              
          </div>
        </div>
        <div class="apt-info-map">
            <div id="map" style="width: 80%; height: 500px"></div>
          <script
            type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=62cfc9d2a4b44faccb60c0b87e59d120&libraries=services"
          ></script>

            
          <!-- 초기 지도 생성 -->
          <script>

            var marker, infowindow;
            var container = document.getElementById("map");
            var myLatLng = new kakao.maps.LatLng(33.450701, 126.570667);
            var options = {
              center: myLatLng,
              level: 7,
            };

            var map = new kakao.maps.Map(container, options);

            // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
            // var mapTypeControl = new kakao.maps.MapTypeControl();

            // 주소-좌표 변환 객체를 생성합니다
            var geocoder = new kakao.maps.services.Geocoder();

          
          </script>
        </div>
        <div class="apt-info-graph">
          <div style="width: 80%;">
            <table class="table table-hover text-center" id="apt-table-graph" style="display: none" onclick="test()">
            <tr>
                <th>아파트이름</th>
                <th>층</th>
                <th>면적</th>
                <th>법정동</th>
                <th>거래금액</th>
            </tr>
            <tbody id="aptlist"></tbody>
            </table>
          </div>
        </div>
      
    <script>
      ///////////////////////// select box 설정 (지역, 매매기간) /////////////////////////
      let date = new Date();

      window.onload = function () {
        let yearEl = document.querySelector("#year");
        let yearOpt = `<option value="">매매년도선택</option>`;
        let year = date.getFullYear();
        for (let i = year; i > year - 20; i--) {
          yearOpt += `<option value="${i}">${i}년</option>`;
        }
        yearEl.innerHTML = yearOpt;

        // 브라우저가 열리면 시도정보 얻기.
        sendRequest("sido", "*00000000");
      };

      document.querySelector("#year").addEventListener("change", function () {
        let month = date.getMonth() + 1;
        let monthEl = document.querySelector("#month");
        let monthOpt = `<option value="">매매월선택</option>`;
        let yearSel = document.querySelector("#year");
        let m = yearSel[yearSel.selectedIndex].value == date.getFullYear() ? month : 13;
        for (let i = 1; i < m; i++) {
          monthOpt += `<option value="${i < 10 ? "0" + i : i}">${i}월</option>`;
        }
        monthEl.innerHTML = monthOpt;
      });

      // https://juso.dev/docs/reg-code-api/
      // let url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
      // let regcode = "*00000000";
      // 전국 특별/광역시, 도
      // https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=*00000000

      // 시도가 바뀌면 구군정보 얻기.
      document.querySelector("#sido").addEventListener("change", function () {
        if (this[this.selectedIndex].value) {
          let regcode = this[this.selectedIndex].value.substr(0, 2) + "*00000";
          sendRequest("gugun", regcode);
        } else {
          initOption("gugun");
          initOption("dong");
        }
      });

      // 구군이 바뀌면 동정보 얻기.
      document.querySelector("#gugun").addEventListener("change", function () {
        if (this[this.selectedIndex].value) {
          let regcode = this[this.selectedIndex].value.substr(0, 5) + "*";
          sendRequest("dong", regcode);
        } else {
          initOption("dong");
        }
      });

      function sendRequest(selid, regcode) {
        const url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
        let params = "regcode_pattern=" + regcode + "&is_ignore_zero=true";
        fetch(`${url}?${params}`)
          .then((response) => response.json())
          .then((data) => addOption(selid, data));
      }

      function addOption(selid, data) {
        let opt = ``;
        initOption(selid);
        switch (selid) {
          case "sido":
            opt += `<option value="">시도선택</option>`;
            data.regcodes.forEach(function (regcode) {
              opt += `
              <option value="${regcode.code}">${regcode.name}</option>
              `;
            });
            break;
          case "gugun":
            opt += `<option value="">구군선택</option>`;
            for (let i = 0; i < data.regcodes.length; i++) {
              if (i != data.regcodes.length - 1) {
                if (
                  data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] &&
                  data.regcodes[i].name.split(" ").length !=
                    data.regcodes[i + 1].name.split(" ").length
                ) {
                  data.regcodes.splice(i, 1);
                  i--;
                }
              }
            }
            let name = "";
            data.regcodes.forEach(function (regcode) {
              if (regcode.name.split(" ").length == 2) name = regcode.name.split(" ")[1];
              else name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
              opt += `
              <option value="${regcode.code}">${name}</option>
              `;
            });
            break;
          case "dong":
            opt += `<option value="">동선택</option>`;
            let idx = 2;
            data.regcodes.forEach(function (regcode) {
              if (regcode.name.split(" ").length != 3) idx = 3;
              opt += `
              <option value="${regcode.code}">${regcode.name.split(" ")[idx]}</option>
              `;
            });
        }
        document.querySelector(`#${selid}`).innerHTML = opt;
      }

      function initOption(selid) {
        let options = document.querySelector(`#${selid}`);
        options.length = 0;
        // let len = options.length;
        // for (let i = len - 1; i >= 0; i--) {
        //   options.remove(i);
        // }
      }

      ///////////////////////// 아파트 매매 정보 /////////////////////////
      document.querySelector("#list-btn").addEventListener("click", function () {
        let url =
          "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
        let gugunSel = document.querySelector("#gugun");
        let regCode = gugunSel[gugunSel.selectedIndex].value.substr(0, 5);
        let yearSel = document.querySelector("#year");
        let year = yearSel[yearSel.selectedIndex].value;
        let monthSel = document.querySelector("#month");
        let month = monthSel[monthSel.selectedIndex].value;
        let dealYM = year + month;
        let queryParams =
          encodeURIComponent("serviceKey") + "=" + "9M5MYlIwaecloQpCGRlqkwJhu%2BYqdKvdFJU8o1n%2BS9%2BujQ3nugDB7yJVc37uhldYHXWtiYvFeWgjCcQ9xzpFDA%3D%3D"; /*Service Key*/
        queryParams +=
          "&" +
          encodeURIComponent("LAWD_CD") +
          "=" +
          encodeURIComponent(regCode); /*아파트소재 구군*/
        queryParams +=
          "&" + encodeURIComponent("DEAL_YMD") + "=" + encodeURIComponent(dealYM); /*조회년월*/
        queryParams +=
          "&" + encodeURIComponent("pageNo") + "=" + encodeURIComponent("1"); /*페이지번호*/
        queryParams +=
          "&" + encodeURIComponent("numOfRows") + "=" + encodeURIComponent("300"); /*페이지당건수*/

        fetch(`${url}?${queryParams}`)
          .then((response) => response.text())
          .then((data) => makeList(data))
      });

      function makeList(data) {
        document.querySelector("table").setAttribute("style", "display: ;");
        let tbody = document.querySelector("#aptlist");
        let parser = new DOMParser();
        const xml = parser.parseFromString(data, "application/xml");
        // console.log(xml);
        initTable();
        let apts = xml.querySelectorAll("item");

        let positions = [];

        let sidoName = document.getElementById("sido")[document.getElementById("sido").selectedIndex].textContent;
        let gugunName = document.getElementById("gugun")[document.getElementById("gugun").selectedIndex].textContent;
        let dongName = document.getElementById("dong")[document.getElementById("dong").selectedIndex].textContent;

        let locationInfo = [];
        
    
         // 뒤에 동이름 붙여야됨.

        let checkCount = 0;
        apts.forEach((apt) => {
          // console.log(dongName);
          // console.log(apt.querySelector("법정동").textContent);
          // console.log(dongName.trim() === apt.querySelector("법정동").textContent.trim());


          //30개만 출력하도록 함.
          if(checkCount >= 30){
            return;
          }

          if(dongName.trim() === '동선택' || dongName.trim() === apt.querySelector("법정동").textContent.trim()){
            checkCount += 1;
            let addressName = sidoName +" "+ gugunName;
            addressName = addressName + apt.querySelector("법정동").textContent + " "+ apt.querySelector("지번").textContent;

            let tr = document.createElement("tr");
            tr.setAttribute("onclick","test(this)");
            tr.setAttribute("value",addressName);

            let nameTd = document.createElement("td");
            nameTd.appendChild(document.createTextNode(apt.querySelector("아파트").textContent));
            tr.appendChild(nameTd);

            let floorTd = document.createElement("td");
            floorTd.appendChild(document.createTextNode(apt.querySelector("층").textContent));
            tr.appendChild(floorTd);

            let areaTd = document.createElement("td");
            areaTd.appendChild(document.createTextNode(apt.querySelector("전용면적").textContent));
            tr.appendChild(areaTd);

            let dongTd = document.createElement("td");
            dongTd.appendChild(document.createTextNode(apt.querySelector("법정동").textContent));
            tr.appendChild(dongTd);

            let priceTd = document.createElement("td");
            priceTd.appendChild(
              document.createTextNode(apt.querySelector("거래금액").textContent + "만원"),
            );
            priceTd.classList.add("text-end");
            tr.appendChild(priceTd);

            tbody.appendChild(tr);

            positions.push({
              "name": addressName,
              "aptName" : apt.querySelector("아파트").textContent
            });

          }

          

        });

        var map = new kakao.maps.Map(container, options);

        var geocoder = new kakao.maps.services.Geocoder();   

        let lastCoords;

        var bounds = new kakao.maps.LatLngBounds();
        

        //주소 가져오기
        positions.forEach((position) => {

            let addName = position["name"];
            // 주소로 좌표를 검색합니다
            geocoder.addressSearch(addName, function(result, status) {

                // 정상적으로 검색이 완료됐으면 
                if (status === kakao.maps.services.Status.OK) {


                    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                    // locationInfo.push({
                    //     name : position["aptName"],
                    //     latlng : coords
                    // })

                    // 결과값으로 받은 위치를 마커로 표시합니다
                    var marker = new kakao.maps.Marker({
                        map: map,
                        title : position["aptName"] + "\n" + position["name"],
                        position: coords
                    });

                    // 인포윈도우로 장소에 대한 설명을 표시합니다
                    // var infowindow = new kakao.maps.InfoWindow({
                    //     content: `<div style="width:150px;text-align:center;padding:6px 0;">${position["name"]}</div>`
                    // });
                    // infowindow.open(map, marker);
                    
                    // lastCoords = {
                    //   lat : result[0].y,
                    //   lng : result[0].x
                    // };

                    bounds.extend(coords);
                    map.setBounds(bounds);
                    

                    // map.setCenter(lastCoords);

                    // console.log(map.getCenter());
                  
                } 
                
            });

        });
        
        
        

        
    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        //console.log(lastCoords);
        //map.setCenter(lastCoords);


        // var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"

        // for (var i = 0; i < locationInfo.length; i++) {
    
        //     // 마커 이미지의 이미지 크기 입니다
        //     var imageSize = new kakao.maps.Size(24, 35); 
            
        //     // 마커 이미지를 생성합니다    
        //     var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
            
        //     // 마커를 생성합니다
        //     var marker = new kakao.maps.Marker({
        //         map: map, // 마커를 표시할 지도
        //         position: positions[i].latlng, // 마커를 표시할 위치
        //         title : positions[i].name, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        //         image : markerImage // 마커 이미지 
        //     });
        // }
    }

      function initTable() {
        let tbody = document.querySelector("#aptlist");
        let len = tbody.rows.length;
        for (let i = len - 1; i >= 0; i--) {
          tbody.deleteRow(i);
        }
      }

    </script>
        </div>
      </div>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
    <script src="js/aptList.js"></script>
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <!-- * *                               SB Forms JS                               * *-->
    <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
  </body>
</html>
