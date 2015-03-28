package IAM;

import java.util.Random;

import interfaces.AbstractCharacter;
import interfaces.AbstractIAMonster;
import interfaces.AbstractMonster;


public class IAMoyenne extends AbstractIAMonster{

	private int def = 0;
	@Override
	public void doAction(AbstractCharacter character, AbstractMonster monstre) {
		System.out.println("AHAHAHAH Je suis un monstre et j'attaque !!!");
		monstre.setDefence(monstre.getDefence() - def);
		def = 0;

		Random r = new Random();
		int i = r.nextInt()%2;

		if(i == 0){
			attaquer(monstre, character);
		}
		else{
			def = 10;
			monstre.setDefence(monstre.getDefence() + def);
		}
		
		
	}
	
	public void attaquer(AbstractMonster monstre, AbstractCharacter character){
		int degat = character.getDefence() + character.getRace().getDefence() + character.getJob().getDefence() - (monstre.getForce() + 10) + 5;
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
