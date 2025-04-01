package ch38.Tests.Controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ch38.Controller.FrontController;

class ControllerTests {

	FrontController fc = FrontController.getInstance();

	@Test
	void test() {
		Map<String, Object> params = new HashMap();
		params.put("endPoint", "/book");
		params.put("serviceNo", 1);
//		// 회원가입 - 인자전달
//		params.put("userid","cccccc");
//		params.put("username","홍길동");
//		params.put("password","1234");
		
		// 도서등록-인자전달
		params.put("bookcode","11111111");
		params.put("bookName","이것이리눅스다.");
		params.put("publisher","한빛미디어");
		params.put("isbn","1111-1111");
		// 요청하기
		Map<String, Object> response = fc.execute(params);

		// 응답확인
		for (String key : response.keySet()) {
			System.out.println(key + " : " + response.get(key));
		}
	}

	@Test
	@Disabled
	void test_99() {

	}

}
