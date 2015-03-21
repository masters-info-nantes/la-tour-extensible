package factoryPokemon;

import interfaces.AbstractCharacter;

public interface InterfacePokemonFactory {

	public abstract AbstractCharacter make (int i) throws IndexOutOfBoundsException;
	
	public AbstractCharacter[] getList();
	public abstract int getSize();
	
}