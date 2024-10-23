/**
 * 서비스 등록
 */

const svc2 = {
	//rlist(메소드,함수,함수);
	rlist(param={bno, page}, successFnc, errorFnc){
		fetch('replyList.do?bno='+param.bno+'&page='+param)
		.then(resolve => resolve.json())
		.then(successFnc)
		.catch(errorFnc)
	}
}