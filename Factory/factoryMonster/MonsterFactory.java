package factoryMonster;

import interfaces.AbstractMonster;

public class MonsterFactory implements InterfaceMonsterFactory {	
	Monster[] monster;
	int sizeMonster;
	
	public MonsterFactory() {
		sizeMonster = 4;
		monster = new Monster[sizeMonster];
		monster[0] = new Monster(100,100,100);	
		monster[1] = new Monster(101,101,101);
		monster[2] = new Monster(102,102,102);
		monster[3] = new Monster(103,103,103);
	}
	
	public AbstractMonster make (int i) throws IndexOutOfBoundsException {
		if (i>sizeMonster || i<0)
			throw new IndexOutOfBoundsException();
	
		AbstractMonster m = new Monster(monster[i].getForce(), monster[i].getDefence(), monster[i].getLife());
		return m;
	}
	
	public AbstractMonster[] getList(){
		return monster;
	}
			
	public int getSize() {
		return sizeMonster;
	}

}
