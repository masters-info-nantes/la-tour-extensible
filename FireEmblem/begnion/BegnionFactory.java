package begnion;

import interfaces.AbstractIAMonster;
import interfaces.AbstractMonster;

public class BegnionFactory {
	Begnion[] monster;
	int sizeMonster;
	int coef;
	int numSalle;
	public AbstractIAMonster difficultee;
	
	public BegnionFactory() {
		sizeMonster = 6;
		coef = 1;
		numSalle = 1;
		monster = new Begnion[sizeMonster];
		monster[0] = new Begnion("Ashera", "/images/ashera.png", 10, 10, 200);	
		monster[1] = new Begnion("Black knight", "/images/black-knight.png", 8, 8, 150);
		monster[2] = new Begnion("Izuka", "/images/izuka.png", 5, 2, 80);
		monster[3] = new Begnion("Lekain", "/images/lekain.png", 2, 2, 80);
		monster[4] = new Begnion("Olivier", "/images/olivier.png", 2, 2, 60);
		monster[5] = new Begnion("Sephiran", "/images/sephiran.png", 8, 5, 100);
	}
	
	public AbstractMonster make (int i) throws IndexOutOfBoundsException {
		if (i>sizeMonster || i<0)
			throw new IndexOutOfBoundsException();
		
		AbstractMonster m = new Begnion(monster[i].getNom(), monster[i].getChemin_sprite(), monster[i].getForce() + coef, monster[i].getDefence() + coef, monster[i].getLife() + coef);
		m.setIa(difficultee);
		return m;
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

	public AbstractIAMonster getDifficultee() {
		return difficultee;
	}

	public void setDifficultee(AbstractIAMonster difficultee) {
		this.difficultee = difficultee;
	}
	
	public AbstractMonster[] getList(){
		return monster;
	}
			
	public int getSize() {
		return sizeMonster;
	}

}
