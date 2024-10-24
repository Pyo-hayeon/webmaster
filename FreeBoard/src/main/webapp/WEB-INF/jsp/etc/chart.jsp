<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	var chartData = [['Writer', 'Count per Writer']];
	
	//비동기방식이라서 늦게 처리끝나면 차트 못그리고 지나간다
	//그래서 차트를 그리는 구글메소드를 데이터 완료처리 한 후에 그릴수있또록 변경한다
	fetch('countByWriter.do')
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		result.forEach((row)=>{
			chartData.push([row.member_name, row.count]);
		});
		console.log(chartData);
		google.charts.load('current', { 'packages' : [ 'corechart' ] });
		google.charts.setOnLoadCallback(drawChart);
	})
	.catch(err => console.log(err));

	
	function drawChart() {
		var data = google.visualization.arrayToDataTable(chartData
		/*[
		  ['Task', 'Hours per Day'],
		  ['Work',     11],
		  ['Eat',      2],
		  ['Commute',  2],
		  ['Watch TV', 2],
		  ['Sleep',    7],
		  ['Test',     7]
		]*/
		);
		var options = { title : '사용자별 게시글 현황' };
		var chart = new google.visualization.PieChart(document.getElementById('piechart'));
		chart.draw(data, options);
	}//drawChart()
</script>
</head>
<body>
	<div id="piechart" style="width: 900px; height: 500px;"></div>
</body>
</html>
