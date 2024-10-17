<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>삭제 화면(deleteForm.jsp)</h3>
<!-- http://localhost/FreeBoard/modifyBoard.do?bno=1 -->
<%
	String msg = (String) request.getAttribute("msg");
	BoardVO board = (BoardVO) request.getAttribute("boardvo");
%>
<% if(msg != null) { %>
<p style="color: red;"><%=msg %></p>
<% } %>

<form action="deleteBoard.do" method="post">
	<input type="hidden" value="<%=board.getBoardNo() %>" id="bno" name="bno">
	<table class="table">
		<tr>
			<th>글번호</th><td><%=board.getBoardNo() %></td>
			<th>조회수</th><td><%=board.getViewCnt() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><%=board.getTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea readonly rows="3" cols="30" name="content" id="content" class="form-control"><%=board.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><%=board.getWriter() %></td>
		</tr>
		<tr>
			<td colspan="4" align="center" >
				<input type="submit" class="btn btn-danger" value="삭제">
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