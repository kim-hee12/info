package ch33;

@FunctionalInterface
interface Func1{
	void say(String message);
}

public class C01FunctionalInterfaceMain {

	public static void main(String[] args) {
		// 01
		Func1 func1 = (message)->{System.out.println(message);}; 
		func1.say("helloworld");
		
		Func1 func1_1 = System.out::println;
		func1_1.say("hello world ");
	}

}
