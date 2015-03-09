package interfaces;

public abstract class AbstractAction {
	
	protected String name;
	
	public String getName(){
		return name;
	}
		
	public abstract void doAction(AbstractCharacter personnage, AbstractMonster mob);

}
