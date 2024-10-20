<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  <!-- 날짜 포멧 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>수정 화면(modifyForm.jsp)</h3>
<!-- http://localhost/FreeBoard/modifyBoard.do?bno=1 -->
<c:if test="msg != null)">
	<p style="color: red;">${msg }</p>
</c:if>
<form action="modifyBoard.do" method="post">
	<input type="hidden" value="${boardvo.boardNo }" id="bno" name="bno">
	<input type="hidden" value="${page }" id="page" name="page">
	<input type="hidden" value="${searchCondition }" id="searchCondition" name="searchCondition">
	<input type="hidden" value="${keyword }" id="keyword" name="keyword">
	<table class="table">
		<tr>
			<th>글번호</th><td>${boardvo.boardNo }</td>
			<th>조회수</th><td>${boardvo.viewCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="title" id="title" class="form-control" value="${boardvo.title }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea rows="3" cols="30" name="content" id="content" class="form-control">${boardvo.content }</textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${boardvo.writer }</td>
		</tr>
		<tr>
			<td colspan="4" align="center" > 
				<input type="submit" class="btn btn-success" 
					<c:choose>
						<c:when test="${sessionScope.logId != null && sessionScope.logId == boardvo.writer }">
						</c:when>
						<c:otherwise>
						disabled
						</c:otherwise>
					</c:choose>
				value="저장">
				<input type="reset" class="btn btn-warning" value="취소">
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