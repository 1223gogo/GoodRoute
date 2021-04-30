<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="static/css/QR.css">
    <script charset='utf-8' src="static/js/jsQR.js"></script>
    <title>QR인식</title>
</head>
<body>
    <div id="page-wrapper">
        <!--메인 이름-->
        <header id="main-header">
            <h1>굿 루트</h1>
            <h3>너도 배달 할 수 있어</h3>
        </header>

        <!--아이콘 삽입 할 곳-->
        <nav id="main-navigation">
            QR CODE
            <!--뒤로가기 -->
            <button id="back" type="button" onClick="location.href='./'">홈으로</button>
        </nav>
        
        <!--QR 삽입-->
        <div id="content">
            <section id="main-section">
                <div id="loadingMessage">🎥 Unable to access video stream (please make sure you have a webcam enabled)</div>
				  <canvas id="canvas" hidden></canvas>
				  <form method="post" action="qr.do" name="qrCam">
					    <div id="output">
						    <div>
						    	<b>Data:</b> 
						    	<input type="text" id="outputData" name="outputData"/>
						    	<input type="submit" name="Submit" value="추가" />
						    </div>
						  </div>
				   	</form>
				   	<div id="result"></div>
	  			<script charset='utf-8' src="static/js/jsQR-Demo.js"></script>
            </section>

        </div>
        
        <!--끝-->
        <footer id="main-footer">
            
        </footer>
    </div>
</body>
</html>
