package ch08;

public class C00info {

	public static void main(String[] args) {
		
		// 1. 객체 - Object
		// 존재(독점적이고 배타적인 공간을 차지)하는 사물(Object)
		
		// 2. 객체
		// 속성 (Attribute) : 객체마다 구별되는 데이터(저장 - 변수처리)
		// 기능 (Function) : 객체가 수행할 수 있는 공통 Action(기능 - 매서드 처리)
		
		// 3. 객체 지향
		// 현실 세계의 여러 객체의 정보(속성/기능) 중에 필요한 일부만 추출(추상화)하여 
		// 문제 해결을 하기 위한 요소단위로 적재(저장)하기 위해 고안된 문법
		
		// 4. 클래스
		// 동일한 종류의 객체에 필요한 메모리공간을 제공하기 위해 선언된 자료형
		// 클래스로 객체를 생성하기 전에는 기본적으로 메모리공간을 차지하지 않는다.
		// (Document화)
		// 클래스 자료형에 의해 객체가 정의되는 순간 클래스에서 선언한 속성과 기능대로 공간형성이 이루어진다.
		
		// 5. 자바의 메모리 영역
		// 1) 스택영역 : {} 내에서 생성되고 소멸되는 영역(int,double..) 
		// 2) 클래스(==매서드)영역 : 공유메모라영역(생성자,일반메서드,static메서드,static변수)
		// 3) 힙영역 : 객체 저장 영역(new 예약어 사용시 할당) 
		
		// 6. 코드 해석
		// Scanner sc = new Scanner(System.in);
		
		// new : 힙(Heap) 영역에 객체 저장
		// Scanner() : 객체에 필요한 초기값을 부여하기 위한 생성자 메서드
		// Scanner sc : Scanner 라는 클래스 자료형으로 정의된 참조변수 sc
		
		// 힙메모리 영역에 Scanner에 필요한 초기값이 담긴 객체를 생성하고
		// 현위치(main stack)에 Scanner 자료형으로 만든 sc 참조변수에 생성된 Scanner객체의 "시작 위치" 주소 저장
		
		
	}

}
