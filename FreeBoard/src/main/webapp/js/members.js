/**
 * members.js
 */

//jsp는 타일즈로 레이아웃 호출하는건데
//json은 직접그려서 그린걸 자바스크립트에서 그려버리는거

// json형태의 회원목록을 출력하는 데이터를 만들기
//프론트컨트롤.java에 만들꺼임
fetch('memberJson.do')
	.then(function(resolve){
		return resolve.json();	//해당폴더에 문자열을 json형태로 가져오는거
		//return resolve.text(); //이렇게하면 문자열 형태로 값을가져옴
		//그냥 가져오기만 하는거라서 이걸 출력하는 then이 따로 하나 더 존재해야함
	})
	.then(function(result){
		console.log(result);
		makeList(result);
	})
	.catch( err => {console.log(err)})	//이런식으로 한줄 함푸 처리도 할수있다
	//코드 간소화되고 용량줄어들고 좋은데 난 이게 한눈에 잘안들어온다 ㅠ
		
	
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
			let tr = makeRow({memberId: id, memberName: name, phone: phone});
			document.querySelector('#show tbody').appendChild(tr);
		}else if(result.retCode == 'FAIL'){
			alert('처리중 에러가 발생.');
		}
	})
	.catch(err => {console.log(err)})
});


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
	button.addEventListener('click', deleteRowFnc );
	return tr;
}

//이벤트 핸들러는 무조건 이벤트를 전달해야함
function deleteRowFnc(e){
	//td의 첫번째 요소의 값
	console.dir(e.target.parentElement.parentElement.firstElementChild.innerText);
	
	//data-id 로 선언한값
	console.dir(e.target.parentElement.parentElement.dataset.id);
	
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
	//e.target.parentElement.parentElement.remove();
}


