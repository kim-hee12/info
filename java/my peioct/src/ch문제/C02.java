package ch문제;

import ch문제.Buyer;
import ch문제.Seller;

class Buyer{
	private int myMoney;
	private int appleCnt;

	public Buyer(int myMoney,int appleCnt) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
	}
	@Override
	public String toString() {
		return "구매자 [보유금액=" + myMoney + "원, 사과개수=" + appleCnt + "개]";
	}
	public void payment(Seller seller, int money,int apple) {
	        myMoney -= money;	        
	        int apples = seller.receive(money,apple);
	        appleCnt += apples; 
	}	
}
class Seller{
	private int myMoney;
	private int appleCnt;
	private int price;
	
	public Seller(int myMoney,int appleCnt,int price) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
		this.price = price;
	}

	@Override
	public String toString() {
		return "판매자 [보유금액=" + myMoney + "원, 사과개수=" + appleCnt + "개, 개당가격=" + price + "원]";
	}
	
	public int receive(int money,int apple) {
		 myMoney+= money;
		 appleCnt-=apple; 
		 int numOfApples = money / price;
		 
		return apple;
	}
	
	
}
public class C02 {

	public static void main(String[] args) {
		
		Seller 사과장수 = new Seller(10000,100,1000);
		
		Buyer 홍길동 = new Buyer(10000,0);
		Buyer 철수 = new Buyer(5000,0);
		
		홍길동.payment(사과장수, 5000,1);
		철수.payment(사과장수, 2000,1);
		
		System.out.println(홍길동);System.out.println("-----");
		System.out.println(철수);System.out.println("-----");
		System.out.println(사과장수);
		
	}

}