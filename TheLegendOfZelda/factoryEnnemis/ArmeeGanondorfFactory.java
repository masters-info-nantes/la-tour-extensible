package factoryEnnemis;

import interfaces.AbstractIAMonster;
import interfaces.AbstractMonster;

public class ArmeeGanondorfFactory{	
	ArmeeGanondorf[] monster;
	int sizeMonster;
	public AbstractIAMonster difficultee;
	
	public ArmeeGanondorfFactory() {
		sizeMonster = 5;
		monster = new ArmeeGanondorf[sizeMonster];
		monster[0] = new ArmeeGanondorf("Araignee", "/images/araignee.png", 3, 3, 1);	
		monster[1] = new ArmeeGanondorf("Bokoblin", "/images/bokoblin.png", 1, 1, 1);
		monster[2] = new ArmeeGanondorf("Ganon Beast", "/images/ganon-beast.png", 10, 5, 5);
		monster[3] = new ArmeeGanondorf("Limace", "/images/limace.png", 4, 3, 4);
		monster[4] = new ArmeeGanondorf("Ganondorf", "/images/ganondorf.png", 8, 8, 8);
	}
	
	public AbstractMonster make (int i) throws IndexOutOfBoundsException {
		if (i>sizeMonster || i<0)
			throw new IndexOutOfBoundsException();
		
		AbstractMonster m = new ArmeeGanondorf(monster[i].getNom(), monster[i].getChemin_sprite(), monster[i].getForce(), monster[i].getDefence(), monster[i].getLife());
		m.setIa(difficultee);
		return m;
	}
	
	public AbstractMonster[] getList(){
		return monster;
	}
			
	public int getSize() {
		return sizeMonster;
	}

}
