<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
	String msg = (String) request.getAttribute("msg");
%>
<% if(msg != null) { %>
<p style="color: red;"><%=msg %></p>
<% } %>
<h3>로그인(loginForm.jsp)</h3>
<form action="loginForm.do" method="post">
	<table class="table">
		<tr>
			<th>아이디</th><td><input type="text" name="LogId" id="LogId" class="form-control"></td>
		</tr>
		<tr>
			<th>비밀번호</th><td><input type="password" name="LogPw" id="LogPw" class="form-control"></td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<button class="btn btn-primary" type="submit">로그인</button>
			</td>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>