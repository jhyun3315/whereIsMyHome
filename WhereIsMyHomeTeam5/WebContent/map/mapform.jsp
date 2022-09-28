<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script> 

<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
<link rel="stylesheet" href="${root}/css/aptInfo.css" />
	<script type="text/javascript">
	
	
	</script>
</head>

<body> 
	<%@ include file="/include/nav.jsp"%>
	<header class="py-5">
		<div style="margin-top: 20px">
			<div class="main-title">
				<p>아파트 실거래가</p>
			</div>
		</div>
		<div class="apt-info-section"
			style="display: flex; justify-content: center;">
			<div class="row col-md-12 justify-content-center mb-2" style="width: 80%;">
				<div class="form-group col-md-2">
					<select class="form-select bg-secondary text-light" id="sido" name="sido" onchange="selectBoxChange(this.value)">
						<option value="">시도선택</option>
						<c:forEach var="sidolist" items="${sidolist}" varStatus="status">
							<option value="${sidolist}">${sidolist}</option>
						</c:forEach>
					</select>
				</div>
				
				<script>
				function selectBoxChange(value){ 
					let form={"selsido" :value} ;
					
					$ajax({
					    url : "/map?act=mapform" ,
					    type : "POST",
					    data : form,
					    success : function(data){
					    	$('.result').text(data); },
					    	error:function(request, status, error){
								alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					    	} 
					    });
				}
				</script>


				<div class="form-group col-md-2">
					<select class="form-select bg-secondary text-light" id="gugun">
						<option value="">구군선택</option>
						<c:forEach var="gugun" items="${gugunlist}"	varStatus="status">
							<option value="${gugun}">${gugun}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-md-2">
					<select class="form-select bg-secondary text-light" id="dong">
						<option value="">동선택</option>
					</select>
				</div>
				<div class="form-group col-md-2">
					<select class="form-select bg-dark text-light" id="year">
						<option value="">매매년도 선택</option>
					</select>
				</div>
				<div class="form-group col-md-2">
					<select class="form-select bg-dark text-light" id="month">
						<option value="">매매월 선택</option>
					</select>
				</div>
				<div class="form-group col-md-2"
					style="margin-bottom: 20px; text-align: center;">
					<button type="button" id="list-btn" class="btn btn-outline-primary">
						아파트 매매정보 가져오기</button>
				</div>
			</div>
		</div>
		<div class="apt-info-map">
			<div id="map" style="width: 80%; height: 500px"></div>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1871958cf102bea477b49678891e9135&libraries=services">
		 </script>

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
				<table class="table table-hover text-center" id="apt-table-graph"
					style="display: none" onclick="test()">
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
	</header>
	<footer>
		<%@ include file="/include/footer.jsp"%>
	</footer>
</body>

</html>