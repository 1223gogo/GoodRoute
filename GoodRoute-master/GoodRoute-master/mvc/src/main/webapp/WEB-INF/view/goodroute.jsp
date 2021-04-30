<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<title>굿루트</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="static/css/main.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">
<link rel="stylesheet" href="static/css/jsmobilemenu.css">
<script type="text/javascript" src="static/js/jsmobilemenu.js"></script>

<script	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xxf0abecefdfb947269883c0008f7f6166"></script>
<script type="text/javascript" >
var map;
var marker_s, marekr_e;

//경로그림정보
var drawInfoArr = [];

// 페이지가 로딩이 된 후 호출하는 함수입니다.
function initTmap(){
	// 1. 지도 띄우기
	map = new Tmapv2.Map("map_div", {
		center: new Tmapv2.LatLng(${latStart}, ${lngStart}),
		width : "100%",
		height : "600px",
		zoom : 13,
		zoomControl : true,
		scrollwheel : true
	});
	// 시작, 도착 심볼찍기
	// 시작
	marker_s = new Tmapv2.Marker({
		position : new Tmapv2.LatLng(${latStart}, ${lngStart}),
		icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_s.png",
		iconSize : new Tmapv2.Size(24, 38),
		map:map
	});
	
	// 도착 
	marker_e = new Tmapv2.Marker({
		position : new Tmapv2.LatLng(${latEnd}, ${lngEnd}),
		icon : "http://tmapapi.sktelecom.com/upload/tmap/marker/pin_r_m_e.png",
		iconSize : new Tmapv2.Size(24, 38),
		map:map
	});
	//경유지들 마커 표시
	<c:forEach var="i" begin="0" end="${fn:length(lats)-1}">
		<c:if test="${invoiceNums[i] != '000000' and invoiceNums[i] != '999999'}">
			//Marker 객체 생성.
			marker = new Tmapv2.Marker({
				position : new Tmapv2.LatLng(${lats[i]},${lngs[i]}), //Marker의 중심좌표 설정.
				map : map, //Marker가 표시될 Map 설정.
				title : "test"+${i}
			});
		</c:if>
	</c:forEach>
	
	var viaPoints = [
		<c:forEach var="i" begin="0" end="${fn:length(lats)-1}">
			<c:if test="${invoiceNums[i] != '000000' and invoiceNums[i] != '999999'}">
				{
			      "viaPointId": ${i},
			      "viaPointName": ${i},
			      "viaX": "${lngs[i]}",
			      "viaY": "${lats[i]}",
			  	},
			</c:if>
		</c:forEach>
	];
	
	var headers = {}; 
	headers["appKey"]="l7xxf0abecefdfb947269883c0008f7f6166";
	
	$.ajax({
		type:"POST",
		headers : headers,
		url:"https://apis.openapi.sk.com/tmap/routes/routeOptimization10?version=1&format=json",
		async:false,
		contentType: "application/json",
		data: JSON.stringify({
				  "reqCoordType": "WGS84GEO",
				  "resCoordType" : "EPSG3857",
				  "startName": "출발",
				  "startX": "${lngStart}",
				  "startY": "${latStart}",
				  "startTime": "202011121314",
				  "endName": "도착",
				  "endX": "${lngEnd}",
				  "endY": "${latEnd}",
				  "searchOption" : "0",
				  "viaPoints": viaPoints
		}),
		success:function(response){
			var resultData = response.properties;
			var resultFeatures = response.features;
			
			// 결과 출력
			var tDistance = "총 거리 : " + (resultData.totalDistance/1000).toFixed(1) + "km,  ";
			var tTime = "총 시간 : " + (resultData.totalTime/60).toFixed(0) + "분,  ";
			
			$("#result").text(tDistance+tTime);
			
			for(var i in resultFeatures) {
				var geometry = resultFeatures[i].geometry;
				var properties = resultFeatures[i].properties;
				var polyline_;
				
				drawInfoArr = [];
				if(geometry.type =="Point" && properties.pointType != "S" && properties.pointType != "E"){
					
				}
				if(geometry.type == "LineString") {
					for(var j in geometry.coordinates){
						// 경로들의 결과값(구간)들을 포인트 객체로 변환 
						var latlng = new Tmapv2.Point(geometry.coordinates[j][0], geometry.coordinates[j][1]);
						// 포인트 객체를 받아 좌표값으로 변환
						var convertPoint = new Tmapv2.Projection.convertEPSG3857ToWGS84GEO(latlng);
						// 포인트객체의 정보로 좌표값 변환 객체로 저장
						var convertChange = new Tmapv2.LatLng(convertPoint._lat, convertPoint._lng);
						
						drawInfoArr.push(convertChange);
					}

					polyline_ = new Tmapv2.Polyline({
						path : drawInfoArr,
						strokeColor : "#FF0000",
						strokeWeight: 5,
						map : map
					});
				}
			}
		},
		error:function(request,status,error){
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}	

</script>

</head>
<body onload="initTmap()">
    <div id="page-wrapper">
        <!--메인 이름-->
        <header id="main-header">
            <h1>굿 루트</h1>
            <h3>너도 배달 할 수 있어</h3>
        </header>

        <!--아이콘 삽입 할 곳-->
        <nav id="main-navigation">
            <button type="button" class="mobile-menu"><i class="fas fa-bars"></i></button>

			    <div class="menuwrap">
			        <nav id="menu">
			            <!-- "메뉴목록 표시" -->
			            <ul class="category_list">
			                <li class=""><a class="link_sub_item" href="./rank.do">경로 변경하기</a></li>
			                <hr>
			                <li class=""><a class="link_sub_item" href="./route.do">경로 불러오기</a></li>
			            </ul>            
			        </nav>
			    </div>
			    <button type="button" id="bi-home"><img value="pos" src="static/image/home.png" alt="" onClick="location.href='./'"></button>
			   	<form method="post" action="goodroute.do" name="goodrouteSave">
					    <input type="submit" name="goodrouteSubmit" value="경로저장" />
				</form>
        </nav>
        
        <!--지도 / 최적화 아이콘 삽입-->
        <div id="content">
        <p id = "result"></p>
            <!--지도-->
                <div id="map_div"></div>
        </div>
        
        <!--끝-->
        <footer id="main-footer">
            
        </footer>
    </div>
</body>
</html>