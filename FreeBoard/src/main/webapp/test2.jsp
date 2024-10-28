<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트(페이지 위치)</title>
<script src="js/jquery-3.7.1.js"></script>
<!-- js파일 연결 -->
<script>
	$(function() {
		$('p').on('click', function(){
			$('span').css('fontSize', "100px");	//전체
			//$(this).css('font-size', '100px');	//클릭한 태그만
		});
	});
</script>
</head>
<body>
	<p>하이 헬로우<span>asdf</span></p>
	<p>하이 헬로d우<span>asdf</span></p>
	<p>하이 헬sdf로우<span>asdf</span></p>
</body>
</html>