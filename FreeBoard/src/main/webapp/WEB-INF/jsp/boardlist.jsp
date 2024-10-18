<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글목록(boardList.jsp)</h3>
<%
	//게시글 객체
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
	//날짜 포멧
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	//페이징 정보
	PageDTO paging = (PageDTO) request.getAttribute("page");
	//검색 데이터 받아오기
	String sc = (String) request.getAttribute("searchCondition");
	String kw = (String) request.getAttribute("keyword");
%>
<!-- 검색조건 넣기 -->
<form action="boardlist.do" class="row g-3">
  <div class="col-md-3">
    <select name="searchCondition" class="form-select">
      <option selected value="">선택하세요.</option>
      <option value="T">제목</option>
      <option value="W">작성자</option>
      <option value="TW">제목 & 작성자</option>
    </select>
  </div>
  <div class="col-md-4">
    <input type="text" class="form-control" name="keyword">
  </div>
  <div class="col-md-5">
    <button type="submit" class="btn btn-primary">조 회</button>
  </div>
</form>
<!-- 테이블 -->
<table class="table table-bordered table-hover">
	<thead>
		<tr>
			<th>글번호</th><th>글제목</th><th>작성자</th><th>작성일자</th><th>조회수</th>
		</tr>
	</thead>
	<tbody>
	<% for (BoardVO board : list) { 
		//date포켓(2024-10-09 1211:11) 형식으로 바꿔줌
		String wdate = sdf.format(board.getWriteDate());
	%>
		<tr>
			<td><%=board.getBoardNo() %></td>
			<td><a href='board.do?page=<%=paging.getPage() %>&bno=<%=board.getBoardNo() %>'><%=board.getTitle() %></a></td>
			<td><%=board.getWriter() %></td>
			<td><%=wdate %></td>
			<td><%=board.getViewCnt() %></td>
		</tr>
	<% } %>
	</tbody>
</table>
<% //=paging %>
<!-- paging -->
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
<% if(paging.isPrev()){ %>
    <li class="page-item">
      <a class="page-link" href="?page=<%=(paging.getStartPage()-1) %>&searchCondition=<%=sc %>&keyword=<%=kw %>">Previous</a>
    </li>
<% }else{ %>
	<li class="page-item disabled">
      <a class="page-link">Previous</a>
    </li>
<% } %>
<% for(int p=paging.getStartPage(); p <= paging.getEndPage(); p++) { %>
   	<li <% if(p==paging.getPage()){ %> 
   			class="page-item active" aria-current="page"
   		<% }else{ %>
   			class="page-item"
   		<% } %> ><a class="page-link" href="?page=<%=p %>&searchCondition=<%=sc %>&keyword=<%=kw %>"><%=p %></a></li>
<% } %>
<% if(paging.isNext()){ %>
    <li class="page-item">
      <a class="page-link" href="?page=<%=(paging.getEndPage()+1) %>&searchCondition=<%=sc %>&keyword=<%=kw %>">Next</a>
    </li>
<% }else{ %>
	<li class="page-item disabled">
      <a class="page-link" href="#">Next</a>
    </li>
<% } %>
  </ul>
</nav>
<jsp:include page="../includes/footer.jsp"></jsp:include>