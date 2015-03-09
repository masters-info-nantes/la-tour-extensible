package factoryMonster;

import interfaces.AbstractMonster;

public interface InterfaceMonsterFactory {
	
	public AbstractMonster make (int i) throws IndexOutOfBoundsException;
			
	public int getSize();

}