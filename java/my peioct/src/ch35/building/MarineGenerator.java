package ch35.building;

import ch35.unit.Marine;
import ch35.unit.Unit;

public class MarineGenerator implements UnitGenerator{

	@Override
	public Unit gen() {
		return new Marine();
	}

}