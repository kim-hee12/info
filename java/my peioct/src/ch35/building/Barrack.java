package ch35.building;

import java.util.HashMap;
import java.util.Map;

import ch35.unit.Marine;
import ch35.unit.Medic;

public class Barrack extends Building{

	MarineGenerator marine;
	MedicGenerator medic;
	
	public Barrack() {
		marine = new MarineGenerator();
		medic = new MedicGenerator();
	}
	
	// 속이 빈 다이아몬드
	Map<String,UnitGenerator>generator = new HashMap();
	void setGenerator(UnitGenerator gen, String type) {
		generator.put(type,gen);
	}
	public Marine getMarine() {
		if(!is) {
		UnitGenerator marinGen = generator.get("marine");
		return (Marine) marinGen.gen();
		}
		else {
			System.out.println("건물이 파괴되었거나 지어지는 중입니다");
			return null;
		}
	}
	public Medic getMedic() {
		if(!isDestroyed) {
		UnitGenerator medicGen = generator.get("medic");
		return (Medic) medicGen.gen();
		}
		else {
			System.out.println("건물이 파괴되었거나 지어지는 중입니다.");
			return null;
		}
	}
	
	@Override
	void buildStructure() {
		System.out.println("건물짓기 시작");
		while(amor<100||hp<100||sheld<100) {
			try {
				Thread.sleep(300);
				if(amor != 100) amor++;
				if(hp != 100) hp++;
				if(sheld != 100) sheld++;
				System.out.printf("건물짓기중..hp=%d sheld=%d amor=%d\n",hp,sheld,amor);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		setGenerator(new MarineGenerator(),"marine");
		setGenerator(new MedicGenerator(),"medic");
		// 건물 생성 처리
		System.out.println("건물 완성");
	}
}
