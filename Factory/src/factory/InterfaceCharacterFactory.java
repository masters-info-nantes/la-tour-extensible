package factory;

public interface InterfaceCharacterFactory {

	public abstract InterfaceCharacter make (int i) throws IndexOutOfBoundsException;
	
	public abstract int getSize();
	
}