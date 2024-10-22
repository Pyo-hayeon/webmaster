<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  <!-- 날짜 포멧 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<h3>상세페이지(board.jsp)</h3>
	<form action="modifyBoard.do" method="get">
	<input type="hidden" value="${boardvo.boardNo }" id="bno" name="bno">
	<input type="hidden" value="${searchCondition }" id="searchCondition" name="searchCondition">
	<input type="hidden" value="${keyword }" id="keyword" name="keyword">
	<table class="table">
		<tr>
			<th>글번호</th><td>${boardvo.boardNo }</td>
			<th>조회수</th><td>${boardvo.viewCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardvo.title }</td>
			<th>작성자</th>
			<td>${boardvo.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea readonly rows="4" cols="30" class="form-control">${boardvo.content }</textarea>
			</td>
		</tr>
		<c:if test="${boardvo.img!=null }">
		<tr>
			<th>이미지</th>
			<td colspan="3"><img src="images/${boardvo.img }" width="150px"></td>
		</tr>
		</c:if>
		<tr>
			<th>작성일시</th>
			<td colspan="3"><fmt:formatDate value="${boardvo.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="button" class="btn btn-warning" value="수정">
				<input type="button" class="btn btn-danger" value="삭제">
			</td>
		</tr>
	</table>
</form>
<!-- 댓글관련. -->
<table id="replyList" class="table">
	<thead>
		<tr>
			<th>댓글번호</th><th>내용</th><th>작성자</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>

<script>
	document.querySelector('input[value="수정"]')//
	.addEventListener('click', function(e) {
		location.href = 'modifyBoard.do?page=${page }&bno=${boardvo.boardNo }&searchCondition=${searchCondition }&keyword=${keyword }';
	});
	document.querySelector('input[value="삭제"]')//
	.addEventListener('click', function(e) {
		location.href = 'deleteBoard.do?bno=${boardvo.boardNo }';
	});
</script>
<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>