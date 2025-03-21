package ch33;

import java.util.Arrays;

@FunctionalInterface
interface Functional {
	Integer execute(int... args);
}

class Calc {
	Functional sum; // 합
	Functional sub; // 차
	Functional mul; // 곱
	Functional div; // 나누기

	Calc() {
		// Functional sum 람다식 완성
		// Functional sub 람다식 완성
		// Functional mul 람다식 완성
		// Functional div 람다식 완성

		// 조건
		// sum,sub,mul,div 각각에 람다&스트림함수를 적절히 이용해서 기능 구현
		// 모든 인자를 받을 수 있는 가변인자 처리로 구현
		// 뺆셈,나눗셈은 큰수에서 작은수로 정렬(sorted) 한 다음 누적 감산 처리(reduce)를 함

		sum = (args) -> Arrays.stream(args).sum();

		sub = (args) -> Arrays.stream(args)
							   .boxed()
							   .sorted((a,b)-> b-a)
							   .reduce((a,b) -> a-b)
							   .orElse(0);

		mul=(args)->Arrays.stream(args).reduce(1,(a,b)->a*b);

		div=(args)->Arrays.stream(args)
				 		   .boxed()
				 		   .sorted((a,b)-> b-a)
				 		   .reduce((a,b)->b!=0?a/b:a)
				 		   .orElse(0);

}}

public class C02문제 {

	public static void main(String[] args) {

		Calc calc = new Calc();
		System.out.println("합 :" + calc.sum.execute(10, 20, 30, 40, 50, 60));
		System.out.println("차 :" + calc.sub.execute(1,4,2,9));
		System.out.println("곱 :" + calc.mul.execute(10, 20, 30, 40, 50, 60));
		System.out.println("나눗셈 :" + calc.div.execute(10, 20, 30, 40, 50, 60));
	}

}
