/**
 * replyService.js
 * 메소드 : 목록, 등록, 삭제
 * 약간 인터페이스 느낌 여기서 만들어놓고 svc.메소드 해서 가져가서 사용
 */
//대표적인 비동기방식 객체
const svc = {
	//1. 리플 리스트 메소드 (목록) (get방식)
	//값을 순서대로 3개 받겠다 (bno초기값은 1로 하고) 값을 순서대로 넣은거
	rlist(param={bno, page}, successFnc, errorFnc){	
		fetch('replyList.do?bno='+param.bno+'&page='+param.page)
		.then(resolve => resolve.json())
		.then(successFnc)
		.catch(errorFnc)
	},
	
	//2. 삭제 기능 (get방식)
	removeRely(rno = 1, successFnc, errorFnc){
		fetch('removeReply.do?rno='+rno)
		.then(resolve => resolve.json())
		.then(successFnc)
		.catch(errorFnc)
	},
	
	//bno=361&reply=test&replyer=user01
	//3. 댓글 추가 기능 (get방식)
	//변수가 여러개라서 객체로 전달하겠다는거임
	addreply(param={bno, reply, replyer}, successFnc, errorFnc){
		fetch('addReply.do?bno='+param.bno+'&reply='+param.reply+'&replyer='+param.replyer)
		.then(resolve => resolve.json())
		.then(successFnc)
		.catch(errorFnc)
	},
	
	//4. 댓글 겟수 가져옴 댓글카운터
	getReplyCount(bno=1, successFnc, errorFnc){
		fetch('replyCount.do?bno='+bno)
		.then(resolve => resolve.json())
		.then(successFnc)
		.catch(errorFnc)
	}
	
}
