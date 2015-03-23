package begnion;

import interfaces.AbstractIAMonster;
import interfaces.AbstractMonster;

public class BegnionFactory {
	Begnion[] monster;
	int sizeMonster;
	public AbstractIAMonster difficultee;
	
	public BegnionFactory() {
		sizeMonster = 6;
		monster = new Begnion[sizeMonster];
		monster[0] = new Begnion("Arbok", "/images/ashera.png", 10, 10, 10);	
		monster[1] = new Begnion("Bouftiflore", "/images/black-knight.png", 8, 8, 6);
		monster[2] = new Begnion("Grotadmorv", "/images/izuka.png", 5, 2, 2);
		monster[3] = new Begnion("Team rocket", "/images/lekain.png", 2, 2, 5);
		monster[4] = new Begnion("Smogogo", "/images/olivier.png", 2, 2, 2);
		monster[5] = new Begnion("Spectrum", "/images/sephiran.png", 8, 5, 9);
	}
	
	public AbstractMonster make (int i) throws IndexOutOfBoundsException {
		if (i>sizeMonster || i<0)
			throw new IndexOutOfBoundsException();
		
		AbstractMonster m = new Begnion(monster[i].getNom(), monster[i].getChemin_sprite(), monster[i].getForce(), monster[i].getDefence(), monster[i].getLife());
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
