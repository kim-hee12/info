package ch06;

import java.util.Scanner;

public class C01IF {

	public static void main(String[] args) {
		
		// 단순 if
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("나이 : ");
//		int age = sc.nextInt();
//		if(age >= 8)
//			System.out.println("학교에 다닙니다.");
//		System.out.println("첫 번째 IF 코드 블럭 종료..");
//		if(age < 8)
//			System.out.println("학교에 다니지 않습니다.");
//		System.out.println("두 번째 IF 코드 블럭 종료..");
//		
//		System.out.println("프로그램을 종료합니다.");
//		sc.close();
		
		// if-else
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("나이 : ");
//		int age = sc.nextInt();
//		if(age >= 8)
//			System.out.println("학교에 다닙니다.");
//		else
//			System.out.println("학교에 다니지 않습니다.");
//		
//		System.out.println("프로그램을 종료합니다.");
//		sc.close();
		
		// 문제
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자 하나를 입력하세요 ");
//		int age = sc.nextInt();
//		if(age%3==0 && age%5==0)
//			System.out.println("출력");
//		else if(age%3==0 )
//			System.out.println(""+age);
//		
//		System.out.println("프로그램을 종료합니다.");
//		sc.close();
		
		
		// 문제 - 두 개의 정수 입력받아 큰 수면 출력
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("첫 번째 수 입력 : ");
//		int num1 = sc.nextInt();
//		System.out.print("두 번째 수 입력 :");
//		int num2 = sc.nextInt();
//		if(num1 => num2)
//			System.out.printf("%d가 더 큽니다",num1);
//		else if(num1 <= num2)
//			System.out.printf("%d가 더 큽니다.",num2);
//		
//		sc.close();
		
		// 문제 - 세 개의 정수를 입력받아 큰 수 출력
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("첫 번째 수 입력 : ");
//		int num1 = sc.nextInt();
//		System.out.print("두 번째 수 입력 :");
//		int num2 = sc.nextInt();
//		System.out.print("세 번째 수 입력 :");
//		int num3 = sc.nextInt();
//		if(num1 => num2 && num1 => num3)
//			System.out.printf("%d가 더 큽니다",num1);
//		else if(num1 <= num2 && num3 <= num2)
//			System.out.printf("%d가 더 큽니다.",num2);
//		else
//			System.out.printf("%d가 더 큽니다.",num3);
//			
//		sc.close();
		
		// 문제 - 세 개의 정수를 입력받아 해당수의 합과 평균 출력
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("첫 번째 수 입력 : ");
//		int num1 = sc.nextInt();
//		System.out.print("두 번째 수 입력 :");
//		int num2 = sc.nextInt();
//		System.out.print("세 번째 수 입력 :");
//		int num3 = sc.nextInt();
//		
//		System.out.printf("\n합 : %d \n평균 : %d",num1+num2+num3,num1+num2+num3/3);
//		sc.close();
		
		// 문제 - 수가 짝수고 3의 배수면 출력, 수가 홀수고 5의 배수면 출력
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자 하나를 입력하세요");
//		int num = sc.nextInt();
//		if(num % 2 == 0 && num % 3 ==0)
//			System.out.printf("%d는 짝수이자 3의 배수입니다.",num);
//		else if(num % 2 == 1 && num % 5 ==0)
//			System.out.printf("%d는 홀수이자 5의 배수입니다.",num);
//		
//		sc.close();
		
		// 문제 - 과목 중 하나라도 40점 미만이면 불합격, 과목 평균 60점 미만이면 불합격
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("첫 번째 과목 입력 : ");
//		int num1 = sc.nextInt();
//		System.out.print("두 번째 과목 입력 :");
//		int num2 = sc.nextInt();
//		System.out.print("세 번째 과목 입력 :");
//		int num3 = sc.nextInt();
//		System.out.print("네 번째 과목 입력 :");
//		int num4 = sc.nextInt();
//		if(num1<40||num2<40||num3<40||num4<40 || (num1+num2+num3+num4)/4<60)
//			System.out.print("불합격");
//		else
//			System.out.print("합격");
//
//			
//		sc.close();
		
		// 문제 = 시험 90 이상 a 80 이상 b 70 이상 c 60 이상 d 나머지 f
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("시험 점수 입력 : ");
//		int num1 = sc.nextInt();
//
//		if(num1>=90)
//			System.out.print("A");
//		else if(num1>=80)
//			System.out.print("B");
//		else if(num1>=70)
//			System.out.print("C");
//		else if(num1>=60)
//			System.out.print("D");
//		else
//			System.out.print("F");
//
//			
//		
//		sc.close();
		
		// 문제 - 8세 미만 1000원 14세 미만 2000원 20세 미만 2500원 20세 이상 3000원
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("나이 입력 : ");
//		int num1 = sc.nextInt();
//
//		if(num1<8)
//			System.out.print("1000원");
//		else if(num1<14)
//			System.out.print("2000원");
//		else if(num1<20)
//			System.out.print("2500원");
//		else
//			System.out.print("3000원");
//
//		sc.close();

	}

}
