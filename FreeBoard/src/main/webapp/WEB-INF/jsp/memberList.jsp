<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  <!-- 날짜 포멧 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<h3>회원목록</h3>
<table class="table">
	<c:forEach var="member" items="${memberList }">
		<tr>
			<td>${member.memberId }</td>
			<td>${member.memberName }</td>
			<td>${member.phone }</td>
		</tr>
	</c:forEach>
</table>