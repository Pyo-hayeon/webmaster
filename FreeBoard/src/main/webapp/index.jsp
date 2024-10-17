<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@page import="com.yedam.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 이렇게 보여지지만 실제론 서블릿으로 만들어져서 실행되고 있음 -->
		<!-- 자바 코드 사용 가능해짐 -->
		<!-- MVC PATTEN 디자인 : View(JSP페이지), Model(DB처리), 컨트롤 형식으로 작업함 -->
		<!-- 컨트롤에 데이터를 jsp에 보내는 방법을 배울꺼임 -->
		<%
			String myName = "표하연";
			MemberService svc = new MemberServiceImpl();
			if (svc.retireMember("guest")) {
		%>
				<p>삭제되었습니다</p>
		<%
			} else {
		%>
				<p>회원정보가 없습니다</p>
		<%
			}
		%>
		<h3>내 이름은 <%=myName %>입니다.</h3>
	</body>
</html>