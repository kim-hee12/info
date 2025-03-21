package ch31;

import java.util.Scanner;

interface Printer{
//	void print(String message); // 추상메서드
//	String print(String message); // 추상메서드
	String print(); // 추상메서드
}

public class C02LAMDA {

	public static void main(String[] args) {
		// 01
//		Printer printer = (message) ->{System.out.println(message);};
//		printer.print_1("helloworld");
		
		// 02 
//		Printer printer = (message)->message+"_helloworld";
//		Printer printer = message->message+"_helloworld";
//		String returnValue = printer.print("test");
//		System.out.println(returnValue);

		// 03(키보드로 입력받아 String 반환)
		Printer printer = ()->{;
		Scanner sc = new Scanner(System.in);
		System.out.print("메세지 입력 :");
		String str = sc.nextLine();
		sc.close();
		return str;
		};
		String returnValue = printer.print();
		System.out.println(returnValue);
	}

}
