<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script>
	document.addEventListener('DOMContentLoaded', function(e) {
		getInputDayLabel('11');
		console.log(one_day);
		createCalender(document.querySelector('#list'));
	})

	let one_day;

	function createCalender(target) {
		let last_day = (31 + Number(one_day));
		//console.log(last_day);
		let tr = document.createElement('tr');
		for (let d = 1; d <= last_day; d++) {
			let td = document.createElement('td');
			if (d <= Number(one_day)) {
				td.innerHTML = '';
			} else {
				td.innerHTML = d - Number(one_day);
			}
			if(d % 7 == 0){
				td.style.color = 'blue';
			}
			tr.appendChild(td);
			if (d % 7 == 0) {
				document.querySelector('#list').appendChild(tr);
				tr = document.createElement('tr'); // 토요일(7번 td를 생성하면)이 되면 tr을 새롭게 생성.
			}
		}
		target.appendChild(tr);
	}
</script>
</head>

<body>

	<div id="show">
		<table border="1">
			<thead>
				<tr>
					<th>Sun</th>
					<th>Mon</th>
					<th>Tue</th>
					<th>Wed</th>
					<th>Thr</th>
					<th>Fri</th>
					<th>Sat</th>
				</tr>
			</thead>
			<tbody id="list"></tbody>
		</table>

	</div>

</body>

</html>

<script src="js/exe.js"></script>