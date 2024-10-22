<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>javascript.</h3>

<table class="table">
	<tr align="center">
		<th>ID: <input id="mid" name="mid" type="text"></th>
		<th>이름: <input id="mname" name="mname" type="text"></th>
		<th>연락처: <input id="mphone" name="mphone" type="text"></th>
		<th><button id="addBtn">등록</button></th>
	</tr>
</table>

<div id="show">
	<!-- 회원목록출력. -->
	<table class="table">
		<thead>
			<tr>
				<th>회원아이디</th><th>회원이름</th><th>연락처</th><th>삭제</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<script src="js/ajax1.js"></script>

