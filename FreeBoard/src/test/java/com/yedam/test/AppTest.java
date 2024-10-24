package com.yedam.test;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

//기능들 정상적으로 됐는지 확인하는 페이지 [테스트 페이지]
public class AppTest {
	public static void main(String[] args) {

		BoardService svc = new BoardServiceImpl();
		List<Map<String, Object>> result = svc.countByWriter();
		
		//for문 돌려도되는데 이걸로 이쁜모양으로 보여줄수도 있따
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);
		
		System.out.println(json);
	}//main
}//AppTest
