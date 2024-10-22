/**
 * json.js
 * 
 */
// JSP방법은 => 페이지 만들어서 출력했음
// json데이터 => 자바스크립트에서 DOM으로 페이지 그림

/* JSON 파일을 읽어와서 처리하기 */
//json 데이터를 자바스크립트 데이터로 바꿔서 이걸 사용할수 있따
/*
fetch('js/MOCK_DATA.json')
.then(rr => {return rr.json()})
.then(ss => {makeList(ss)})
.catch(err => {console.log(err)})
*/

fetch('js/MOCK_DATA.json')	//json data url <- 메인 호출없이 json 데이터 가져와서 값 반환
.then(function(resolve) {	// 서버로부터 응답을 받으면 해당 응답을 처리
	console.log(resolve);
	return resolve.json();	// 응답을 JSON 객체로 변환하여 반환
})	
.then(function(result){		// 변환된 JSON 데이터를 처리
	console.log(result);	// JSON 데이터를 출력
	makeList(result);
})

//You need to create as many tr elements as there are items in the obj array and then insert them into the table.
//A function is created to distinguish and handle this process.
//{"id":1,"first_name":"ab","last_name":"ce","email":"df@ae.com","gender":"q32f","salary":4626}
function makeList(obj = []) {
	let fields = ['id', 'first_name', 'last_name', 'email', 'salary'];
	for(let i=0; i<obj.length; i++){
		let tr = document.createElement('tr');
		tr.addEventListener('mouseover', function(e){
			tr.style.backgroundColor = 'gray';
		});
		tr.addEventListener('mouseout', function(e){
			tr.style.backgroundColor = '';
		});
		for(let j=0; j<fields.length; j++){
			let td = document.createElement('td');
			td.innerText = obj[i][fields[j]];	//obj[0][id], obj[0][first_name], obj[0][lsat_name], obj[0][email]
			tr.appendChild(td);
		}
		let button = document.createElement('button');
		button.innerText = "delete";
		let td = document.createElement('td');
		td.appendChild(button);
		tr.appendChild(td);
		button.addEventListener('click', function(e){
			//버튼속성의부모=><td> // 의 부모=><tr>
			button.parentElement.parentElement.remove();
		});
		document.querySelector('#show tbody').appendChild(tr);
	}
}







/* JSON 변수로 읽어와서 처리하기 */
console.log(data);
//상수데이터를 가져와서 JSON 형태로 변환 (변환하면 배열형태)
let dataarray = JSON.parse(data); 

//해당 배열을 
makeList1(dataarray);

function makeList1 (obj =[]){
	//JSON 배열의 키값 으로 사용
	let fields = ['id', 'first_name', 'last_name', 'email', 'salary'];
	//배열전체를 순서대로 불러온다
	for(let i=0; i<obj.length; i++){
		//배열 불러올때마다 <tr>
		let tr = document.createElement('tr');
		//배열안의 객체를 순서대로 불러온다
		for(let j=0; j<fields.length; j++){
			//객채 불러올때마다 <td>
			let td = document.createElement('td');
			//td에 값을넣는다 <td>아잉</td>
			td.innerText = obj[i][fields[j]];
			//해당값을 tr에 붙인다 <tr><td>아잉</td>
			//필드배열5개니까 5번 반복한다 생각하면
			//<tr><td>아잉</td><td>아잉2</td><td>아잉3</td><td>아잉4</td><td>아잉5</td>
			tr.appendChild(td);
		}
		let button = document.createElement('button'); 
		button.innerHTML = "<i class=\"bi bi-trash\"></i>삭제";
		//button.innerText = "삭제"
		let td = document.createElement('td');
		td.appendChild(button);
		tr.appendChild(td);
		//거기에 마지막으로 버튼도 넣는다 
//<tr><td>아잉</td><td>아잉2</td><td>아잉3</td><td>아잉4</td><td>아잉5</td><td><button></button></td>

		//다만들어진 tr을 해당태그 위치에삽입한다		
		document.querySelector('#show table tbody').appendChild(tr);
	}
}
/* JSON 변수로 읽어와서 처리하기 끝 */