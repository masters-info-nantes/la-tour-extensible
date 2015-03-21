package factoryRacePokemon;

import java.util.Random;

import interfaces.AbstractRace;

public class RaceFactory implements InterfaceRaceFactory {

	Race[] race;
	int size;
	
	public RaceFactory() {
		size = 4;
		Random random = new Random();
		race = new Race[size];
		race[0] = new Race("Dragon", 5, 3, 1);	
		race[1] = new Race("Souris", 0, 0, 5);
		race[2] = new Race("Indéterminé",Math.abs((random.nextInt())%5),Math.abs((random.nextInt())%5),Math.abs((random.nextInt())%5));
		race[3] = new Race("Oiseau", 2, 1, 5);
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
