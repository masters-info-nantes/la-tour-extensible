package factoryTeamRocket;

import interfaces.AbstractIAMonster;
import interfaces.AbstractMonster;

public class TeamRocketFactory implements InterfaceTeamRocket {	
	TeamRocket[] monster;
	int sizeMonster;
	public AbstractIAMonster difficultee;
	
	public TeamRocketFactory() {
		sizeMonster = 6;
		monster = new TeamRocket[sizeMonster];
		monster[0] = new TeamRocket("Arbok", "/images/arbok.png", 3, 2, 10);	
		monster[1] = new TeamRocket("Bouftiflore", "/images/bouftiflore.png", 4, 4, 15);
		monster[2] = new TeamRocket("Grotadmorv", "/images/grotadmorv.png", 2, 2, 5);
		monster[3] = new TeamRocket("Team rocket", "/images/rocket.png", 6, 6, 20);
		monster[4] = new TeamRocket("Smogogo", "/images/smogogo.png", 2, 2, 5);
		monster[5] = new TeamRocket("Spectrum", "/images/spectrum.png", 3, 3, 15);
	}
	
	public AbstractMonster make (int i) throws IndexOutOfBoundsException {
		if (i>sizeMonster || i<0)
			throw new IndexOutOfBoundsException();
		
		AbstractMonster m = new TeamRocket(monster[i].getNom(), monster[i].getChemin_sprite(), monster[i].getForce(), monster[i].getDefence(), monster[i].getLife());
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
