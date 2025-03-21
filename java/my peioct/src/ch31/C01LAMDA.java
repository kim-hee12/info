package ch31;

import java.util.ArrayList;
import java.util.List;

class Person {
	private String name;
	private int age;

	// 생성자(디폴트,모든인자)
	Person(){}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	// getter and setter
	// toString

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	

}
 
public class C01LAMDA {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("jung",55));
		list.add(new Person("hong",22));
		list.add(new Person("bob",33));
		
		list.forEach(System.out::println);
		System.out.println("--");
		
		// 정렬
		list.sort((a,b)->{return b.getAge()-a.getAge();}); // 나이순 정렬
		//
		list.forEach((item)->{System.out.println(item);});
	}

}
