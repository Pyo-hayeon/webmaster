<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>수정 화면(modifyForm.jsp)</h3>
<!-- http://localhost/FreeBoard/modifyBoard.do?bno=1 -->
<%
	String msg = (String) request.getAttribute("msg");
	BoardVO board = (BoardVO) request.getAttribute("boardvo");
	String pg = (String) request.getAttribute("page");
	//검색 데이터 받아오기
	String sc = (String) request.getAttribute("searchCondition");
	String kw = (String) request.getAttribute("keyword");
	kw = kw == null ? "" : kw;
	//세션추가
	String logId = (String) session.getAttribute("logId");
%>
<% if(msg != null) { %>
<p style="color: red;"><%=msg %></p>
<% } %>

<form action="modifyBoard.do" method="post">
	<input type="hidden" value="<%=board.getBoardNo() %>" id="bno" name="bno">
	<input type="hidden" value="<%=pg %>" id="page" name="page">
	<input type="hidden" value="<%=sc %>" id="searchCondition" name="searchCondition">
	<input type="hidden" value="<%=kw %>" id="keyword" name="keyword">
	<table class="table">
		<tr>
			<th>글번호</th><td><%=board.getBoardNo() %></td>
			<th>조회수</th><td><%=board.getViewCnt() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="title" id="title" class="form-control" value="<%=board.getTitle() %>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea rows="3" cols="30" name="content" id="content" class="form-control"><%=board.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><%=board.getWriter() %></td>
		</tr>
		<tr>
			<td colspan="4" align="center" >
				<input type="submit" class="btn btn-success" <%=( logId != null && logId.equals(board.getWriter()) ) ? "" : "disabled" %> value="저장">
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