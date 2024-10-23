/**
 * 서비스 등록
 */
// js 페이지에서 해당 상수 메소드 호출하면 매게값 받아와서 아래 메소드가 실행되는거임
const svc2 = {
	//★1 댓글 목록 호출
	rlist(param={bno, page}, successFnc, errorFnc){
		fetch('replyList.do?bno='+param.bno+'&page='+param.page)
		.then(resolve => resolve.json())
		.then(successFnc)
		.catch(errorFnc)
	}
	
	//★2 댓글 삭제 호출
	, removeRely(rno=1, successFnc, errorFnc){
		fetch('removeReply.do?rno='+rno)
		.then(resolve => resolve.json())
		.then(successFnc)
		.catch(errorFnc)
	}
	
	//★3 댓글 추가 호출
	, addreply(param={bno, reply, replyer}, successFnc, errorFnc){
		fetch('addReply.do?bno='+param.bno+'&reply='+param.reply+'&replyer='+param.replyer)
		.then(resolve => resolve.json())
		.then(successFnc)
		.catch(errorFnc)
	}
	
	//★4 댓글 페이징 기능 활성화 ( 댓글 총 갯수 가져옴 )
	, getReplyCount(bno=1, successFnc, errorFnc){
		fetch('replyCount.do?bno='+bno)
		.then(resolve => resolve.json())
		.then(successFnc)
		.catch(errorFnc)
	}
}