var map, marker1;
function initTmap() {
	// 1. 지도 띄우기
	map = new Tmapv2.Map("map_div", {
		center : new Tmapv2.LatLng(37.570028, 126.986072),
		width : "100%",
		height : "400px",
		zoom : 15,
		zoomControl : true,
		scrollwheel : true

	});
	// 마커 초기화
	marker1 = new Tmapv2.Marker(
		{
			icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_b_m_a.png",
			iconSize : new Tmapv2.Size(24, 38),
			map : map
		});

	$("#btn_startpoint").click(function() {
		// 2. API 사용요청
		var fullAddr = $("#startpoint").val();
		
		$.ajax({
			method : "GET",
			url : "https://apis.openapi.sk.com/tmap/geo/fullAddrGeo?version=1&format=json&callback=result",
			async : false,
			data : {
				"appKey" : "l7xxf0abecefdfb947269883c0008f7f6166",
				"coordType" : "WGS84GEO",
				"fullAddr" : fullAddr
			},
			success : function(response) {

				var resultInfo = response.coordinateInfo; // .coordinate[0];
				console.log(resultInfo);
				
				// 기존 마커 삭제
				marker1.setMap(null);
				
				// 3.마커 찍기
				// 검색 결과 정보가 없을 때 처리
				if (resultInfo.coordinate.length == 0) {
					$("#content").text(
					"요청 데이터가 올바르지 않습니다.");
				} else {
					var lon, lat;
					var resultCoordinate = resultInfo.coordinate[0];
					if (resultCoordinate.lon.length > 0) {
						// 구주소
						lon = resultCoordinate.lon;
						lat = resultCoordinate.lat;
					} else { 
						// 신주소
						lon = resultCoordinate.newLon;
						lat = resultCoordinate.newLat
					}
				
					/*var lonEntr, latEntr;
					
					if (resultCoordinate.lonEntr == undefined && resultCoordinate.newLonEntr == undefined) {
						lonEntr = 0;
						latEntr = 0;
					} else {
						if (resultCoordinate.lonEntr.length > 0) {
							lonEntr = resultCoordinate.lonEntr;
							latEntr = resultCoordinate.latEntr;
						} else {
							lonEntr = resultCoordinate.newLonEntr;
							latEntr = resultCoordinate.newLatEntr;
						}
					}
						*/
					var markerPosition = new Tmapv2.LatLng(Number(lat),Number(lon));
					$("#start_latlng").val(lat+", "+lon);
					
					// 마커 올리기
					marker1 = new Tmapv2.Marker(
						{
							position : markerPosition,
							icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_b_m_a.png",
							iconSize : new Tmapv2.Size(
							24, 38),
							map : map
						});
					map.setCenter(markerPosition);
				}
			},
			error : function(request, status, error) {
				console.log(request);
				console.log("code:"+request.status + "\n message:" + request.responseText +"\n error:" + error);
				// 에러가 발생하면 맵을 초기화함
				// markerStartLayer.clearMarkers();
				// 마커초기화
				map.setCenter(new Tmapv2.LatLng(37.570028, 126.986072));
			
			}
		});
	});
	$("#btn_endpoint").click(function() {
		// 2. API 사용요청
		var fullAddr = $("#endpoint").val();
		
		$.ajax({
			method : "GET",
			url : "https://apis.openapi.sk.com/tmap/geo/fullAddrGeo?version=1&format=json&callback=result",
			async : false,
			data : {
				"appKey" : "l7xxf0abecefdfb947269883c0008f7f6166",
				"coordType" : "WGS84GEO",
				"fullAddr" : fullAddr
			},
			success : function(response) {

				var resultInfo = response.coordinateInfo; // .coordinate[0];
				console.log(resultInfo);
				
				// 기존 마커 삭제
				marker1.setMap(null);
				
				// 3.마커 찍기
				// 검색 결과 정보가 없을 때 처리
				if (resultInfo.coordinate.length == 0) {
					$("#content").text(
					"요청 데이터가 올바르지 않습니다.");
				} else {
					var lon, lat;
					var resultCoordinate = resultInfo.coordinate[0];
					if (resultCoordinate.lon.length > 0) {
						// 구주소
						lon = resultCoordinate.lon;
						lat = resultCoordinate.lat;
					} else { 
						// 신주소
						lon = resultCoordinate.newLon;
						lat = resultCoordinate.newLat
					}
				
					/*var lonEntr, latEntr;
					
					if (resultCoordinate.lonEntr == undefined && resultCoordinate.newLonEntr == undefined) {
						lonEntr = 0;
						latEntr = 0;
					} else {
						if (resultCoordinate.lonEntr.length > 0) {
							lonEntr = resultCoordinate.lonEntr;
							latEntr = resultCoordinate.latEntr;
						} else {
							lonEntr = resultCoordinate.newLonEntr;
							latEntr = resultCoordinate.newLatEntr;
						}
					}
						*/
					var markerPosition = new Tmapv2.LatLng(Number(lat),Number(lon));
					$("#end_latlng").val(lat+", "+lon);
					
					// 마커 올리기
					marker1 = new Tmapv2.Marker(
						{
							position : markerPosition,
							icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_b_m_a.png",
							iconSize : new Tmapv2.Size(
							24, 38),
							map : map
						});
					map.setCenter(markerPosition);
				}
			},
			error : function(request, status, error) {
				console.log(request);
				console.log("code:"+request.status + "\n message:" + request.responseText +"\n error:" + error);
				// 에러가 발생하면 맵을 초기화함
				// markerStartLayer.clearMarkers();
				// 마커초기화
				map.setCenter(new Tmapv2.LatLng(37.570028, 126.986072));
			
			}
		});
	});

}