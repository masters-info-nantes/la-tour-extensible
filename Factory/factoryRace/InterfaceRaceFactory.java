package factoryRace;

import interfaces.AbstractRace;

public interface InterfaceRaceFactory {
	
	public AbstractRace make (int i) throws IndexOutOfBoundsException;
	
	public int getSize();

}