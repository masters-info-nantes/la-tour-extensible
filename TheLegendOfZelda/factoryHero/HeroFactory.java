package factoryHero;

import interfaces.AbstractCharacter;

public class HeroFactory{
	Hero[] person;
	int sizeCharacter;
	
	public HeroFactory() {
		sizeCharacter = 5;
		person = new Hero[sizeCharacter];
		person[0] = new Hero("/images/link.png", "Link", 8, 8, 80);	
		person[1] = new Hero("/images/loup.png", "Loup", 10, 6, 100);
		person[2] = new Hero("/images/midona.png", "Midona", 5, 5, 60);
		person[3] = new Hero("/images/zelda.png", "Zelda", 7, 6, 70);
		person[4] = new Hero("/images/darbus.png", "Darbus", 10, 6, 50);
	}
	
	public AbstractCharacter make (int i) throws IndexOutOfBoundsException {
		if (i>sizeCharacter || i<0)
			throw new IndexOutOfBoundsException();
	
		AbstractCharacter p = new Hero(person[i].getChemin_sprite(), person[i].getName(), person[i].getForce(), person[i].getDefence(), person[i].getLife());
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
