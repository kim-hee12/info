package ch02;

public class c01진수 {

	public static void main(String[] args) {
		
		// %d : 10진수 서식문자
		// %o : 8진수 서식문자
		// %x : 16진수 서식문자
		
		System.out.printf("10진수 : %d\n",0b00001111);
		System.out.printf("10진수 : %d\n",173); // 10진수
		System.out.printf("10진수 : %d\n",0255); // 8진수
		System.out.printf("10진수 : %d\n",0xAD); // 16진수
		
		System.out.printf("8진수 : %o\n",173); // 10진수
		System.out.printf("8진수 : %o\n",0255); // 8진수
		System.out.printf("8진수 : %o\n",0xAD); // 16진수
	
		System.out.printf("16진수 : %x\n",173); // 10지수
		System.out.printf("16진수 : %x\n",0255); //8진수
		System.out.printf("16진수 : %x\n",0xAD); //16진수
	}

}
