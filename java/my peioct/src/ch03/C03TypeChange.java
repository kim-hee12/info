package ch03;

public class C03TypeChange {

	public static void main(String[] args) {
		
		int num1 = 129;
		int num2 = 130;
		byte ch1 = (byte)num1; // 마지막 1byte만 존재
		byte ch2 = (byte)num2; // 마지막 1byte만 존재
		
		System.out.printf("%d\n",ch1);
		System.out.printf("%d\n",ch2);

	}

}
