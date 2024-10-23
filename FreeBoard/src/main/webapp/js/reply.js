/**
 * reply.js
 * replyService.js에서 만들었던 메소드를 호출해서 사용
 * 
 * <!-- 댓글관련. -->
<table id="replyList" class="table">
	<thead>
		<tr>
			<th>댓글번호</th><th>내용</th><th>작성자</th><th>날짜</th><th>관리</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
 */

//넘겨줄 페이지 번호
let page = 1;

//댓글 등록 버튼
document.querySelector('#addReply').addEventListener('click', addReplyHandlerFnc);
//댓글 이벤트 핸들러
function addReplyHandlerFnc(e){
	let reply = document.querySelector('#reply').value;
	if(!reply || !logId){
		alert('필수 값이 없습니다');
		return;
	}
	svc.addreply({bno, reply, replyer: logId},
	result => {
		//console.log(result);	//OK: 화면에 한줄 추가 // FAIL: "에러발생"
		//makeLi(result);
		if(result.retCode == 'OK'){
			//let template = makeLi(result.retVal);
			//document.querySelector('.reply ul li').after(template);	//댓글은 최상단에 리스팅 되야해서 이렇게함
			page = 1;
			showList();
			svc.getReplyCount(bno, createPageList, err => console.log(err));
			
		}else if(result.retCode == 'FAIL'){
			alert('등록중 오류 발생');
		}
	},
	err => console.log(err)	//예외 발생했을때 처리할 함수
	)
}



//댓글 리스팅!!
//댓글정보 한건있으면 <li>.....</li> 함수생성.
function makeLi(rvo ={replyNo, reply, replyer}){
	let template = document.querySelector(".reply ul li").cloneNode(true);	//해당요소를 복사하겠따
	//console.log(template);
	template.querySelector('span').innerText = rvo.replyNo;	//첫번째 요소
	template.querySelector('span:nth-of-type(2)').innerText = rvo.reply;	//두번째요소
	template.querySelector('span:nth-of-type(3)').innerText = rvo.replyer;	//세번째요소
	template.querySelector('span:nth-of-type(4)').innerHTML = '<button onclick="deleteRow(event)">삭제</button>';	//네번째요소
	template.addEventListener('mouseover', function(e){
		template.style.backgroundColor = 'gray';
	});
	template.addEventListener('mouseout', function(e){
		template.style.backgroundColor = '';
	});
	
	document.querySelector('.reply ul').appendChild(template);	//수정한 요소를 태그에 삽입
	
	return template;
}



// pagination a 클랙이벤트.
//페이지 클릭했을때 해당페이지 리스팅해주는거
function linkMove(){
	document.querySelectorAll('nav ul.pagination a').forEach(function(aTag){
		aTag.addEventListener('click', function(e){
			e.preventDefault();	// #으로 앵커 태그 차단
			console.log(aTag.innerHTML);
			page = aTag.dataset.page; //<a data-page="2">2</a>
			showList();
			svc.getReplyCount(bno, createPageList, err => console.log(err));
			//createPageList();
		})	
	})
}

//페이지 목록을 출력하는 함수
svc.getReplyCount(bno, createPageList, err => console.log(err));

//createPageList();
function createPageList(result){	//2page
	//console.log(result.totalCount);
	//전체페이지 가져오는거
	let totalCnt = result.totalCount;
	//let totalCnt = 32;	//ex) 32
	let startPage, endPage, realEnd;
	let prev, next;
	//페이지 5개만 있따고 가정 총페이지는 32페이지 이며
	endPage = Math.ceil(page / 5) * 5;	//마지막 페이지 표기	//5page
	startPage = endPage - 4;	//첫번째 페이지 표기			//1page
	realEnd = Math.ceil(totalCnt / 5);					//7page
	endPage = endPage > realEnd ? realEnd : endPage;
	
	prev = startPage > 1;	//앞으로 가기 버튼 활성화 	//false
	next = endPage < realEnd;					//true
	
	//페이징 리스트 출력
	let list = '';
	// [<<]
	list += '<li class="page-item">';
	if(prev){
		list += '<a class="page-link" href="#" aria-label="Previous" data-page="'+(startPage-1)+'">&laquo;</a>';
	}else{
		list += '  <span class="page-link disabled" aria-hidden="true">&laquo;</span>';
	}
	list += '</li>';
	
	// [1] [2] [3] [4] [5]
	for(let p = startPage; p <= endPage; p++){
		list += '<li class="page-item"><a class="page-link" href="#" data-page="'+p+'">'+p+'</a></li>';
	}
	
	// [>>]
	list += '<li class="page-item">';
	if(next){
		list += '<a class="page-link" href="#" aria-label="Next" data-page="'+(endPage+1)+'">&raquo;</a>';
	}else{
		list += '<span class="page-link disabled" aria-hidden="true">&raquo;</span>';
	}
	list += '</li>';
	
	document.querySelector('nav ul.pagination').innerHTML = list;
	linkMove();	//link register
}


//1차적으로 1페이지 댓글 리스팅하는거
showList();

//추가 페이징 기능 호출시 그려줌
function showList(){
	//출력목록을 화면에서 지우고
	document.querySelectorAll('div.reply div.content li').forEach((li, idx) => {
		if(idx>0)
			li.remove();
	})
	//목록출력
	//jsp에서 변수 만든거 씀
	//console.log(bno);
	//새로운 리플 목록화 방법
	svc.rlist({bno, page}	// fetch('replyList.do?bno=361&page=1)
		,function(result){
			//console.log(result);
			//makeList1(result);
			for(let i = 0; i< result.length; i++){
				let template = makeLi(result[i]);
				document.querySelector('.reply ul').appendChild(template);	//수정한 요소를 태그에 삽입
			}
		}
		,function(err){
			console.log('요기',err);
		}
	)
}


//댓글을 삭제하는 함수
function deleteRow(e){
	console.log(e);
	//td의 첫번째 요소의 값
	console.dir(e.target.parentElement.parentElement.firstElementChild.innerText);
	
	let rno = e.target.parentElement.parentElement.firstElementChild.innerText;
	//삭제기능 호출
	svc.removeRely(rno,	//삭제할 댓글번호
		function(result){
			if(result.retCode == 'OK'){
				alert('성공.');
				e.target.parentElement.parentElement.remove();
			}else if(result.retCode == 'FAIL'){
				alert('처리중 에러가 발생.');
			}
		},	//성공일떄 실행할 함수
		err => console.log(err)		//예외 발생했을때 처리할 함수
	)
}










































/*
//원래 이거썼는데 등록도 같이 리스팅하려고 새로만듬 하려고!!!
//배열 분리해서 객체화 하는 함수
function makeList1(obj = []){
	//console.log(obj);
	for(let i=0; i<obj.length; i++){
		//let template = makeRow1(obj[i]);
		makeRow1(obj[i]);
	}
}
//객체를 직접 html에 넣는 함수
function makeRow1(obj = {}){
	let fields = ['replyNo', 'reply', 'replyer'];
	let template = document.querySelector(".reply ul li").cloneNode(true);
	for(let j=0; j<fields.length; j++){
		template.querySelector("span:nth-of-type("+(j+1)+")").innerText = obj[fields[j]];
	}
	template.querySelector('span:nth-of-type(4)').innerHTML = '<button onclick="deleteRow(event)">삭제</button>';	//네번째요소
	
	template.addEventListener('mouseover', function(e){
		template.style.backgroundColor = 'gray';
	});
	template.addEventListener('mouseout', function(e){
		template.style.backgroundColor = '';
	});
	
	document.querySelector('.reply ul').appendChild(template);
	return template;
}
*/


















//현재 도메인의 파라메터를 당겨온다
//const urlParams = new URLSearchParams(window.location.search);
//const bno = urlParams.get('bno');

/*
//어제했는건데 버리면 아까우니까 주석처리했음
//.then(resolve => resolve.json()) 는 객체자체에서 처리됨
svc.rlist(bno	// fetch('replyList.do?bno='+bno)
	,function(result){			//.then(successFnc)
		makeList(result);
	}							//.then(successFnc)
	,function(err){				//.catch(errorFnc)
		console.log('요기',err);
	}
)
// => 간소화하면 이렇게됨
svc.rlist(bno, makeList, err => console.log('요기', err));
*/

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
	let fields = ['replyNo', 'reply', 'replyer', 'replyDate'];
	let tr = document.createElement('tr');
	//멤버아이디를 tr요소에 넣어놨음 이려면 dataset.id 로 읽어올수있음 data-name => dataset.name 로 읽을수 있음
	tr.setAttribute('data-rno', obj.replyNo);
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
	console.dir(e.target.parentElement.parentElement.dataset.rno);
	
	let rno = e.target.parentElement.parentElement.dataset.rno;
	fetch('removeReplyJson.do?bno='+rno)
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
