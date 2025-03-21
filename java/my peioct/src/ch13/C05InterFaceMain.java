package ch13;



interface A{
	void ab();
}
interface B{
	void ab();
}

class C{
	
}
class D{

}
class E extends C implements A,B{

	@Override
	public void ab() {
		System.out.println("ABAB");
	}

}

public class C05InterFaceMain{

	public static void main(String[] args) {
		E ob = new E();
		ob.ab();
	}
}