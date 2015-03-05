package interface;

public abstract class Action {
	
	private TypeAction type;
	private int value;

	public Action(TypeAction t, int value) {
		this.type = t;
		this.value = value;
	}
	
	public TypeAction getType() {
		return type;
	}
	
	public void setType(TypeAction t) {
		type = t; 
	}
	
	public int getValue() {
		return value; 
	}
	
	public void setValue(int v) {
		value = v;
	}
	
	public void doAction(Character c) {
		if (this.getType()==TypeAction.Attack) {
			System.out.println("Bim! Attaque du monstre");
		}
		else {
			c.setDefence(c.getDefense() + this.value);
		}
	}
	
	// A garder à la fin
	public enum TypeAction {
		Attack,
		Defense; 
	}
}
