package interfaces;

public abstract class AbstractAction {
	
	protected String name;
	
	public abstract String getName();
	
	public abstract void setName(String n);
	
	public abstract void doAction(AbstractCharacter personnage, AbstractMonster mob);

}
