package interfaces;

public abstract class AbstractAction {
	
	protected String name;
	
	public final static String waitFromCore = "core.application.ACTION_LIST_CREATED";
	public final static String sendFromCore = "core.application.ACTION_LIST";
	
	public String getName(){
		return name;
	}
		
	public abstract void doAction(AbstractCharacter personnage, AbstractMonster mob);

}
