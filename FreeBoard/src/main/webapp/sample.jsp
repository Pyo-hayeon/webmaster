<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webapp/sample.jsp(페이지 위치)</title>
<script src="js/jquery-3.7.1.js"></script> <!-- js파일 연결 -->
<script>
	//페이지 로딩이 다끝난 후에 실행 되도록 하겠다
	document.addEventListener('DOMContentLoaded', function(e) {
		//jquery 객체 생성
		$('<ul />')	// document.createElement('ul') 과 동일한것 [j쿼리 객체라고 함]
		.append($('<li>사과</li>')		// <ul><li>사과</li></ul>
				,$('<li />').html('바나나')	//innerHTML = '바나나' 와 동일함
				,$('<li />').text('복숭아')	//innerText = '복숭아' 와 동일함
		).appendTo($('body'));	//만들어진것을 body 태그아래에 붙이겠습니다.
	});
	

	//document.addEventListener('DOMContentLoaded', function(e) { 이거와 동일한거 = $(function(){});
	$(function() {
	    $("p").on("click", function() {        // <p>요소를 모두 선택함.
	        //$("span").css("fontSize", "28px"); // <span>요소를 모두 선택함.
	        $(this).find("span").css("fontSize", "28px");
	    });
	});
	
	
	//위에 제이쿼리를 이렇게 자바스크립트로 쓸수있음
	document.addEventListener('DOMContentLoaded', function(e) {
		document.querySelectorAll('p').forEach(item=>{
			item.addEventListener('click', function(e){
				/*
				document.querySelectorAll('span').forEach(span=>{
					span.style.fontSize = '28px';	
				});
				*/
				this.querySelector('span').style.fontSize = '28px';
			});
		});
	});
	
</script>
</head>
<body>
	<p>첫 번째 문장입니다. <span>여기에 있는 텍스트</span>가 있습니다.</p>
	<p>두 번째 문장입니다. <span>다른 텍스트</span>가 있습니다.</p>
	<!-- webapp/sample.jsp(위치) -->
</body>
</html>