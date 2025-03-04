package ch07;

import java.util.Scanner;

public class C02While {

	public static void main(String[] args) {

//		// 2-9단 출력
//		
//		int j = 2;
//		while(j <= 9) {
//			int i = 1;
//			System.out.printf("\n----%d단-----", j);
//			while(i<=9) {
//				System.out.printf("\n%d * %d = %d",j,i,j*i);
//				i++;
//			}
//			j++;
//		}

//		// 2-9단 출력 (2*9부터 거꾸로)
//		
//		int j = 2;
//		while (j <= 9) {
//			int i = 9;
//			System.out.printf("\n----%d단-----", j);
//			while (i >= 1) {
//				System.out.printf("\n%d * %d = %d", j, i, j * i);
//				i--;
//			}
//			j++;
//		}

//		// 9-2단 출력 (2*9부터 거꾸로)
//
//		int j = 9;
//		while (j >= 2) {
//			int i = 9;
//			System.out.printf("\n----%d단-----", j);
//			while (i >= 1) {
//				System.out.printf("\n%d * %d = %d", j, i, j * i);
//				i--;
//			}
//			j--;
//		}

//		//2단 - n단
//		Scanner sc = new Scanner(System.in);
//		System.out.println("몇 단 까지? :");
//		int n = sc.nextInt();
//		int j = 2;
//		while (j <= n) {
//			int i = 9;
//			System.out.printf("\n----%d단-----", j);
//			while (i >= 1) {
//				System.out.printf("\n%d * %d = %d", j, i, j * i);
//				i--;
//			}
//			j++;
//		}
//		sc.close();

		// n-m단 출력
//		Scanner sc = new Scanner(System.in);
//		System.out.println("몇 단 부터? :");
//		int n = sc.nextInt();
//		System.out.println("몇 단 까지? :");
//		int m = sc.nextInt();
//		while (n <= m && n <=9 && m <= 9) {
//			int i = 9;
//			System.out.printf("\n----%d단-----", n);
//			while (i >= 1) {
//				System.out.printf("\n%d * %d = %d", n, i, n * i);
//				i--;
//			}
//			n++;
//		}
//		sc.close();

		// 별 찍기

//		int j = 1;
//		while (j <= 4) {
//			int i = 1;
//			System.out.println("\n");
//			while (i <= 5) {
//				System.out.print("*");
//				i++;
//			}
//			j++;
//		}

//		// 별 찍기 (점점 증가)
//		
//		int j = 1;
//		int h = 1;
//		while (j <= 4) {
//			int i = 1;
//			System.out.println("\n");
//			while (i<=h){
//				System.out.print("*");
//				
//			i++;	
//			}
//			h++;
//			j++;
//		}

		// 별 찍기 (점점 감소)

//		int j = 0;
//
//		while (j<4 ) {
//			
//			
//			int i = 0;
//			System.out.println("\n");
//			while (i <4-j) {
//				System.out.print("*");
//
//				i++;
//
//			}
//			j++;
//		}
//		// 별 찍기 (삼각형)
//		
//		int i = 0;
//		int j = 4;
//		while(i < 5) {
//			while(j > i) {
//				System.out.print(" ");
//				j--;
//			}
//			System.out.println("*".repeat(i*2+1));
//			i++;
//			j=4;
//		}
//		
//		// 별 찍기 (역삼각형)
//		int i = 5;
//		int j = 5;
//		while(i > 0) {
//			while(j > i) {
//				System.out.print(" ");
//				j--;
//			}
//			System.out.println("*".repeat(i*2-1));
//			i--;
//			j=5;
//			
//		
//		}

		// 별 찍기 (다이아몬드)
		Scanner sc = new Scanner(System.in);
		 System.out.print("다이아 높이 :");
		int h = sc.nextInt();
		

		int i=0;
		while(i<h) {
			
			if(i<=(h/2)) {				
				int j=0;
				while(j<(h/2)-i) {
					System.out.print(" ");
					j++;
				}
				int k=0;
				while(k<=2*i) {
					System.out.print("*");
					k++;
				}
				
			}else {
				
				int j=0;
				while(j<=i-(h/2+1)) {
					System.out.print(" ");
					j++;
				}	
				
				int k=0;
				while(k<=((h-1)*2)-2*i) {
					System.out.print("*");
					k++;
				}
				
			}
		System.out.println();		 
		i++;




	`// 별 찍기 (모래시계)
		

		int i = 0;
		while (i < 7) {
			
		if (i < 4) {

				int j = 0;
				while (j < i ) {
					System.out.print(" ");
					j++;
				}

				int k = 0;
				while (k <= 6 - 2 * i) {
					System.out.print("*");
					k++;
				}

			}

			else{
				int j = 0;
				while (j < 6 - i) {
					System.out.print(" ");
					j++;
				}
				int k = 0;
				while (k <= 2 * i-6) {
					System.out.print("*");
					k++;
				}

			}
			
			System.out.println();
			i++;
			
	}
			
  }
}


