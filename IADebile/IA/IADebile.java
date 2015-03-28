package IA;

import interfaces.AbstractCharacter;
import interfaces.AbstractIAMonster;
import interfaces.AbstractMonster;


public class IADebile extends AbstractIAMonster{

	@Override
	public void doAction(AbstractCharacter character, AbstractMonster monstre) {
		System.out.println("AHAHAHAH Je suis un monstre et j'attaque comme un debile !!!");
		int degat = character.getDefence() + character.getRace().getDefence() + character.getJob().getDefence() - (monstre.getForce() + 10);
		if(degat>0){
			if(degat<character.getRace().getLife()){
				character.getRace().setLife(character.getRace().getLife() - degat);
			}
			else{
				degat -= character.getRace().getLife();
				character.getRace().setLife(0);
			}
			
			if(degat<character.getJob().getLife() && degat >0){
				character.getJob().setLife(character.getJob().getLife() - degat);
			}
			else if(degat >0){
				degat -= character.getJob().getLife();
				character.getJob().setLife(0);
			}
			
			if(degat<character.getLife() && degat >0){
				character.setLife(character.getLife() - degat);
			}
			else if(degat >0){
				degat -= character.getLife();
				character.setLife(0);
			}
		}
		
	}


}
