function test(index) {
  //let temp = document.getElementById("apt-table-graph").rows[0];

  let address = index.getAttribute("value"); // geocoder로 변환할 주소.

  let aptName = index.cells[0].innerText;
  let floor = index.cells[1].innerText;
  let area = index.cells[2].innerText;
  let money = index.cells[4].innerText;

  var mapContainer = document.getElementById("map"), // 지도를 표시할 div
    mapOption = {
      center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
      level: 2, // 지도의 확대 레벨
    };

  // 지도를 생성합니다
  var map = new kakao.maps.Map(mapContainer, mapOption);

  // 주소-좌표 변환 객체를 생성합니다
  var geocoder = new kakao.maps.services.Geocoder();

  // 주소로 좌표를 검색합니다
  geocoder.addressSearch(address, function (result, status) {
    // 정상적으로 검색이 완료됐으면
    if (status === kakao.maps.services.Status.OK) {
      var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

      // 결과값으로 받은 위치를 마커로 표시합니다
      var marker = new kakao.maps.Marker({
        map: map,
        position: coords,
      });

      // 인포윈도우로 장소에 대한 설명을 표시합니다
      var infowindow = new kakao.maps.InfoWindow({
        content: `<div style="display: inline-block; padding:6px 0;">
          <h3 style="text-align: center;">아파트 정보</h3>
          <ul>
          <li>주소 : ${address}</li>
          <li>아파트 이름 : ${aptName}</li>
          <li>층 : ${floor}</li>
          <li>면적 : ${area}㎡</li>
          <li>거래금액 : ${money}</li>
          </ul>
          </div>`,
      });
      infowindow.open(map, marker);

      // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
      map.setCenter(coords);
    }
  });
}
