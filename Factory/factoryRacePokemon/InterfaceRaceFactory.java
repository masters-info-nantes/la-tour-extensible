package factoryRacePokemon;

import interfaces.AbstractRace;

public interface InterfaceRaceFactory {
	
	public AbstractRace make (int i) throws IndexOutOfBoundsException;
	
	public AbstractRace[] getList();
	public int getSize();

}