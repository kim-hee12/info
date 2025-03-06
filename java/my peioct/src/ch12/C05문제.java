package ch12;

class Employee {
	private int age;
	private String addr;
	public String name;

	public Employee(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public String getAddr() {
		return addr;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 나이: " + age + ", 주소: " + addr;
	}

}

class Parttimer extends Employee {
	private int hour_pay;

	public Parttimer(String name, int age, String addr, int hour_pay) {
		super(name, age, addr);
		this.hour_pay = hour_pay;
	}

	public void setHourPay(int pay) {
		this.hour_pay = pay;
	}

	public int getHourPay() {
		return hour_pay;
	}

	@Override
	public String toString() {
		return super.toString() + ", 시급: " + hour_pay;
	}

}

class Regular extends Employee {
	private int salary;

	public Regular(String name, int age, String addr, int salary) {
		super(name, age, addr);
		this.salary = salary;
	}

	public void setSalart(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return super.toString() + ", 연봉: " + salary;
	}
	
	
}

public class C05문제 {

	public static void main(String[] args) {

		Parttimer emp1 = new Parttimer("홍길동", 25, "대구", 20000);
		Regular emp2 = new Regular("서길동", 45, "울산", 50000000);
		System.out.println(emp1);
		System.out.println(emp2);
	}

}
