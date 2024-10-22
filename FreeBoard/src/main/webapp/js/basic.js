/**
 * basic.js
 * <ul>
		<li>Apple</li>
		<li>Bnana</li>
		<!-- <li>Cherry</li> -->
	</ul>
	<table border="1">
		<tbody>
			<tr>
				<th>이름</th><td>박길동</td>
			</tr>
			<!-- <tr>
				<th>이름</th><td>홍길동</td>
			</tr> -->
		</tbody>
	</table>
	<table border="2">
		<thead>
			<tr>
				<th>이름</th><th>나이</th>
			</tr>
		</thead>
		<tbody>
			<!-- <tr>
				<td></td><td></td>
			</tr> -->
		</tbody>
	</table>
	https://blog.naver.com/pyoungj1003/223628391258
 */
console.log("basic.js")

let name = "홍길동";	//string
let age = 20;	//number
let obj = {name: "홍길동"
			,age: 20
			,showInfo: function(){
				return this.name + " - " + this.age;
			}}
			
console.log(obj);

console.log(obj.name);
console.log(obj['age']);
console.log(obj.showInfo());


//기존 객체를 data에 넣음
let data = [obj];

//아래 객체를 추가적으로 넣음
data.push({name: "박민수", age: 22})
data.push({name: "송민혁", age: 25})
for(let i=0; i<data.length; i++){
	console.log(data[i].age +" "+ data[i].name);
}

//mytest();
function mytest(){
	for(let i=0; i<data.length; i++){
		let tr = document.createElement('tr'); //tr태그생성
		let td = document.createElement('td'); //td태그생성
		td.innerText = data[i].name;	//처음 td에 이름 넣고
		tr.appendChild(td);	//td를 tr에 업음
		td = document.createElement('td'); //초기화되면서 새로운 td태그생성
		td.innerText = data[i].age;	//다음 td에 나이 넣고
		tr.appendChild(td);	//두번째 td도 마찬가지로 tr에 업음
		
		//이제 이걸 어디에 출력하느냐 ??
		document.querySelector('#show table:nth-of-type(2) tbody').appendChild(tr);
	}
}

makeList();
//DOM data배열에 있는 정보를 출력.
function makeList(){
	//document.querySelector('#show table:nth-of-type(2)').className = 'table';
	let table = document.querySelector('#show table:nth-of-type(2)');
	table.className = 'table';
	table.style.border = '2px solid black';
	
	
	for(let i=0; i<data.length; i++){
		//tr생성.
		let tr = document.createElement('tr');
		//td생성.
		let td = document.createElement('td');
		td.innerHTML = data[i].name;
		tr.appendChild(td);
		td = document.createElement('td');
		td.innerHTML = data[i].age;
		tr.appendChild(td);
		
		document.querySelector('#show table:nth-of-type(2) tbody').appendChild(tr);
	}
}

//DOM
// <li></li>
let li = document.createElement("li");
li.innerText = 'Cherry';
let ul = document.querySelector('#show ul');	//css의 선택자
ul.appendChild(li);


li = document.createElement("li");	//li 태그를 생성
li.innerText = 'Tomato';	//해당 태그 안에 토마토 글자 집어넣음
ul = document.querySelector('#show ul'); //show id 안에있는 ul을 선택
ul.append(li);	//방금 만든 토마토 집어넣음


// show 안에 있는 ul 안에있는 li 들을 for문돌면서 
document.querySelectorAll('#show ul li')	//li 요소들을 선택	
	.forEach(function(fruit){				//li 요소전부를 반복
		fruit.style.color='red';			//각 요소 색상 변경
		fruit.addEventListener('click', function(e){	//해당요소 클릭 이벤트
			fruit.remove();				//클릭되면 해당 요소 삭제
		});
		console.log(fruit.innerHTML);	//for문돌면서 순서대로 각요소 콘솔에 찍음
	});

	

//tr>th+td를 생성 appendchild()실행
let tr = document.createElement("tr");


let td = document.createElement("th");
td.innerText = '이름';
tr.appendChild(td);

td = document.createElement("td");
td.innerText = name;
tr.appendChild(td);

document.querySelector('#show table tbody').appendChild(tr);