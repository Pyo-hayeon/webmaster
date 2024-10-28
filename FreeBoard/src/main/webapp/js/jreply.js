/**
 * jreply.js
 */

$(function() {

	var page = 1;
		
	console.log('start');
	
	listing();
	function listing(){
		$('div.content ul li').remove();
		$.ajax('replyList.do?bno='+bno+'&page='+page)
		.done(function(result){
			console.log(result);	//[{},{},{},{}] 배열임
			result.forEach((item) => {
				$('<li />').append( 
					$('<span />').addClass('col-sm-2').text(item.replyNo)	//글번호
					,$('<span />').addClass('col-sm-5').text(item.reply)	//댓글내용
					,$('<span />').addClass('col-sm-2').text(item.replyer)	//작성자
					,$('<span />').addClass('col-sm-2').append( $('<button>삭제</button>') )	//삭제버튼
				)
				.appendTo($('div.content ul'));
			});
		})
		.fail(function(err){
			console.log(err);
		})
	}
	
	
			
	//삭제 이벤트
	//dom으로 안그려진 기존에 있는 태그에 이벤트를 걸어야함 아작스밖으로 빼면
	$('div.content ul').on('click', 'button', function(e){
		console.log('rno=', $(e.target).parent().parent().find('span:eq(0)').text());
		let rno = $(e.target).parent().parent().find('span:eq(0)').text();
		//삭제하는 아작스
		$.ajax({
			url: 'removeReply.do',
			data: {rno: rno},
			method: "POST",
	    	dataType: "json"	//서버에서 가져온 결과값 // 문자열을 자바스크립트의 객체로 자동으로 파싱해줌
		})
		.done(function(result){
			if(result.retCode == 'OK'){
				$(e.target).closest('li').remove();
				console.log('성공');
				listing();
			}else if(result.retCode == 'FAIL'){
				console.log('실패');
			}
		})
		.fail(function(err){
			console.log(err);
		});
		//$(e.target).parent().parent().remove();
		//$(e.target).closest('li').remove();
	})
	
	
	//댓글등록
	$('#addReply').on('click', function(e){
		let reply = $('#reply').val();
		if(!reply || !logId){
			alert('내용 또는 로그인 해주세요');
		}else{
			//등록하는 아작스
			$.ajax({
				url: 'addReply.do',
				data: {bno: bno, reply: reply, replyer:logId},
				method: "POST",
		    	dataType: "json"	//서버에서 가져온 결과값 // 문자열을 자바스크립트의 객체로 자동으로 파싱해줌
			})
			.done(function(result){
				if(result.retCode == 'OK'){
					$(e.target).closest('li').remove();
					console.log('성공');
					listing();
				}else if(result.retCode == 'FAIL'){
					console.log('실패');
				}
			})
			.fail(function(err){
				console.log(err);
			});
		}
	});
	
	//replyCount.do 페이징 bno
	$.ajax({
		url: 'replyCount.do',
		data: {bno: bno},
		method: "POST",
    	dataType: "json"	//서버에서 가져온 결과값 // 문자열을 자바스크립트의 객체로 자동으로 파싱해줌
	})
	.done(function(result){
		console.log(result.totalCount);
	})
	.fail(function(err){
		console.log(err);
	});
	
	
	//[1][2][3] 클릭시 처리
	$('nav ul.pagination a').on('click', function(e){
		alert($(e.target).val());
		e.preventDefault();
	});
	
	//page-link
	/*
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
	*/
	
	
	
	


});
