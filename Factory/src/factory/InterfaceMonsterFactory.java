package factory;

public interface InterfaceMonsterFactory {
	
	public InterfaceMonster make (int i) throws IndexOutOfBoundsException;
			
	public int getSize();

}