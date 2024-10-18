<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>상세페이지(board.jsp)</h3>
<%
	BoardVO bvo = (BoardVO) request.getAttribute("boardvo");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	String wdate = sdf.format(bvo.getWriteDate());
	String pg = (String) request.getAttribute("page");
	//검색 데이터 받아오기
	String sc = (String) request.getAttribute("searchCondition");
	String kw = (String) request.getAttribute("keyword");
	kw = kw == null ? "" : kw;
%>
<form action="modifyBoard.do" method="get">
	<input type="hidden" value="<%=bvo.getBoardNo() %>" id="bno" name="bno">
	<input type="hidden" value="<%=sc %>" id="searchCondition" name="searchCondition">
	<input type="hidden" value="<%=kw %>" id="keyword" name="keyword">
	<table class="table">
		<tr>
			<th>글번호</th><td><%=bvo.getBoardNo() %></td>
			<th>조회수</th><td><%=bvo.getViewCnt() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><%=bvo.getTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea readonly rows="4" cols="30" class="form-control"><%=bvo.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><%=bvo.getWriter() %></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan="3"><%=wdate %></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="button" class="btn btn-warning" value="수정">
				<input type="button" class="btn btn-danger" value="삭제">
			</td>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>
	document.querySelector('input[value="수정"]')//
	.addEventListener('click', function(e) {
		location.href = 'modifyBoard.do?page=<%=pg %>&bno=<%=bvo.getBoardNo() %>&searchCondition=<%=sc %>&keyword=<%=kw %>';
	});
	document.querySelector('input[value="삭제"]')//
	.addEventListener('click', function(e) {
		location.href = 'deleteBoard.do?bno=<%=bvo.getBoardNo() %>';
	});
</script>