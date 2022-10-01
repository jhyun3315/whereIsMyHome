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
              opt += `<option value="${regcode.code}">${regcode.name}</option>`;
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
      }
      
      
      
      
      
      
      
      
////////////////////////////////////////////아파트 거래 조회////////////////////////////////////////////
      
      document.querySelector("#list-btn").addEventListener("click", function () {
    	let root = window.location.pathname; 
      	//api 호출을 통해서 가져오는 것이 아닌 서블릿에 요청해서 가져와야됨.
      	let dongName = document.getElementById("dong").value; 
      	let year = document.getElementById("year").value;
        let month = document.getElementById("month").value;
        console.log(dongName);
        console.log(parseInt(year));
        console.log(parseInt(month)); 
       
        	
        let queryParams ="";
        queryParams += "dongName" + "=" + dongName;
        queryParams += "&" + "year" + "=" + year;
        queryParams += "&" + "month" + "=" + month;
        
      	console.log(queryParams);
      	console.log(root+"?action=mapform&"+queryParams);
          
      	fetch(root+"?action=mapform&"+queryParams) 
            .then((response) => response.json())
            .then((data) => { 
            	makeList(data);
            })
       });
      
      
      function makeList(data) { 
      	console.log(data);
      	  
          document.querySelector("table").setAttribute("style", "display: ;");
          let tbody = document.querySelector("#aptlist");  
          initTable(); 
          
         for(var i=0;i<data.length;i++){
        	 const djson = JSON.parse(data[i]);
             console.log(djson);
        	 let addressName = "";

             let tr = document.createElement("tr");
             tr.setAttribute("onclick","test(this)");
             tr.setAttribute("value",addressName);

             let nameTd = document.createElement("td");
             nameTd.appendChild(document.createTextNode(djdon.apartmentName));
             tr.appendChild(nameTd);

             let floorTd = document.createElement("td");
             floorTd.appendChild(document.createTextNode(djdon.floor));
             tr.appendChild(floorTd);

             let areaTd = document.createElement("td");
             areaTd.appendChild(document.createTextNode(djdon.area));
             tr.appendChild(areaTd);

             let dongTd = document.createElement("td");
             dongTd.appendChild(document.createTextNode(djdon.dongName));
             tr.appendChild(dongTd);

             let priceTd = document.createElement("td");
             priceTd.appendChild(
               document.createTextNode(djdon.dealAmount + "만원"));
             priceTd.classList.add("text-end");
             tr.appendChild(priceTd);

             tbody.appendChild(tr);
         }
      }
          
 	 
          
          function initTable() {
              let tbody = document.querySelector("#aptlist");
              let len = tbody.rows.length;
              for (let i = len - 1; i >= 0; i--) {
                tbody.deleteRow(i);
              }
            }
          
//          
//          
//          var map = new kakao.maps.Map(container, options); 
//          var geocoder = new kakao.maps.services.Geocoder();    
//          let lastCoords; 
//          var bounds = new kakao.maps.LatLngBounds();
//          
//
//          //주소 가져오기
//          positions.forEach((position) => {
//
//              let addName = position["name"];
//              // 주소로 좌표를 검색합니다
//              geocoder.addressSearch(addName, function(result, status) {
//
//                  // 정상적으로 검색이 완료됐으면 
//                  if (status === kakao.maps.services.Status.OK) {
//
//
//                      var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
//                      // locationInfo.push({
//                      //     name : position["aptName"],
//                      //     latlng : coords
//                      // })
//
//                      // 결과값으로 받은 위치를 마커로 표시합니다
//                      var marker = new kakao.maps.Marker({
//                          map: map,
//                          title : position["aptName"] + "\n" + position["name"],
//                          position: coords
//                      });
//
//                      // 인포윈도우로 장소에 대한 설명을 표시합니다
//                      // var infowindow = new kakao.maps.InfoWindow({
//                      //     content: `<div style="width:150px;text-align:center;padding:6px 0;">${position["name"]}</div>`
//                      // });
//                      // infowindow.open(map, marker);
//                      
//                      // lastCoords = {
//                      //   lat : result[0].y,
//                      //   lng : result[0].x
//                      // };
//
//                      bounds.extend(coords);
//                      map.setBounds(bounds);
//                      
//
//                      // map.setCenter(lastCoords); 
//                      // console.log(map.getCenter());
//                    
//                  } 
//                  
//              });
//
//          });
//          
           
      