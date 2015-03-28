package factoryEnnemis;

import interfaces.AbstractIAMonster;
import interfaces.AbstractMonster;

public class ArmeeGanondorfFactory{	
	ArmeeGanondorf[] monster;
	int coef;
	int numSalle;
	int sizeMonster;
	public AbstractIAMonster difficultee;
	
	public ArmeeGanondorfFactory() {
		coef = 1;
		numSalle = 1;
		sizeMonster = 5;
		monster = new ArmeeGanondorf[sizeMonster];
		monster[0] = new ArmeeGanondorf("Araignee", "/images/araignee.png", 3, 3, 80);	
		monster[1] = new ArmeeGanondorf("Bokoblin", "/images/bokoblin.png", 1, 1, 50);
		monster[2] = new ArmeeGanondorf("Ganon Beast", "/images/ganon-beast.png", 10, 5, 150);
		monster[3] = new ArmeeGanondorf("Limace", "/images/limace.png", 4, 3, 70);
		monster[4] = new ArmeeGanondorf("Ganondorf", "/images/ganondorf.png", 8, 8, 200);
	}
	
	public AbstractMonster make (int i) throws IndexOutOfBoundsException {
		if (i>sizeMonster || i<0)
			throw new IndexOutOfBoundsException();
		
		AbstractMonster m = new ArmeeGanondorf(monster[i].getNom(), monster[i].getChemin_sprite(), monster[i].getForce() + coef, monster[i].getDefence() + coef, monster[i].getLife() + coef);
		m.setIa(difficultee);
		return m;
	}
	
	public AbstractMonster[] getList(){
		return monster;
	}
			
	public int getSize() {
		return sizeMonster;
	}

	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public int getNumSalle() {
		return numSalle;
	}

	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}

	
}
