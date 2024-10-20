<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  <!-- 날짜 포멧 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>삭제 화면(deleteForm.jsp)</h3>
<!-- http://localhost/FreeBoard/modifyBoard.do?bno=1 -->
<c:if test="msg != null)">
	<p style="color: red;">${msg }</p>
</c:if>

<form action="deleteBoard.do" method="post">
	<input type="hidden" value="${boardvo.boardNo }" id="bno" name="bno">
	<table class="table">
		<tr>
			<th>글번호</th><td>${boardvo.boardNo }</td>
			<th>조회수</th><td>${boardvo.viewCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${boardvo.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea readonly rows="3" cols="30" name="content" id="content" class="form-control">${boardvo.content }</textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${boardvo.writer }</td>
		</tr>
		<tr>
			<td colspan="4" align="center" >
				<input type="submit" class="btn btn-danger" 
					<c:if test="${sessionScope.logId != null && sessionScope.logId == boardvo.writer }"></c:if>
					<c:if test="${sessionScope.logId == null || sessionScope.logId != boardvo.writer }">disabled</c:if>
					 value="삭제">
				<input type="reset" class="btn btn-success" value="취소">
			</td>
		</tr>
	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>
<script>
	document.querySelector('input[value="취소"]')//
	.addEventListener('click', function(e) {
		history.back();
	});
</script>