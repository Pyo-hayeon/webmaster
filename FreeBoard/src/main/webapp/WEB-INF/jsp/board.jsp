<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  <!-- 날짜 포멧 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<style>
	.reply span {
		display: inline-block;
	}
	.reply ul {
		list-style-type: none;
	}
</style>
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
<!-- 댓글관련 -->
<div class="container reply">
	<!-- 댓글 등록. -->
	<div class="header">
		댓글내용: <input class="col-sm-7" id="reply">
		<button class="col-sm-3" id="addReply">댓글등록</button>
	</div>
	<!-- 댓글 목록. -->
	<div class="content">
		<ul>
			<li>
				<span class="col-sm-2">글번호</span>
				<span class="col-sm-5">내용</span>
				<span class="col-sm-2">작성자</span>
				<span class="col-sm-2">관리</span>
			</li>
		</ul>
	</div>
	<!-- 댓글 댓글페이징. -->
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item">
				<a class="page-link" href="#" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
</div>


<script>
	//jsp에서 변수 당길수 있으니까 이걸로 출력하려고함
	const bno = "${boardvo.boardNo }"; //글번호 상수
	const logId = "${logId}";
	console.log('현재세션 계정 : ' + logId);

	document
			.querySelector('input[value="수정"]')
			//
			.addEventListener(
					'click',
					function(e) {
						location.href = 'modifyBoard.do?page=${page }&bno=${boardvo.boardNo }&searchCondition=${searchCondition }&keyword=${keyword }';
					});
	document.querySelector('input[value="삭제"]')//
	.addEventListener('click', function(e) {
		location.href = 'deleteBoard.do?bno=${boardvo.boardNo }';
	});
</script>
<!-- 기능을 여기서 구현 -->
<!-- <script src="js/replyService.js"></script> --> 
<!-- 구현한 기능을 재정의해서 활성화 시킴 -->
<!-- <script src="js/reply.js"></script> -->

<script src="js/replyService2.js"></script> <!-- 기능을 여기서 구현 -->
<script src="js/reply2.js"></script><!-- 구현한 기능을 재정의해서 활성화 시킴 -->