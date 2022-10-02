


function rm_tr_map_btn(idx){
	let root = window.location.pathname;
	  fetch(root+"?action=rminst&idx="+idx) 
	  .then((response) => response.json())
	  .then((data) => { 
	   if(data >0) {
		   document.getElementById("tr_"+idx).replaceChildren();
		   alert("삭제 되었습니다.");
	   }
	 }) 
}; 




function search_tr_map_btn(idx) {
	  
  	let root = window.location.pathname;   
  	
    let target = document.getElementById("tr_"+idx); 
    
    console.log(target);
    
//    let year = document.getElementById("year").value;
//    let month = document.getElementById("month").value; 
//    let queryParams ="";
//    queryParams += "dongName" + "=" + dongName;
//    queryParams += "&" + "year" + "=" + year;
//    queryParams += "&" + "month" + "=" + month;
//       
//        
//    fetch(root+"?action=mapform&"+queryParams) 
//         .then((response) => response.json())
//         .then((data) => { 
//          makeList(data);
//        })
//        
//        
}
    
    
//    function makeList(data) {   
//  	  var tmpArr =[data.length]; 
//  	  if(tmpArr != 0){ 
//	          let tbody = document.querySelector("#aptlist");  
//	   
//		        
//		         
//		         var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
//		         mapOption = { 
//		             center: new kakao.maps.LatLng(35.8773582, 128.6042956), // 지도의 중심좌표
//		             level: 7 // 지도의 확대 레벨
//		         };
//		      
//			     var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
//			    	 
//			    var imageSrc =  "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";                               // 마커이미지 주소
//			    var imageSize = new kakao.maps.Size(34, 36);                // 마커이미지의 크기
//			    var imageOption = {offset: new kakao.maps.Point(17, 36)};   // 마커의 좌표와 일치시킬 이미지 안에서의 좌표설정
//			    	      
//			    // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
//			    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
//			    	
//			    	 // 주소-좌표 변환 객체를 생성합니다
//		      	  var geocoder = new kakao.maps.services.Geocoder();  
//		      		 
//		      	  for(var i =0;i<positions.length;i++){
//		      		  var ele =  positions[i];  
//		      		   
//		      		  var add = ele.dongName+" "+ ele.roadName+" "+ele.roadNameBonbun;   
//		      		  
//		          	  // 주소로 좌표를 검색합니다
//			      	  geocoder.addressSearch(add, function (result, status) {
//			      	    // 정상적으로 검색이 완료됐으면
//			      	    if (status === kakao.maps.services.Status.OK) {
//			      	      var coords = new kakao.maps.LatLng(result[0].y, result[0].x); 
//			      	      // 결과값으로 받은 위치를 마커로 표시합니다
//		        	      var marker = new kakao.maps.Marker({
//		        	        map: map,
//		        	        position: coords, 
//		        	        
//		        	      });
//		        	      marker.id = ele.aptCode;
//		        	      marker.dongName = ele.dongName;
//			      	      
//		        	      // 인포윈도우로 장소에 대한 설명을 표시합니다
//		        	      var infowindow = new kakao.maps.InfoWindow({
//		        	        content: `<div id="`+ele.no+`">
//		        	          <h3 style="text-align: center;">아파트 정보</h3>
//		        	          <ul>
//		        	            <li>주소 : `+result[0].address.address_name+`</li>
//		        	        	<li>아파트 이름 : `+result[0].road_address.building_name+`</li>  
//		        	          </ul>
//		        	          </div>`,
//		        	      });
//		
//			      	      map.setCenter(coords);
//		        	      kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
//		        	      kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow)); 
//		        	      kakao.maps.event.addListener(marker, 'click', makeClickListener(marker)); 
//		        	      
//			      	    }
//			      	    
//				      	// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
//				      	  function makeOverListener(map, marker, infowindow) {
//				      	      return function() {
//				      	          infowindow.open(map, marker);
//				      	      };
//				      	  }
//			
//				      	  // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
//				      	  function makeOutListener(infowindow) {
//				      	      return function() {
//				      	          infowindow.close();
//				      	      };
//				      	  }
//				      	  
//				      var selectedMarker;
//				      
//				      function makeClickListener(marker) {
//				    	  console.log(marker.id); 
//				    	  return function() {
//				    		  let root = window.location.pathname; 
//				    		  console.log(root+"?action=deallist&aptCode="+marker.id+"&aptName=" +ele.apartmentName);
//					      	
//				    		  fetch(root+"?action=deallist&aptCode="+marker.id+"&aptName=" +ele.apartmentName) 
//					            .then((response) => response.json())
//					            .then((data) =>  detaillist(data,marker.dongName)) 
//					        }; 
//				      };
//			      
//			      	  });   
//		      	  
//		      	  } 
//		
//			    	// 지도 타입 변경 컨트롤을 생성한다
//			    	var mapTypeControl = new kakao.maps.MapTypeControl();
//			    	 
//			    	// 지도의 상단 우측에 지도 타입 변경 컨트롤을 추가한다
//			    	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);    
//			    	 
//			    	// 지도에 확대 축소 컨트롤을 생성한다
//			    	var zoomControl = new kakao.maps.ZoomControl();
//			    	 
//			    	// 지도의 우측에 확대 축소 컨트롤을 추가한다
//			    	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
//  	  }
//  	  else{
//  		  document.getElementById('map').innerHTML="거래 정보가 존재하지 않습니다.";
//  	  }
//
//    } 
	  
