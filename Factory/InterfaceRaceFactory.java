package factory;

public interface InterfaceRaceFactory {
	
	public InterfaceRace make (int i) throws IndexOutOfBoundsException;
	
	public int numberRace();

}