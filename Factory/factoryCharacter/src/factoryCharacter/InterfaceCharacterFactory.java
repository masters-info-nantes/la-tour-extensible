package factoryCharacter;

import interfaces.AbstractCharacter;

public interface InterfaceCharacterFactory {

	public abstract AbstractCharacter make (int i) throws IndexOutOfBoundsException;
	
	public abstract int getSize();
	
}