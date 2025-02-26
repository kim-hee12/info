package ch05;

import java.util.Scanner;

public class C02문제 {

	public static void main(String[] args) {

		// 1.문제(삼항연산자)
		// 키보드로 국어/영어/수학 점수를 입력받아 각각의부분점수가 40점이상이고
		// 총점수 평균이 70점이상이면 '합격'
		// 미만이면 '불합격'을 출력합니다
		
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.print("국어 : ");
//		int num1=scanner.nextInt();
//
//		System.out.print("영어 : ");
//		int num2=scanner.nextInt();
//		
//		System.out.print("수학 : ");
//		int num3=scanner.nextInt();
//		
//		String grade = (num1>=40)&&(num2 >= 40)&&(num3 >= 40) && ((num1+num2+num3)/3 >= 70)? "합격" : " 불합격";
//		System.out.println(" " +grade);

		// 2.미니문제(%연산자)
		// 키보드로 부터 정수값 2 를 입력받아
		// 두수의 합이 짝수이면 "짝수입니다"
		// 홀수이면 "홀수입니다" 를 출력하세요~
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫 번째 수 : ");
		int num1=scanner.nextInt();
		System.out.print("두 번째 수 : ");
		int num2=scanner.nextInt();
		String grade = ((num1+num2)%2==0)?"짝수입니다." :"홀수입니다.";
		System.out.println("" +grade);
		
		

	}

}
