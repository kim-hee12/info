package ch07;

import java.util.Scanner;

public class C01While {

	public static void main(String[] args) {

		// 1. 기본
//		int i=0;
//		while(i<10) {
//			System.out.println("Hello World");
//			i++;
//		}

		// 2. n회 반복
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int i=0;
//		while(i<n) {
//			System.out.println("Hello World");
//			i++;
//		}

//		// 3. 기본 - 1-10 합 
//		
//		int i=1;
//		int sum = 0;
//		while(i<=10) {
//			System.out.println("i :"+ i);
//			sum +=i;
//			i++;
//		}
//		System.out.println("sum :"+ sum);

//		// 4. 기본 - 1-n 합
//		Scanner sc = new Scanner(System.in);
//		System.out.println("번호 입력 :");
//		int n = sc.nextInt();
//		int i = 1;
//		int sum = 0;
//		while (i <= n) {
//			System.out.println("i :" + i);
//			sum += i;
//			i++;
//		}
//		System.out.println("sum :" + sum);

//		// 5. 기본 - n-m 합
//		Scanner sc = new Scanner(System.in);
//		System.out.println(" 번호 입력 :");
//		int n = sc.nextInt();
//		System.out.println(" 번호 입력 :");
//		int m = sc.nextInt();
//		int sum = 0;
//		while (n <= m) {
//			System.out.println("n :" + n);
//			sum += n;
//			n++;
//		}
//		System.out.println("sum :" + sum);
//		
//		while (n >= m) {
//			System.out.println("m :" + m);
//			sum += m;
//			m++;
//		}
//		System.out.println("sum :" + sum);
		
		
//		// 6. 기본 - n-m 합 (짝,홀)
//				Scanner sc = new Scanner(System.in);
//				System.out.println(" 번호 입력 :");
//				int n = sc.nextInt();
//				System.out.println(" 번호 입력 :");
//				int m = sc.nextInt();
//				int sum1 = 0;
//				int sum2 = 0;
//				while (n < m) {
//
//					if(n%2==0) {
//						sum1 = n;
//					}
//					else {
//						sum2 = n;
//					}
//					n++;
//				}
//				System.out.println("짝수의 합 : " + sum1 +"\n홀수의 합 : " + sum2);
				
		
		
//		// 7. 기본 1-n 4의 배수 출력
//		Scanner sc = new Scanner(System.in);
//		System.out.println(" 번호 입력 :");
//		int n = sc.nextInt();
//		int sum1 = 0;
//		int i = 1;
//		while (i < n) {
//
//			if(i%4==0) {
//				System.out.println("4의 배수  : " + i);
//				sum1 += i;
//			}
//			i++;
//		}
//		System.out.println("4의 배수 합 : " + sum1);
		
		
		// 8. 구구단 n단 출력
				Scanner sc = new Scanner(System.in);
				System.out.println(" 구구단 입력 :");
				int n = sc.nextInt();
				int i = 1;
				while (i < 10) {


					System.out.printf("\n%d * %d = %d ",n,i,n*i);
					i++;
				}



	}

}
