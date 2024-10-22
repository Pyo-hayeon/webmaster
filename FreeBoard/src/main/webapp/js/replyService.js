/**
 * replyService.js
 * 메소드 : 목록, 등록, 삭제,
 */
//대표적인 비동기방식 객체

const svc = {
	//리플 리스트 메소드
	//값을 순서대로 3개 받겠다 (bno초기값은 1로 하고) 값을 순서대로 넣은거
	rlist(bno = 1, successFnc, errorFnc){	
		fetch('replyList.do?bno='+bno)
		.then(resolve => resolve.json())
		.then(successFnc)
		.catch(errorFnc)
	}
//	,
//	showMsg(msg){
//		console.log(msg);
//	}
}
