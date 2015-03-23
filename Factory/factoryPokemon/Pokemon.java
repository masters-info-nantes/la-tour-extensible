package factoryPokemon;

import interfaces.AbstractCharacter;

public class Pokemon extends AbstractCharacter
{
	
	public Pokemon(String s, String n, int f, int d, int v)
	{
		super(s, n,f,d,v);
	}

	@Override
	public AbstractCharacter copie() {
		// TODO Auto-generated method stub
		return new Pokemon(this.chemin_sprite, this.name, this.force, this.defence, this.life);
	}	
}

