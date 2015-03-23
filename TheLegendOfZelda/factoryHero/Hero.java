package factoryHero;

import interfaces.AbstractCharacter;

public class Hero extends AbstractCharacter
{
	
	public Hero(String s, String n, int f, int d, int v)
	{
		super(s, n,f,d,v);
	}
	
	public AbstractCharacter copie() {
		// TODO Auto-generated method stub
		return new Hero(this.chemin_sprite, this.name, this.force, this.defence, this.life);
	}
}

