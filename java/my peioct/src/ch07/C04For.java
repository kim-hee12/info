package ch07;

public class C04For {

	public static void main(String[] args) {

//		int i = 0;
//		while(i<10) {
//			System.out.println("hello world");
//			i++;
//			
//		}

//		for(int i = 0 ; i<10;i++) {
//			System.out.println("hello world");
//		}

//		// 1-10까지 합
//		int sum = 0;
//		for(int i = 0 ; i<=10;i++) {
//			
//			sum+=i;
//		}
//		System.out.println("합 : "+sum);

		// 별 찍기 (정삼각형)
		
		for (int i = 0; i <4; i++){
			for(int j=0; j<3-i;j++ ){
				System.out.print(" ");
			}
			
			for(int k=0;k<=2*i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}
