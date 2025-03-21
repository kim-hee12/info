package ch12;

class C08Super{
	void func1() {System.out.println("C08.Super.Func1() Call!");}
	void func2() {};
}
class C08Sub extends C08Super{
	void func2() {System.out.println("C08.Sub.Func2() Call!");}
}

public class C08UpDownCastingMain {

	public static void main(String[] args) {
		
		C08Super ob1 = new C08Super();
		ob1.func1();
		
		System.out.println("---------------");
		C08Sub ob2 = new C08Sub();
		ob2.func1();
		ob2.func2();
		
		System.out.println("---------------");
		C08Super ob3 = new C08Sub();
		ob3.func1();
		ob3.func2();
		
		// Upcasting
		// 확장된 (멤버추가) 멤버변수 접근 블가능하다
		// 확장된 (멤버추가) 멤버함수 접근 불가능하다
		// 재정의된 메서드 접근 가능하다
	}

}
