/**
 * 서비스사용
 */
let page = 1; //최초 페이지는 1페이지가 되게 초기화


//★1 댓글 목록 호출
showList();
function showList(){
	//목록 전부삭제
	document.querySelectorAll('div.reply div.content li').forEach((li, idx) => {
		if(idx>0){
			li.remove();			
		}
	})
	//목록 다시 그려줌
	svc2.rlist({ bno, page }
		, function(result) {
			for (let i = 0; i < result.length; i++) {
				let template = makeLi(result[i]);
			}
		}
		, function(err) {
			console.log('댓글리스팅', err);
		}
	)
}


//★1-1 댓글 목록 DOM
//function makeLi(obj = {}){
function makeLi(rvo = {replyNo, reply, replyer}) {
	let template = document.querySelector('.reply ul li').cloneNode(true);
	template.querySelector('span').innerText = rvo.replyNo;
	template.querySelector('span:nth-of-type(2)').innerText = rvo.reply;
	template.querySelector('span:nth-of-type(3)').innerText = rvo.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = '<button onclick="deleteRow(event)">삭제</button>';
	
	document.querySelector('.reply ul').appendChild(template);
	//return template;
}


//★2 댓글 삭제 호출
function deleteRow(e){
	let rno = e.target.parentElement.parentElement.firstElementChild.innerText;
	//, removeRely(rno=1, successFnc, errorFnc){
	svc2.removeRely(rno
	, function(result){
		console.log(result);
		if(result.retCode == 'OK'){
			alert('삭제 완료');
			e.target.parentElement.parentElement.remove();
			showList();
			svc2.getReplyCount(bno, createPageList, err => {console.log('카운팅 하는곳4',err)});
		}else if(result.retCode == 'FAIL'){
			alert('삭제하는중 에러 발생');
		}
	}
	, function(err){
		console.log('삭제하는곳', err);
	})
}


//★3 댓글 추가 호출
document.querySelector('#addReply').addEventListener('click', addReplyHandlerFnc);	
function addReplyHandlerFnc(e){
	let reply = document.querySelector('#reply').value;
	if(!reply || !logId){
		alert('필수 값이 없습니다');
		return;
	}
	svc2.addreply({bno,reply,replyer: logId}
	, function(result){
		if(result.retCode == 'OK'){
			alert('추가 완료');
			page = 1;
			showList();
			svc2.getReplyCount(bno, createPageList, err => {console.log('카운팅 하는곳3',err)});
		}else if(result.retCode == 'FAIL'){
			alert('추가하는중 에러 발생');
		}
	}
	, function(err){
		console.log('추가하는곳', err);
	})
}		


//★4 댓글 페이징 기능 활성화 ( 댓글 총 갯수 가져옴 )
//성공 결과를 createPageList 함수를 따로 뺐음!!
//최초 1회는 자동실행
//액션(삭제,등록,페이지이동)이 생기면 해당 액션에서 호출해야함
svc2.getReplyCount(bno, createPageList, err => {console.log('카운팅 하는곳1',err)});


//★4-1 페이징 카운팅 및 페이징버튼 그리기
function createPageList(result){
	//{"totalCount":11}
	let totalCnt = result.totalCount;
	let startPage, endPage, realEnd;
	let prev, next;
	
	// 2페이지면 1~5페이지 범위를 표출해줘야함
	// 8페이지면 6~10페이지 범위 표출
	
	// 2페이지 => 0.4 를 올림해서 1이 되고 *5 를해서 5페이지가 끝페이지
	endPage = Math.ceil(page / 5) * 5;
	// 2페이지 => 끝페이지가 5페이지 이고 시작페이지가 1페이지가 됨
	startPage = endPage - 4;
	//전체 댓글 페이지 갯수를 가져옴 154개 글있으면 30.8페이지 이고 올려서 31페이지 까지 있어야함
	realEnd = Math.ceil(totalCnt / 5);
	
	//realEnd가 31페이지이고 // page가 31페이지이면 // endPage는 35페이지임 
	//문젠 32 33 34 35는 텅비어있음
	//그래서 뒤에 텅빈페이지이면 페이지 갯수를 실제 페이지 수로 바꾼다는거임
	endPage = endPage > realEnd ? realEnd : endPage;
	
	//결국 5페이지씩 리스팅이니까 1 6 11 16 21 인데 1만아니면 앞으로가기 만들면됨
	prev = startPage > 1;
	//다음페이지는 위에 말했던것처럼 리얼 31 // 끝 35 인경우에 막으면됨
	next = endPage < realEnd;
	
	//위의 내용을 토대로 페이지 버튼 그리기
	let list = '';
	//[<<]
	list += '<li class="page-item">';
	if(prev){	//6 11 16 21 페이지이면 링크있고 앞페이지로 갈수있게하고 앞페이지 변수 삽입
		list += '<a class="page-link" href="#" aria-label="Previous" data-page="'+(startPage-1)+'">&laquo;</a>';
	}else{	//1페이지 이면 클릭 못하게
		list += '<span class="page-link disabled" aria-hidden="true">&laquo;</span>';
	}
	list += '</li>';
	
	// [1] [2] [3] [4] [5]
	for(let p=startPage; p<=endPage; p++){
		list += '<li class="page-item"><a class="page-link" href="#" data-page="'+p+'">'+p+'</a></li>';
	}
	
	//[>>]
	list += '<li class="page-item">';
	if(next){
		list += '<a class="page-link" href="#" aria-label="Next" data-page="'+(endPage+1)+'">&raquo;</a>';
	}else{
		list += '<span class="page-link disabled" aria-hidden="true">&raquo;</span>';
	}
	list += '</li>';
	
	//텍스트로 태그르 적어 논거라서 appendchild 가 아니라 innerHTML 이여야함
	document.querySelector('nav ul.pagination').innerHTML = list;
	linkMove();	
}


//★4-2 페이지 [<<][1][2][3][4][5][>>] 클릭할경우 페이지번호전달, 댓글리스팅, 댓글총갯수
function linkMove(){
	//해당위치 안에 있는 모든 a태그를 가져와서 반복하겠다
	document.querySelectorAll('nav ul.pagination a').forEach(function(aTag){
		//aTag는 그냥 a태그를 가르키고 abc 해도 됨
		aTag.addEventListener('click',function(e){
			e.preventDefault();	//기본 클릭 이벤트 막기
			page = aTag.dataset.page;	//페이지에 클릭한 페이지 넣고
			showList();	//댓글 재 리스팅
			svc2.getReplyCount(bno, createPageList, err=>{console.log('카운팅 하는곳2',err)});
		})
	})
}