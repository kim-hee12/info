package ch07;

import java.util.ArrayList;
import java.util.List;

public class C05기타반복처리 {

	public static void main(String[] args) {
		
		// Collection 객체를 이용 - 저장
		List<String> lists = new ArrayList();
		lists.add("java");
		lists.add("jsp/servlet");
		lists.add("spring sts");
		lists.add("springboot");
		lists.add("react");
		lists.add("oracle");
		
		// 기본 for
		
		for(int i=0;i<lists.size();i++) {
			System.out.println(lists.get(i));
			
		}
		System.out.println("---------------");
		
		// 개량 for
		for(String subject : lists) {
			System.out.println(subject);
		}
		System.out.println("---------------");
		
		// Stream forEach
		
		lists.stream().forEach((item)->{System.out.println(item);});
	}

}
