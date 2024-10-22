/**
 * ajax1.js
 * Asynchronous Javascript And Xml
 * 동기방식은 코드 순차적으로 처리되는거
 * 비동식방식은 요청에따라 요청이 끝난거먼저 순차적으로 처리 
 * //대표적인 비동기방식 함수
setTimeout(function(){
	console.log("1");	
},1000);
setTimeout(function(){
	console.log("2");	
},2000);
setTimeout(function(){
	console.log("3");	
},1500);
console.log("2");
console.log("3");

//동기방식 구조
setTimeout(function(){
	console.log("1");
	setTimeout(function(){
		console.log("2");	
		setTimeout(function(){
			console.log("3");	
		},1500);
	},1500);
},1500);
 */

//대표적인 비동기방식 객체
let xhtp = new XMLHttpRequest();		//이렇게 처리되는 방식을 (ajax)라고함
//서버상의 어떠한 호출을 할떄 사용하는 메소드 open
xhtp.open('get', 'memberJson.do'); //<==json 데이터 반환해주는 객체
xhtp.send();	//서버상에 리소스를 가져오는 작업을 시작함 이게 필요함!!
let data = [];	//배열 선언
//다 가져오면 이벤트가 실행된다
xhtp.onload = function(){
	let obj = JSON.parse(xhtp.responseText);	//텍스트 형태인데 // 자바스크립트의 객체타입으로 변환해준다
	//console.log(obj);
	data = obj;
	console.log('1',data);
	for(let i=0; i<data.length; i++){
		console.log(data[i]);	//여기에 넣어야 값이나옴
	}
}
//이게 먼저 출력됨 (비동기방식이라서)
console.log('2',data);

for(let i=0; i<data.length; i++){
	console.log(data[i]);	//순서때문에 데이터가 없어서 값이 안나옴
}