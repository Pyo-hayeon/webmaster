/**
 * members.js
 */
/*
// [{"memberId": "user01", "memberName":"사용자1", "phone":"123-123-123"},
//  {"memberId": "user01", "memberName":"사용자1", "phone":"123-123-123"},
//  {"memberId": "user01", "memberName":"사용자1", "phone":"123-123-123"}]
//	memberJson.do
*/

fetch('memberJson.do')
.then(rr=>{return rr.json()})
.then(ss=>{makeList(ss)})
.catch(er=>{console.log(er)})
//return rr.text(); //이렇게하면 문자열 형태로 값을가져옴
	
	


//배열받아서 [] 전체 목록 만들어줌
function makeList(obj = []){
	for(let i=0; i<obj.length; i++){
		let tr = makeRow(obj[i]);	//배열에 값을 풀어서 객체 하나를 던지는거
		// {memberId: "user01", memberName:"adfsdf", phone:"phone"}
		document.querySelector('#show tbody').appendChild(tr);
	}
}

//객체받아서 {}
function makeRow(obj = {}){
	let fields = ['memberId', 'memberName', 'phone'];
	let tr = document.createElement('tr');
	//멤버아이디를 tr요소에 넣어놨음 이려면 dataset.id 로 읽어올수있음 data-name => dataset.name 로 읽을수 있음
	tr.setAttribute('data-id', obj.memberId);
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
	//삭제버튼 클릭시 deleteRowFnc 함수 실행
	button.addEventListener('click', deleteRowFnc);
	return tr;
}

//★이벤트 핸들러는 무조건 이벤트를 전달해야함
function deleteRowFnc(e){
	//td의 첫번째 요소의 값
	console.dir(e.target.parentElement.parentElement.firstElementChild.innerText);
	//data-id 로 선언한값
	console.dir(e.target.parentElement.parentElement.dataset.id);
	//위에 2개다 같음 //data-id로 tr에다가 값을 박아서 쓸수있는거임
	let id = e.target.parentElement.parentElement.dataset.id;
	fetch('removeMemberJson.do?id='+id)
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
}



// 등록 버튼에 대한 이벤트
// 회원 가입 되고 DB에 데이터 들어가고 화면에 리스팅 다시 되도록 처리
document.querySelector('#addBtn').addEventListener('click', function(e){
	let id = document.querySelector('#mid').value;
	let name = document.querySelector('#mname').value;
	let phone = document.querySelector('#mphone').value;
	
	//값을 보낼때도 fetch로 내용 다 보낼수 있음
	//resolve => {} 평션없이 이렇게도 가능함
	fetch('addMemberJson.do?id='+id+'&name='+name+'&phone='+phone)
	.then(resolve => {return resolve.json()})
	.then(result => {
		console.log(result);	//콘솔 출력하는거
		//{"retCode":"OK"} //{"retCode":"FAIL"} 두개에 따라서 처리 방법
		if(result.retCode == 'OK'){
			//목록만드는 makeList가 아니라 makeRow로 행 추가하는거임
			//목록만들땐 배열을 던지고 obj = []
			//행만들땐 객체를 던짐!!  obj = {}
			let tr = makeRow({memberId: id, memberName: name, phone: phone});
			document.querySelector('#show tbody').appendChild(tr);
		}else if(result.retCode == 'FAIL'){
			alert('처리중 에러가 발생.');
		}
	})
	.catch(err => {console.log(err)})
});

