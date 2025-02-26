package ch04;

import java.util.Scanner;

public class C04문제 {

	public static void main(String[] args) {
		
//		--------------------------------------------------------
//		정리
//		--------------------------------------------------------
//		System.out.print	: 기본 출력 메서드
//		System.out.printf	: 서식문자 사용가능한 출력 메서드
//		System.out.println	: 개행 기본 출력 메서드 
//		Scanner : 키보드로부터 입력받는 장치 생성에 필요한 클래스 자료형

//		--------------------------------------------------------
		// 문제
//		--------------------------------------------------------
		// 이름을 입력하세요? 홍길동
		// 홍길동 님의 나이를 입력하세요? 35
		// 홍길동 님의 주소를 입력하세요? 대구광역시 달서구 000
		// 홍길동 님의 나이는 35세 주소는 대구광역시 ~~ 입니다
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("이름을 입력하세요? ");
//		String str1 = sc.next();
//		
//		
//		System.out.printf("%s 님의 나이를 입력하세요? ",str1 );
//		int num1 = sc.nextInt();
//		
//		sc.nextLine();
//		System.out.printf("%s 님의 주소를 입력하세요? ",str1);
//		String str2 = sc.nextLine();
//		
//		System.out.printf("%s 님의 나이는 %d세 주소는 %s입니다.",str1,num1,str2);
		
		

//		--------------------------------------------------------
//		문제
//		--------------------------------------------------------
//		Scanner 를 이용해서 키보드로 입력한 두수를 덧셈하여 결과를 출력해보세요
//
		
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.print("첫번째 수 : ");
//		String strNum1=scanner.nextLine();
//
//		System.out.print("두번째 수 : ");
//		String strNum2=scanner.nextLine();
//
//		int num1 = Integer.parseInt(strNum1);
//		int num2 = Integer.parseInt(strNum2);
//
//		int result = num1 + num2;
//		System.out.println("덧셈 결과 : " + result);

//
//		--------------------------------------------------------
//		문제
//		--------------------------------------------------------
//		Scanner를 이용해서 이름, 주미번호 앞 6자리 , 전화번호를 키보드에서
//		입력받고 출력하는 코드를 작성해보세요
//
//		[예시]
//		----------------------------
//		[필수 정보 입력]
//		1. 이름 : ______________ENTER
//		2. 주민번호 6자리 : ______________ENTER
//		3. 전화번호 : ____________ENTER
//
//		[입력한 내용]
//		이름 : 홍길동
//		주민번호 : 123456
//		PH : 010-222-3333
//		----------------------------
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[필수 정보 입력]\n");

		System.out.print("1. 이름 : ");
		String name = sc.nextLine();
		System.out.print("2. 주민번호 6자리 : ");
		String id = sc.nextLine();
		System.out.print("3. 전화번호 : ");
		String phone = sc.nextLine();

		System.out.printf("\n[입력한 내용]\n이름 : %s\n주민번호 : %s\nPH : %s\n",name,id,phone);
//		
		
		

	}

}
