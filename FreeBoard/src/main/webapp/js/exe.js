
let targetSpan = document.querySelectorAll('.container span');

/*
for(let i=0; targetSpan.length; i++){
	console.log(targetSpan[i].innerHTML);
}
*/

function clicklist(){
	let userValue = document.querySelector('#userValue').value;
	targetSpan.forEach(span => {
		if(span.textContent == userValue){
			span.remove();
			document.querySelector('#userValue').value='';
		}
	});
}


function getInputDayLabel(moth) {
	//var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'); 
	var week = new Array('0', '1', '2', '3', '4', '5', '6'); 
	var today = new Date('2024-'+moth+'-01').getDay();    
	var todayLabel = week[today];
	one_day = todayLabel;
	return one_day;
}
//console.log(one_day);