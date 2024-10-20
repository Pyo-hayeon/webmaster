<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  <!-- 날짜 포멧 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<c:if test="msg != null)">
	<p style="color: red;">${msg }</p>
</c:if>
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