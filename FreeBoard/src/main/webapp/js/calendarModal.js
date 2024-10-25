/**
 * calendarModal.js
 */
let body = document.querySelector('body');
let modal = document.querySelector('#exampleModal');
let div = document.createElement('div');
let buttonClose = document.querySelector('.btn-close');
let buttonSecondary = document.querySelector('.btn-secondary');

let modalContent = document.querySelector('.modal-content');
modalContent.addEventListener('click', function(event) {
    event.stopPropagation();	//기본 설정 이벤트 중지
});

[modal, buttonClose, buttonSecondary].forEach(button => {
    button.addEventListener('click', closeModal);
});

function closeModal() {
    body.className = "";
    body.style.overflow = '';
    body.style.paddingRight = '';
    modal.className = "modal";
    modal.classList.add('fade');
    modal.removeAttribute('aria-modal');
    modal.removeAttribute('role');
    modal.setAttribute('aria-hidden', true);
    modal.style.display = 'none';
    div.remove();
}


function modalShow(arg){
	modalArg = arg;	//여러 함수에서 사용할 용도.
	
	body.className = "modal-open";
	body.style.overflow = 'hidden';
	body.style.paddingRight = '16px';
	
	//클래스 추가할떈 LIST
	modal.classList.add('show');
	modal.setAttribute('role','dialog');
	modal.setAttribute('aria-modal',true);
	modal.removeAttribute('aria-hidden');
	modal.style.display = 'block';
	
	div.className= "modal-backdrop"; 
	div.classList.add('fade');
	div.classList.add('show');
	
	body.appendChild(div);

	let title1 = document.querySelector('#title').value;
	if(title1){
		title.value = '';
	}
	//console.log(modalArg);
	

	if(modalArg.startStr.indexOf('+') != -1){
		starting = modalArg.startStr.split('+')[0];
		temp1 = starting.split('T')[0];
		temp2 = starting.split('T')[1];
		start1 = temp1+'T'+temp2;
		start2 = temp1;
		start3 = temp2;
	
		ending = modalArg.endStr.split('+')[0];
		temp1 = ending.split('T')[0];
		temp2 = ending.split('T')[1];
		end1 = temp1+'T'+temp2;
		end2 = temp1;
		end3 = temp2;
		
	}else{
		start2 = modalArg.startStr;
		start1 = modalArg.startStr;
		end2 = modalArg.endStr;
		end1 = modalArg.endStr;
	}
	//console.log(start1+' '+end1);

	start.value = start2;
	end.value = end2;
	
	//start.value = modalArg.startStr;
	//end.value = modalArg.endStr;
}

var start1, start3;
var end1, end3;


function modalSave(){
	let title = document.querySelector('#title').value;
	let start = document.querySelector('#start').value;
	let end = document.querySelector('#end').value;
	
	/*
	if(end3){
		start1 = start1+"T"+start3;
		end1 = end1+"T"+end3;
	}else{
		start1 = start;
		end1 = end;
	}
	*/

	console.log(start1);
	
	fetch('insertSelectable.do?title='+title+'&start='+start1+'&end='+end1)
	.then(resolve=>{return resolve.json()})
	.then(result=>{
		//console.log(result);
		if(result.retCode == 'OK') {
			calendar.addEvent({
				title : title,
				start : start1,
				end : end1,
				allDay : modalArg.allDay
			})
			calendar.unselect();
			calendar.render();
			closeModal();
		}else if(result.retCode == 'FAIL') {
			alert('등록 실패!!');
			closeModal();
		}
	})
	.catch(err=>{console.log(err)})

}

function startChange(event){
	//console.log(start3);
	if(start3){
		start1 = event.target.value+"T"+start3;
	}else{
		start1 = event.target.value;
	}
	//modalArg.start = new Data(event.target.value);
}
function endChange(event){
	if(end3){
		end1 = event.target.value+"T"+end3;
	}else{
		end1 = event.target.value;
	}
	//modalArg.end = new Data(event.target.value);
}