package factoryRace;

import interfaces.AbstractRace;

public class RaceFactory implements InterfaceRaceFactory {

	Race[] race;
	int size;
	
	public RaceFactory() {
		size = 4;
		race = new Race[size];
		race[0] = new Race("race0",100,100,100);	
		race[1] = new Race("race1",101,101,101);
		race[2] = new Race("race2",102,102,102);
		race[3] = new Race("race3",103,103,103);
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
