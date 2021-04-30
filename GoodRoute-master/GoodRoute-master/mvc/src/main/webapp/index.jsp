<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="static/css/main.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="static/css/jsmobilemenu.css">
    <script type="text/javascript" src="static/js/jsmobilemenu.js"></script>
    
    <script	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xxf0abecefdfb947269883c0008f7f6166"></script>
    <!-- <script type="text/javascript" src="static/js/map.js"></script> -->
    <script type="text/javascript" src="static/js/geocoding.js"></script>
    
    <title>굿루트</title>
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
            <button type="button" id="bi-camera"><img value="pos" src="static/image/camera.png" alt="" onClick="location.href='./qr.do'"></button>
            <button type="button" id="button_pos"><img value="pos" src="static/image/mylocation.png" alt="" onClick="location.href='./mylocation.do'"></button>
            
            <form method="post" action="startEndPoint.do" name="startSave">
			    	출발지 : <input type="text" id="startpoint" name="startpoint"/>
			    	<input type="button" id="btn_startpoint" value="좌표 불러오기>>">
			    	<input type="text" id="start_latlng" name="start_latlng">
			    	<br>
			    	
			    	도착지 : <input type="text" id="endpoint" name="endpoint"/>
			    	<input type="button" id="btn_endpoint" value="좌표 불러오기>>">
			    	<input type="text" id="end_latlng" name="end_latlng">
			    	<input type="submit" name="Submit" value="좌표저장" />
		   	</form>
        </nav>
        
        <!--지도 / 최적화 아이콘 삽입-->
        <div id="content">
            <!--지도-->
            <section id="main-section">
                <div id="map_div"></div>
            </section>

            <!-- 최적화 아이콘-->
            <aside id="main-aside">
                <button type="button_1"><a href="./goodroute.do">최적화</a></button>
            </aside>
        </div>
        
        <!--끝-->
        <footer id="main-footer">
            
        </footer>
    </div>
</body>
</html>


