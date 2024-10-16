package com.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {
	//HttpServletRequest 요청정보 객체
	//XHttpServletResponse 응답처리 객체
	void exec(HttpServletRequest req, HttpServletResponse resp);
}
