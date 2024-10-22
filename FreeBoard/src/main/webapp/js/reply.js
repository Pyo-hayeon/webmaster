/**
 * reply.js
 * replyService.js에서 만들었던 메소드들 활용
 */
//svc.showMsg('hello');	//이렇게하면 콘솔 리플라이서비스에 값이 달되어 출력됨
svc.rlist(361	//bno parm
	,function(result){
		console.log(result);
		//목록출력하면됨
		makeList(result);
	}//successFnc)
	,function(err){
		console.log('요기',err);
	}//errorFnc
)

//배열받아서 [] 전체 목록 만들어줌
function makeList(obj = []){
	for(let i=0; i<obj.length; i++){
		let tr = makeRow(obj[i]);	//배열에 값을 풀어서 객체 하나를 던지는거
		// {memberId: "user01", memberName:"adfsdf", phone:"phone"}
		document.querySelector('#replyList tbody').appendChild(tr);
	}
}

//객체받아서 {}
function makeRow(obj = {}){
	let fields = ['replyNo', 'reply', 'replyer'];
	let tr = document.createElement('tr');
	//멤버아이디를 tr요소에 넣어놨음 이려면 dataset.id 로 읽어올수있음 data-name => dataset.name 로 읽을수 있음
	tr.setAttribute('data-bno', obj.replyNo);
	tr.addEventListener('mouseover', function(e){
		tr.style.backgroundColor = 'gray';
	});
	tr.addEventListener('mouseout', function(e){
		tr.style.backgroundColor = '';
	});
	for(let j=0; j<fields.length; j++){
		let td = document.createElement('td');
		td.innerText = obj[fields[j]];	//obj[0][id], obj[0][first_name], obj[0][lsat_name], obj[0][email]
		tr.appendChild(td);
	}
	let button = document.createElement('button');
	button.innerText = "delete";
	let td = document.createElement('td');
	td.appendChild(button);
	tr.appendChild(td);
	button.addEventListener('click', deleteRowFnc );
	return tr;
}

//이벤트 핸들러는 무조건 이벤트를 전달해야함
function deleteRowFnc(e){
	//td의 첫번째 요소의 값
	console.dir(e.target.parentElement.parentElement.firstElementChild.innerText);
	
	//data-id 로 선언한값
	console.dir(e.target.parentElement.parentElement.dataset.bno);
	
	let bno = e.target.parentElement.parentElement.dataset.bno;
	fetch('removeReplyJson.do?bno='+bno)
	.then(resolve => resolve.json())
	.then(result => {
		if(result.retCode == 'OK'){
			alert('성공.');
			e.target.parentElement.parentElement.remove();
			
		}else if(result.retCode == 'FAIL'){
			alert('처리중 에러가 발생.');
		}
	})
	.catch(err=>console.log(err))
	//e.target.parentElement.parentElement.remove();
}
