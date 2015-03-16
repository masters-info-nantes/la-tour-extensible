package factoryCharacter;

import factoryCharacter.Character;
import interfaces.AbstractCharacter;

public class CharacterFactory{
	Character[] person;
	int sizeCharacter;
	
	public CharacterFactory() {
		sizeCharacter = 4;
		person = new Character[sizeCharacter];
		person[0] = new Character("name0",100,100,100);	
		person[1] = new Character("name1",101,101,101);
		person[2] = new Character("name2",102,102,102);
		person[3] = new Character("name3",103,103,103);
	}
	
	public AbstractCharacter make (int i) throws IndexOutOfBoundsException {
		if (i>sizeCharacter || i<0)
			throw new IndexOutOfBoundsException();
	
		AbstractCharacter p = new Character(person[i].getName(), person[i].getForce(), person[i].getDefence(), person[i].getLife());
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
