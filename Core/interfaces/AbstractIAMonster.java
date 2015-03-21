package interfaces;

public abstract class AbstractIAMonster {

	public final static String waitFromMonster = "monster.CREER_DIFFICULTEE_CREATED";
	public final static String sendFromMonster = "monster.CREER_DIFFICULTEE";
	
	public abstract void doAction(AbstractCharacter personnage, AbstractMonster mob);

}
