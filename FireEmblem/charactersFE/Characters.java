package charactersFE;

import interfaces.AbstractCharacter;

public class Characters extends AbstractCharacter{

	public Characters(String sprite, String name, int force, int defence,
			int life) {
		super(sprite, name, force, defence, life);
		// TODO Auto-generated constructor stub
	}

	public AbstractCharacter copie() {
		// TODO Auto-generated method stub
		return new Characters(this.chemin_sprite, this.name, this.force, this.defence, this.life);
	}
}
