<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@page import="com.yedam.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- jstl사용한다는 선언 선언할 변수는 my -->
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
		
		<!-- Expression Language : EL (표현식)-->
		<!-- 톰켓의 JSP컨테이너가 가지고 있는 기능 -->
		<!-- 간단한 연산식을 사용가능하게 해준다 이항 삼항 연산 비교 등 간단한 표현식을 사용가능하다 -->
		<p>${"Hello" }</p>
		<p>${3+5 }</p>
		<p>${3+5>4 }</p>
		<p>${3+5>4 ? "OK" : "NG" }</p>
		<p>${logId }</p> <!-- 가장좋은건 세션값을 바로 가지고 올수있다 겟어트리뷰트 없이!! -->
		<!-- jsp가 기본으로 가지고있는 action tag -->
		<!-- JSP Standard Tag Library : JSTL -->
		<!-- 사용방법 -->
		<!-- name변수에 Hong라는 값을 담겠다 -->
		<c:set var="name" value="Hong"></c:set>
		<!-- 변수출력 -->
		<c:out value="${name }"></c:out>
		
		<c:set var="age" value="60"></c:set>
		
		<!-- 이프문 -->
		<c:if test="${age>=20 }">
			<p>성인 입니다</p>
		</c:if>
		<!-- 에스이프 -->
		<c:choose>
			<c:when test="${age>=60 }">
				<p>노인</p>
			</c:when>
			<c:when test="${age>=20 }">
				<p>성인</p>
			</c:when>
			<c:otherwise>
				<p>아이</p>
			</c:otherwise>
		</c:choose>
		<!-- 반복문 -->
		<c:forEach var="i" begin="1" end="11" step="3">
			<p>i의 값은 ${i }입니다.</p>
		</c:forEach>
		
		<!-- 해당페이지에 jstl 쓰려고 페이지 전환했음 -->
		<c:set var="page" value="boardlist.do"></c:set>
		<jsp:forward page="${page }"></jsp:forward>
		
		
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