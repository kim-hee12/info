package ch13;

interface Remocon{
	int MAX_VOL=100;	//public static final 
	int MIN_VOL = 0;	//public static final
	
	void setVolumn(int vol);
	//TV , Radio 각각 메서드 완성시켜주세요
	//MAX_VOL / MIN_VOL 을 적용해서 각각최대볼륨 최소뷸륨제한해주세요 -!
	//구현하는 클래스에서 외부로부터 받는 vol을 저장할 멤버변수(vol)를 지정해주세요
	//vol값이 100을초과할때는 최대볼륨값으로 적용(print : 최대볼륨으로 설정합니다)
	//vol값이 0미만일때는 최소볼륨값으로 적용(print : 최소볼륨으로 설정합니다
	//0<=vol<=100 사이이면 멤버변수 vol에 저장해주시고 현재볼륨을 출력해줍니다(print : 현재볼륨 : n)
	void powerOn();		//abstract function
	void powerOff();	//abstract function
}
interface Browser{
	void SearchURL(String url);
}
class Tv implements Remocon{
	
	private int vol;
	@Override
	public void powerOn() {
		System.out.println("TV 를 켭니다");
	}
	@Override
	public void powerOff() {
		System.out.println("TV 를 끕니다");
	}
	@Override
	public void setVolumn(int vol) {
		if(vol>MAX_VOL) {
			vol=MAX_VOL;
			System.out.println("최대볼륨으로 설정합니다");
		}else if(vol<MIN_VOL) {
			vol=MIN_VOL;
			System.out.println("최소볼륨으로 설정합니다");
		}else {
			this.vol = vol;
			System.out.println("현재 볼륨 : " + this.vol);
		}	
	}
}
class SmartTv extends Tv implements Browser{

	@Override
	public void SearchURL(String url) {
		System.out.println(url + " 로 이동합니다");		
	}

}

class Radio implements Remocon{
	private int vol;
	@Override
	public void powerOn() {
		System.out.println("RADIO 를 켭니다");
		
	}

	@Override
	public void powerOff() {
		System.out.println("RADIO 를 끕니다");
	}

	@Override
	public void setVolumn(int vol) {
		if(vol>MAX_VOL) {
			vol=MAX_VOL;
			System.out.println("최대볼륨으로 설정합니다");
		}else if(vol<MIN_VOL) {
			vol=MIN_VOL;
			System.out.println("최소볼륨으로 설정합니다");
		}else {
			this.vol = vol;
			System.out.println("현재 볼륨 : " + this.vol);
		}	
	}
	
}


public class C03InterFaceMain{

	public static void TurnOn(Remocon controller) {
		controller.powerOn();
	}
	public static void TurnOff(Remocon controller) {
		controller.powerOff();
	}	
	public static void ChangeVolumn(Remocon controller,int vol) {
		controller.setVolumn(vol);
	}
	public static void Internet(Browser browser , String url) {
		browser.SearchURL(url);
	}
	
	public static void main(String[] args) {
		Tv tv1 = new Tv();
		SmartTv smartTv1 = new SmartTv();
		
		Radio radio1 = new Radio();

		TurnOn(tv1);
		TurnOn(smartTv1);
		TurnOn(radio1);
		
		Internet(smartTv1,"www.naver.com");
		ChangeVolumn(tv1,90);
		ChangeVolumn(radio1,101);
		
		TurnOff(tv1);
		TurnOff(radio1);
		
	}

}