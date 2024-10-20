<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  <!-- 날짜 포멧 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>등록 화면(boardForm.jsp)</h3>
<!-- http://localhost/FreeBoard/addBoardForm.do -->
<!-- 저장누르면 파라메터 나옴 -->
<!-- http://localhost/FreeBoard/addBoard.do?title=%EA%B3%A7+%EC%A0%90%EC%8B%AC%EC%8B%9C%EA%B0%84%EC%9D%B4%EC%97%90%EC%9A%94&content=%EB%A7%9B%EB%82%98%EA%B2%8C+%EB%93%9C%EC%84%B8%EC%9A%A9&writer=user01 -->
<c:if test="msg != null)">
	<p style="color: red;">${msg }</p>
</c:if>

<form action="addBoard.do" method="post">
	<input type="hidden" name="writer" id="writer" value="${sessionScope.logId}">
	<table class="table">
		<tr>
			<th>제목</th><td><input type="text" name="title" id="title" class="form-control"></td>
		</tr>
		<tr>
			<th>내용</th><td><textarea rows="3" cols="30" name="content" id="content" class="form-control"></textarea> </td>
		</tr>
		<tr>
			<th>작성자</th><td>${sessionScope.logId}</td>
		</tr>
		<tr>
			<td colspan="2" align="center" >
				<input type="submit" class="btn btn-danger" <c:if test="${sessionScope.logId == null }">disabled</c:if> value="저장">
				<input type="reset" class="btn btn-warning" value="취소">
			</td>
		</tr>
	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>