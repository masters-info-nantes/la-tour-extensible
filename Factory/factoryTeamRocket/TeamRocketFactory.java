package factoryTeamRocket;

import interfaces.AbstractIAMonster;
import interfaces.AbstractMonster;

public class TeamRocketFactory implements InterfaceTeamRocket {	
	TeamRocket[] monster;
	int coef;
	int numSalle;
	int sizeMonster;
	public AbstractIAMonster difficultee;
	
	public int getNumSalle() {
		return numSalle;
	}

	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}

	public TeamRocketFactory() {
		coef = 1;
		numSalle = 1;
		sizeMonster = 6;
		monster = new TeamRocket[sizeMonster];
		monster[0] = new TeamRocket("Arbok", "/images/arbok.png", 3, 2, 100);	
		monster[1] = new TeamRocket("Bouftiflore", "/images/bouftiflore.png", 4, 4, 150);
		monster[2] = new TeamRocket("Grotadmorv", "/images/grotadmorv.png", 2, 2, 80);
		monster[3] = new TeamRocket("Team rocket", "/images/rocket.png", 6, 6, 200);
		monster[4] = new TeamRocket("Smogogo", "/images/smogogo.png", 2, 2, 80);
		monster[5] = new TeamRocket("Spectrum", "/images/spectrum.png", 3, 3, 90);
	}
	
	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public AbstractMonster make (int i) throws IndexOutOfBoundsException {
		if (i>sizeMonster || i<0)
			throw new IndexOutOfBoundsException();
		
		AbstractMonster m = new TeamRocket(monster[i].getNom(), monster[i].getChemin_sprite(), monster[i].getForce() + coef, monster[i].getDefence() + coef, monster[i].getLife() + coef);
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
