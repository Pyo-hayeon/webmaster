<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
</head>
<body>
	<div id='calendar'></div>
</body>
</html>
<script src='dist/index.global.js'></script>
<script>
var formattedDate;
today();
function today(){
	var today = new Date();
	var year = today.getFullYear();
	var month = ('0' + (today.getMonth() + 1)).slice(-2);
	var day = ('0' + today.getDate()).slice(-2);
	formattedDate = year + '-' + month + '-' + day;
}

let calendar;
											//async 이게 들어감
document.addEventListener('DOMContentLoaded', async function() {
	var calendarEl = document.getElementById('calendar');
	
	// new promise(function(){}, function(){})//성공, 실패 함수를 받음
	// 프라미스객체가 반환될 때 await 수행코드. -> 그 다음 코드 실행.
	// 비동기 끝나고 실행되도록 await를 이용해서 동기방식으로 처리되게 함 (어씽크 어웨이 함수 안에서 사용함)
	var eventData = [];
	let resolve = await fetch('countBySelectable.do')//fetch('countBySelectable.do')
	let result = await resolve.json();				//.then(resolve => resolve.json())
	eventData = result;       						 //.then(result => {
													//	eventData = result;
													//	})
													//.catch(err => console.log(err));
	
	var calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar : {
			left : 'prev,next today',
			center : 'title',
			right : 'dayGridMonth,timeGridWeek,timeGridDay'
		},
		initialDate : formattedDate,//'2024-10-24',
		navLinks : true,
		selectable : true,
		selectMirror : true,
		select : function(arg) {
			var title = prompt('Event Title:');
			if (title) {
				var start = arg.startStr;
				start = start.split('+')[0];
				//console.log(start);
				
				var end = arg.endStr;
				end = end.split('+')[0];
				//console.log(end);
				
				fetch('insertSelectable.do?title='+title+'&start='+start+'&end='+end)
				.then(resolve=>{return resolve.json()})
				.then(result=>{console.log(result)})
				.catch(err=>{console.log(err)})
				
				calendar.addEvent({
					title : title,
					start : arg.start,
					end : arg.end,
					allDay : arg.allDay
				})
			}
			calendar.unselect()
		},
		eventClick : function(arg) {
			if (confirm('스케쥴을 지우시겠습니까?')) {
				arg.event.remove();
				
				var title = arg.event._def.title;
				//console.log(title);
				
				var start = arg.event.startStr;
				start = start.split('+')[0];
				//console.log(start);
				
				var end = arg.event.endStr;
				end = end.split('+')[0];
				//console.log(end);
				
				fetch('delSelectable.do?title='+title+'&start='+start)//+'&end='+end
				.then(resolve=>{return resolve.json()})
				.then(result=>{console.log(result)})
				.catch(err=>{console.log(err)})
			}
		},
		editable : true,
		dayMaxEvents : true, // allow "more" link when too many events
		events : eventData
		});

		calendar.render();
	});

</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>