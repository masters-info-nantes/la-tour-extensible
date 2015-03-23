package charactersFE;

import interfaces.AbstractCharacter;

public class FactoryCharacters {

	Characters[] person;
	int sizeCharacter;
	
	public FactoryCharacters() {
		sizeCharacter = 8;
		person = new Characters[sizeCharacter];
		person[0] = new Characters("/images/gatorie.png", "Gatorie", 5, 10, 100);	
		person[1] = new Characters("/images/haar.png", "Haar", 8, 5, 80);
		person[2] = new Characters("/images/ike.png", "Ike", 7, 5, 90);
		person[3] = new Characters("/images/micaiah.png", "Micaiah", 8, 2, 50);
		person[4] = new Characters("/images/shinon.png", "Shinon", 5, 5, 100);
		person[5] = new Characters("/images/soren.png", "Soren", 7, 4, 60);
		person[6] = new Characters("/images/sothe.png", "Sothe", 5, 5, 70);
		person[7] = new Characters("/images/titania.png", "Titania", 9, 3, 90);
	}
	
	public AbstractCharacter make (int i) throws IndexOutOfBoundsException {
		if (i>sizeCharacter || i<0)
			throw new IndexOutOfBoundsException();
	
		AbstractCharacter p = new Characters(person[i].getChemin_sprite(), person[i].getName(), person[i].getForce(), person[i].getDefence(), person[i].getLife());
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
