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
      
      
      
////////////////////////////////////////////관심지역 등록////////////////////////////////////////////  

	  document.querySelector("#regist-inst-btn").addEventListener("click", function () {
	    	let root = window.location.pathname; 
	    	
	    	let tmpsidoName = document.getElementById("sido");
	    	let sidoName= tmpsidoName.options[tmpsidoName.selectedIndex].textContent; 
	    	
	    	let tmpgugunName = document.getElementById("gugun");
	    	let gugunName = tmpgugunName.options[tmpgugunName.selectedIndex].textContent;  
	    	
	    	let tmpdongName = document.getElementById("dong");
	    	let dongName = tmpdongName.options[tmpdongName.selectedIndex].textContent;  
	    	 
	        let dongCode =tmpdongName.value; 
	    	
	    	
	    	let queryParams ="";
	         queryParams += "sidoName" + "=" + sidoName;
	         queryParams += "&" + "gugunName" + "=" + gugunName;
	         queryParams += "&" + "dongName" + "=" + dongName;
	         queryParams += "&" + "dongCode" + "=" + dongCode;

		    	console.log(queryParams);
		    	
			  fetch(root+"?action=registinst&"+queryParams)  
			   .then((response) => response.text())
			   .then((data) => { 
            	if(data>0){
            		alert("성공적으로 등록 됐습니다.");
            	}
            })
		  });
      
      
      
      
////////////////////////////////////////////아파트 거래 조회////////////////////////////////////////////
      

		  
	var positions = new Array(); 
      document.querySelector("#list-btn").addEventListener("click", function () {
    	let root = window.location.pathname; 
      	//api 호출을 통해서 가져오는 것이 아닌 서블릿에 요청해서 가져와야됨.
      	let dongName = document.getElementById("dong").value; 
      	let year = document.getElementById("year").value;
        let month = document.getElementById("month").value; 
        	
        let queryParams ="";
        queryParams += "dongName" + "=" + dongName;
        queryParams += "&" + "year" + "=" + year;
        queryParams += "&" + "month" + "=" + month;
         
          
      	fetch(root+"?action=mapform&"+queryParams) 
            .then((response) => response.json())
            .then((data) => { 
            	makeList(data);
            })
       });
      
      
      function makeList(data) {   
    	  var tmpArr =[data.length]; 
    	  if(tmpArr != 0){ 
	          document.querySelector("table").setAttribute("style", "display: ;");
	          let tbody = document.querySelector("#aptlist");  
	          initTable();
	   
		         for(var i=0;i<data.length;i++){
		        	var djson = JSON.parse(JSON.stringify(data[i]));  
		     		var obj = new Object() ;
		     		obj.apartmentName = djson.apartmentName;
		     		obj.dongName = djson.dongName;
		     		obj.roadName = djson.roadName;
		     		obj.roadNameBonbun = djson.roadNameBonbun;
		     		obj.lat =  djson.lat;
		     		obj.lng = djson.lng; 
		     		obj.dongCode = djson.dongCode;
		     		obj.aptCode = djson.aptCode;
		     		obj.floor= djson.floor;
		     		obj.area = djson.area;
		     		obj.dealAmount = djson.dealAmount;
		     		
		     		
		     		positions.push(obj);
		        	 
		        	 let addressName = djson.roadName+" "+djson.roadNameBonbun;
		
		             let tr = document.createElement("tr");
//		             tr.setAttribute("onclick","test(this)");
		             tr.setAttribute("value",djson.no);
		
		             let nameTd = document.createElement("td");
		             nameTd.appendChild(document.createTextNode(djson.apartmentName));
		             tr.appendChild(nameTd);
		
		             let floorTd = document.createElement("td");
		             floorTd.appendChild(document.createTextNode(djson.floor));
		             tr.appendChild(floorTd);
		
		             let areaTd = document.createElement("td");
		             areaTd.appendChild(document.createTextNode(djson.area));
		             tr.appendChild(areaTd);
		
		             let dongTd = document.createElement("td");
		             dongTd.appendChild(document.createTextNode(djson.dongName));
		             tr.appendChild(dongTd);
		
		             let priceTd = document.createElement("td");
		             priceTd.appendChild(
		               document.createTextNode(djson.dealAmount + "만원"));
		             priceTd.classList.add("text-end");
		             tr.appendChild(priceTd);
		              
		             tbody.appendChild(tr);
		         } 
		         
		         var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		         mapOption = { 
		             center: new kakao.maps.LatLng(35.8773582, 128.6042956), // 지도의 중심좌표
		             level: 7 // 지도의 확대 레벨
		         };
		      
			     var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			    	 
			    var imageSrc =  "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";                               // 마커이미지 주소
			    var imageSize = new kakao.maps.Size(34, 36);                // 마커이미지의 크기
			    var imageOption = {offset: new kakao.maps.Point(17, 36)};   // 마커의 좌표와 일치시킬 이미지 안에서의 좌표설정
			    	      
			    // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
			    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
			    	
			    	 // 주소-좌표 변환 객체를 생성합니다
		      	  var geocoder = new kakao.maps.services.Geocoder();  
		      		 
		      	  for(let i=0;i<positions.length;i++){
		      		  var ele =  positions[i];  
		      		   
		      		  var add = ele.dongName+" "+ ele.roadName+" "+ele.roadNameBonbun;   
		      		  
		          	  // 주소로 좌표를 검색합니다
			      	  geocoder.addressSearch(add, function (result, status) {
			      	    // 정상적으로 검색이 완료됐으면
			      	    if (status === kakao.maps.services.Status.OK) {
			      	      var coords = new kakao.maps.LatLng(result[0].y, result[0].x); 
			      	      // 결과값으로 받은 위치를 마커로 표시합니다
		        	      var marker = new kakao.maps.Marker({
		        	        map: map,
		        	        position: coords, 
		        	        
		        	      });
		        	      
		        	      marker.id = ele.aptCode;
		        	      marker.dongName = ele.dongName;
//			      	      console.log(marker.id +","+ marker.dongName);
		        	      
		        	      // 인포윈도우로 장소에 대한 설명을 표시합니다
		        	      var infowindow = new kakao.maps.InfoWindow({
		        	        content: `<div id="`+ele.no+`">
		        	          <h3 style="text-align: center;">아파트 정보</h3>
		        	          <ul>
		        	            <li>주소 : `+result[0].address.address_name+`</li>
		        	        	<li>아파트 이름 : `+result[0].road_address.building_name+`</li>  
		        	          </ul>
		        	          </div>`,
		        	      });

			      	      map.setCenter(coords); 
		        	      kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		        	      kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow)); 
		        	      kakao.maps.event.addListener(marker, 'click', makeClickListener(marker)); 
			      	    }
			      	    
				      	// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
				      	  function makeOverListener(map, marker, infowindow) {
				      	      return function() {
				      	          infowindow.open(map, marker);
				      	      };
				      	  }
			
				      	  // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
				      	  function makeOutListener(infowindow) {
				      	      return function() {
				      	          infowindow.close();
				      	      };
				      	  }
				      	   
				      
					      function makeClickListener(marker) {
//					    	  console.log(marker.id+","+marker.dongName+","+ele.apartmentName); 
					    	  
					    	  return function() {
					    		  let root = window.location.pathname; 
					    		  console.log(root+"?action=deallist&aptCode="+marker.id+"&aptName=" +ele.apartmentName);
						      	
					    		  fetch(root+"?action=deallist&aptCode="+marker.id+"&aptName=" +ele.apartmentName) 
						            .then((response) => response.json())
						            .then((data) =>  detaillist(data,marker.dongName)) 
						        }; 
					      };
			      
			      	  });   
		      	  
		      	  } 
		
			    	// 지도 타입 변경 컨트롤을 생성한다
			    	var mapTypeControl = new kakao.maps.MapTypeControl();
			    	 
			    	// 지도의 상단 우측에 지도 타입 변경 컨트롤을 추가한다
			    	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);    
			    	 
			    	// 지도에 확대 축소 컨트롤을 생성한다
			    	var zoomControl = new kakao.maps.ZoomControl();
			    	 
			    	// 지도의 우측에 확대 축소 컨트롤을 추가한다
			    	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
    	  }
    	  else{
    		  document.getElementById('map').innerHTML="거래 정보가 존재하지 않습니다.";
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
           
         function detaillist(data, dongName){ 
       	  var tmpArr =[data.length];  
	          document.querySelector("table").setAttribute("style", "display: ;");
	          let tbody = document.querySelector("#aptlist");  
	          initTable();
	   
		         for(var i=0;i<data.length;i++){
		        	var djson = JSON.parse(JSON.stringify(data[i]));  
		        	 
		        	 let addressName = djson.roadName+" "+djson.roadNameBonbun;
		
		             let tr = document.createElement("tr"); 
		
		             let nameTd = document.createElement("td");
		             nameTd.appendChild(document.createTextNode(djson.aptName));
		             tr.appendChild(nameTd);
		
		             let floorTd = document.createElement("td");
		             floorTd.appendChild(document.createTextNode(djson.floor));
		             tr.appendChild(floorTd);
		
		             let areaTd = document.createElement("td");
		             areaTd.appendChild(document.createTextNode(djson.area));
		             tr.appendChild(areaTd);
		
		             let dongTd = document.createElement("td");
		             dongTd.appendChild(document.createTextNode(dongName));
		             tr.appendChild(dongTd);
		
		             let priceTd = document.createElement("td");
		             priceTd.appendChild(document.createTextNode(djson.dealAmount + "만원"));
		             tr.appendChild(priceTd);
		             
		             let dateTd = document.createElement("td");
		             dateTd.appendChild(document.createTextNode(djson.dealYear+"."+djson.DealMonth+"."+djson.DealDay));
		             priceTd.classList.add("text-end");
		             tr.appendChild(dateTd); 
		             
		              
		             tbody.appendChild(tr);
		         }   
         	} 