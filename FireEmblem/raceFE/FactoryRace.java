package raceFE;

import interfaces.AbstractRace;


public class FactoryRace {

	Race[] race;
	int size;
	
	public FactoryRace() {
		size = 5;

		race = new Race[size];
		race[0] = new Race("Laguz loup", 7, 3, 5);	
		race[1] = new Race("Humain", 3, 3, 5);
		race[2] = new Race("Laguz felin", 5, 5, 5);
		race[3] = new Race("Laguz dragon", 8, 8, 10);
		race[4] = new Race("Laguz oiseau", 2, 7, 5);
	}
	
	public AbstractRace make (int i) throws IndexOutOfBoundsException {
		if (i>size || i<0)
			throw new IndexOutOfBoundsException();
	
		AbstractRace r = new Race(race[i].getRace(), race[i].getForce(), race[i].getDefence(), race[i].getLife());
		return r;
	}
				
	public AbstractRace[] getList(){
		return race;
	}
	
	public int getSize() {
		return size;
	}
}
