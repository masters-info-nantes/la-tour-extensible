package factoryRaceZelda;

import java.util.Random;

import interfaces.AbstractRace;

public class RaceFactory {

	Race[] race;
	int size;
	
	public RaceFactory() {
		size = 4;
		Random random = new Random();
		race = new Race[size];
		race[0] = new Race("Goron", 5, 3, 1);	
		race[1] = new Race("Hylien", 2, 2, 2);
		race[2] = new Race("Zora", 3, 3, 3);
		race[3] = new Race("Twilis", 2, 1, 1);
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
