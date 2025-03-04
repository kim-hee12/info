package ch07;

import java.util.Scanner;

public class C03Continue_Break {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		int n;
//		int sum = 0;
//		
//		while(true) {
//			n = sc.nextInt();
//			if(n==-1)
//				break;
//			
//			sum += n ;
//		}
//		
//		System.out.println("SUM : "+ sum);
//		sc.close();
		
//		boolean flag = false;
//		int j = 2;
//		while(j <= 9) {
//			int i = 1;
//			System.out.printf("\n----%d단-----", j);
//			while(i<=9) {
//				System.out.printf("\n%d * %d = %d",j,i,j*i);
//				if(j==7 && i==7) {
//					flag = true;
//					break;
//				}
//				i++;
//				
//			}
//			if(flag)
//				break;
//			j++;
//		}
		
		
		int i = 1;
		int sum = 0 ;
		while(i<=10) {
			
			if(i%3==0)
				continue;
			
			System.out.println("i : " + i);
			sum+=i;
			i++;
			
		}
		System.out.println("sum : " + sum);
		
	}

}
