package factoryPokemon;

import factoryPokemon.Pokemon;
import interfaces.AbstractCharacter;

public class PokemonFactory{
	Pokemon[] person;
	int sizeCharacter;
	
	public PokemonFactory() {
		sizeCharacter = 9;
		person = new Pokemon[sizeCharacter];
		person[0] = new Pokemon("/images/craboss.png", "Craboss", 10, 10, 100);	
		person[1] = new Pokemon("/images/dracaufeu.png", "Dracaufeu", 8, 5, 80);
		person[2] = new Pokemon("/images/florizarre.png", "Florizarre", 7, 5, 80);
		person[3] = new Pokemon("/images/onix.png", "Onix", 8, 10, 90);
		person[4] = new Pokemon("/images/pikachu.png", "Pikachu", 5, 5, 60);
		person[5] = new Pokemon("/images/roucarnage.png", "Roucarnage", 5, 4, 60);
		person[6] = new Pokemon("/images/stari.png", "Stari", 5, 5, 50);
		person[7] = new Pokemon("/images/togepi.png", "Togepi", 3, 3, 30);
		person[8] = new Pokemon("/images/tortank.png", "Tortank", 8, 8, 80);
	}
	
	public AbstractCharacter make (int i) throws IndexOutOfBoundsException {
		if (i>sizeCharacter || i<0)
			throw new IndexOutOfBoundsException();
	
		AbstractCharacter p = new Pokemon(person[i].getChemin_sprite(), person[i].getName(), person[i].getForce(), person[i].getDefence(), person[i].getLife());
		p = person[i];
		return p;
	}
			
	public AbstractCharacter[] getList(){
		return person;
	}
	
	public int getSize() {
		return sizeCharacter;
	}
	
}
