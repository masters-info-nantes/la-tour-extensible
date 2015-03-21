package factoryTeamRocket;

import interfaces.AbstractMonster;

public interface InterfaceTeamRocket {
	
	public AbstractMonster make (int i) throws IndexOutOfBoundsException;
			
	public AbstractMonster[] getList();
	public int getSize();

}