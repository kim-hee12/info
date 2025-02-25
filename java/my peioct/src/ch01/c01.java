package ch01;

public class c01 {

	public static void main(String[] args) {
		
		// System.out.print()
		// \n : 개행, 줄바꿈
		// \b : 벡스페이스
		// \t : 탭길이(기본 8칸) 만큼 ㅓ서 이동
		System.out.print("helloworld\n");
		System.out.print("helloworld\n");
		System.out.print("helloworld\n");
		System.out.print("helloworld\n");
		System.out.print("helloworld\n");
		System.out.print("helloworld\n");
		System.out.print("helloworld\n");
		
		
		// format : 형식,서식
		// %d : 10진수 정수 서식문자
		// %f : 10진수 실수 서식문자
		// %c : 한 문자 서식문자 
		// %s : 문자열 서식문자
		
		System.out.printf("%d %d %d \n",10,20,30);
		System.out.printf("%f %f %f \n",10.1,20.1,30.1);
		System.out.printf("%c %c %c \n",'a','b','c');
		System.out.printf("%s %s %s \n","This is","String","Test");
		System.out.printf("%d.%s : %d\n",1,"국어",100); // System.out.printf();
		
		
		// println()
		System.out.println("helloWorld");
		System.out.println("helloWorld");
		System.out.println("helloWorld");
		System.out.println("helloWorld");
	}

}
