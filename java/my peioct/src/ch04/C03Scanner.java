package ch04;

import java.util.Scanner;

public class C03Scanner {

	public static void main(String[] args) {
		
		// 섞어서 쓸 때 nextline 위에 한 번더 써 줘야 버퍼가 오류 안 남
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("입력된 정수 값 : " + num1);
		
		sc.nextLine();
		System.out.print("문자열 입력(띄어쓰기 포함) : ");
		String str2 = sc.nextLine();
		System.out.println("입력된 문자열: " + str2);
		
//		System.out.print("실수 입력 : ");
//		double num2 = sc.nextDouble();
//		System.out.println("입력된 실수 값 : " + num2);
//		
//		System.out.print("문자열 입력 : ");
//		String str1 = sc.next();
//		System.out.println("입력된 문자열: " + str1);
//		
		


	}

}
