package ch35.building;

import ch35.unit.Medic;
import ch35.unit.Unit;

public class MedicGenerator implements UnitGenerator{
	
	@Override
	public Unit gen() {
		return new Medic();
	}

}
