/**
 * json.js
 * {name: "홍길동". age: 20}  <== javascript object
 * {"name": "홍길동", "age": 20} <== json object
 * json String => javascript object => json String
 * 
 * <table class="table">
		<thear>
			<tr>
				<th>ID</th><th>firstName</th><th>lastName</th><th>Email</th><th>Salary</th><th>delete</th>
			</tr>
		</thear>
		<tbody>
		</tbody>
	</table>
 */


//json 데이터를 자바스크립트 데이터로 바꿔서 이걸 사용할수 있따
fetch('js/MOCK_DATA.json')	//json data url <- 메인 호출없이 json 데이터 가져와서 값 반환
.then(function(resolve) {	// 서버로부터 응답을 받으면 해당 응답을 처리
	console.log(resolve);
	return resolve.json();	// 응답을 JSON 객체로 변환하여 반환
})	
.then(function(result){		// 변환된 JSON 데이터를 처리
	console.log(result);	// JSON 데이터를 출력
	makeList(result);
})


// JSP방법은 => 페이지 만들어서 출력했음
// json데이터 => 자바스크립트에서 DOM으로 페이지 그림



/*

let obj = {name: "홍길동", age: 20};
let json = JSON.stringify(obj);	//javascript object => json String
obj = JSON.parse(json);	//json String => javascript object

console.log(obj); //<=javascript object
console.log(json); //<=json String

obj = JSON.parse(data); //<==data = json.js variable
console.log(obj);

*/
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
			button.parentElement.parentElement.remove();
			//tr.remove(); //이게 더 좋은거 같은데 지금 생성하고있는 tr 호출하는거라서
		});
		document.querySelector('#show tbody').appendChild(tr);
	}
}
//makeList();