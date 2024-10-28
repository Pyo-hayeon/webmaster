/**
 * jreply.js
 */

$(function() {

	var page = 1;

	console.log('start');

	listing();
	function listing() {
		console.log('page', page);
		$('div.content ul li').remove();
		$.ajax('replyList.do?bno=' + bno + '&page=' + page)
			.done(function(result) {
				console.log(result);	//[{},{},{},{}] 배열임
				result.forEach((item) => {
					$('<li />').append(
						$('<span />').addClass('col-sm-2').text(item.replyNo)	//글번호
						, $('<span />').addClass('col-sm-5').text(item.reply)	//댓글내용
						, $('<span />').addClass('col-sm-2').text(item.replyer)	//작성자
						, $('<span />').addClass('col-sm-2').append($('<button>삭제</button>'))	//삭제버튼
					)
						.appendTo($('div.content ul'));
				});
			})
			.fail(function(err) {
				console.log(err);
			})
	}



	//삭제 이벤트
	//dom으로 안그려진 기존에 있는 태그에 이벤트를 걸어야함 아작스밖으로 빼면
	$('div.content ul').on('click', 'button', function(e) {
		console.log('rno=', $(e.target).parent().parent().find('span:eq(0)').text());
		let rno = $(e.target).parent().parent().find('span:eq(0)').text();
		//삭제하는 아작스
		$.ajax({
			url: 'removeReply.do',
			data: { rno: rno },
			method: "POST",
			dataType: "json"	//서버에서 가져온 결과값 // 문자열을 자바스크립트의 객체로 자동으로 파싱해줌
		})
			.done(function(result) {
				if (result.retCode == 'OK') {
					$(e.target).closest('li').remove();
					console.log('성공');
					listing();
					pageCnt();
				} else if (result.retCode == 'FAIL') {
					console.log('실패');
				}
			})
			.fail(function(err) {
				console.log(err);
			});
		//$(e.target).parent().parent().remove();
		//$(e.target).closest('li').remove();
	})


	//댓글등록
	$('#addReply').on('click', function(e) {
		let reply = $('#reply').val();
		if (!reply || !logId) {
			alert('내용 또는 로그인 해주세요');
		} else {
			//등록하는 아작스
			$.ajax({
				url: 'addReply.do',
				data: { bno: bno, reply: reply, replyer: logId },
				method: "POST",
				dataType: "json"	//서버에서 가져온 결과값 // 문자열을 자바스크립트의 객체로 자동으로 파싱해줌
			})
				.done(function(result) {
					if (result.retCode == 'OK') {
						$(e.target).closest('li').remove();
						console.log('성공');
						listing();
						pageCnt();
					} else if (result.retCode == 'FAIL') {
						console.log('실패');
					}
				})
				.fail(function(err) {
					console.log(err);
				});
		}
	});

pageCnt();
//replyCount.do 페이징 bno
function pageCnt(){	
	$.ajax({
		url: 'replyCount.do',
		data: { bno: bno },
		method: "POST",
		dataType: "json"	//서버에서 가져온 결과값 // 문자열을 자바스크립트의 객체로 자동으로 파싱해줌
	})
		.done(function(result) {
			console.log(result.totalCount);
			createPageList(result);
		})
		.fail(function(err) {
			console.log(err);
		});
}


function linkMove(){
	//[1][2][3] 클릭시 처리
	$('nav ul.pagination a').on('click', function(e) {
		console.log('linkmove', $(e.target).data('page'));
		page = $(e.target).data('page');
		listing();
		pageCnt();
	});
}

	//카운팅페이지
	function createPageList(result) {
		//{"totalCount":11}
		let totalCnt = result.totalCount;
		console.log('totalCnt', totalCnt);
		
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


		$('ul.pagination').empty();
		//위의 내용을 토대로 페이지 버튼 그리기
		if(prev){
			$('<li />').addClass('page-item').append(
				$('<a class="page-link" href="#" aria-label="Previous" data-page="' + (startPage - 1) + '">&laquo;</a>')
			)
			.appendTo($('nav ul.pagination'));
		}else{
			$('<li />').addClass('page-item').append(
				$('<span class="page-link disabled" aria-hidden="true">&laquo;</span>')
			)
			.appendTo($('nav ul.pagination'));
		}
		
		for (let p = startPage; p <= endPage; p++) {
			$('<li />').addClass('page-item').append(
				$('<a class="page-link" href="#" data-page="' + p + '">' + p + '</a>')
			)
			.appendTo($('nav ul.pagination'));
		}
		
		if(next){
			$('<li />').addClass('page-item').append(
				$('<a class="page-link" href="#" aria-label="Next" data-page="' + (endPage + 1) + '">&raquo;</a>')
			)
			.appendTo($('nav ul.pagination'));
		}else{
			$('<li />').addClass('page-item').append(
				$('<span class="page-link disabled" aria-hidden="true">&raquo;</span>')
			)
			.appendTo($('nav ul.pagination'));
		}

		linkMove();
	}








});
