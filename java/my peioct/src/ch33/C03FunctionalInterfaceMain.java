package ch33;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//제공되는 함수형 인터페이스들
//Function<T, R>:
//apply 메서드를 가지고 있어서 하나의 인자(T)를 받아서 결과(R)를 반환하는 함수형 인터페이스 입니다.

//Supplier<T>:
//get 메서드를 가지고 있어서 어떠한 인자도 받지 않고 결과만을 제공하는 함수형 인터페이스 입니다.
//
//Consumer<T>:
//accept 메서드를 가지고 있어서 어떠한 인자를 받아서 결과를 반환하지 않는 함수형 인터페이스 입니다.
//
//Predicate<T>:
//test 메서드를 가지고 있어서 어떠한 인자를 받아서 불리언 결과를 반환하는 함수형 인터페이스 입니다.
//
//UnaryOperator<T>:
//apply 메서드를 가지고 있어서 하나의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.
//
//BinaryOperator<T>:
//apply 메서드를 가지고 있어서 두 개의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.

public class C03FunctionalInterfaceMain {

	//01
	public static Function<Integer, Integer> func1=x->x*x;
	//02
	public static Function<Integer, Integer> func2=x->x+x;
	//03
	public static Function< List<Integer>, Integer> func3=(x)->x.stream().reduce(0,(sum,el)->{return sum+el;});;
	//04
	public static Function< List<Object>, Integer> func4=(li)->{
		//List<Object>로 받은 파라미터 중에 Integer만 추출해서 누적합 구하기

		return li.stream()
			.filter((item)->{return item instanceof Integer;})		
			.map((item)->{ 
//				System.out.println(item);
				return (Integer)item;
			})														
			.reduce(0,(sum,item)->{return sum+item;});				
			
		
	};
	//05
	public static Function< List<Object>, List<Integer>> func5=(li)->{
		//List<Object>로 받은 파라미터 중에 Integer만 추출해서 리턴하기
		//1 Interger형만 필터링(instanceof)
		//2 재구성(map)
		//3 리스트로 변환(collect)
		return li	.stream()
					.filter((item)->item instanceof Integer)
					.map((item)->(Integer)item)
					.collect(Collectors.toList())
					;
	};
	
	//06
	public static Function< Integer,Integer> func6= func1.andThen(func2);
	//07
	public static Function< Integer,Integer> func7= func2.andThen(func1);
	//08
	public static Function< List<Integer>,Integer> subFunc = (x)->{return x.stream().reduce(0, (sum,x1)->sum+x1);};
	public static Function< List<Object>,Integer> func8 = func5.andThen(subFunc);
	
	//09 							func9.apply(10).apply(20));
	
	public static Function <Integer,Function<Integer,Integer>> func9 = (x)->{
									
		//x == final
		int n1 = 10;
		System.out.println("첫번째 함수 호출! x : " + x);
									
		return (y)->{
		//y not final
		y++;
										
		System.out.println("두번째 함수 호출 y : " + y +" x :"+ x);
		return y+x + n1;
										
		};
	}; 
	
	public static Function<Integer ,Function<Integer,Integer>  > func10 = x-> y->x+y;
	
	public static Function<Integer ,Function<Integer, Function<Integer,Integer> >> func11 = x->y->z->x+y+z;
	
	public static void main(String[] args) {
	
		//01
		System.out.println(func1.apply(10));
		//02
		System.out.println(func2.apply(10));
		//03
		System.out.println(func3.apply( Arrays.asList(10,20,30,40)));
		//04
		System.out.println(func4.apply(Arrays.asList("홍길동",100,20,300,10.5,true)));
		//05 
		System.out.println(func5.apply(Arrays.asList("홍길동",100,20,300,10.5,true)));
		//06
		System.out.println(func6.apply(5));
		//07
		System.out.println(func7.apply(5));		
		//08
		System.out.println(func8.apply(Arrays.asList("홍길동",100,20,300,10.5,true)));	
		
		//09
		System.out.println(func9.apply(10).apply(20));
		
		//11
		System.out.println(func11.apply(10).apply(20).apply(30));
	}
	

}