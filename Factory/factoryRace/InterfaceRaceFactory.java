package factoryRace;

import interfaces.AbstractRace;

public interface InterfaceRaceFactory {
	
	public AbstractRace make (String s) throws IndexOutOfBoundsException;
	
	public int getSize();

}