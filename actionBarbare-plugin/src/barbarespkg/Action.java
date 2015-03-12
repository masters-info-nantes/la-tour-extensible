package barbarespkg;

import interfaces.*;

public abstract class Action extends AbstractAction{
	
	private TypeAction type;
	private int value;
	
	public Action(String n, TypeAction t, int value) {
		this.name = n;
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
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public void doAction(AbstractCharacter c, AbstractMonster m) {
		if (this.getType()==TypeAction.Attack) {
			System.out.println("Bim! Attaque du monstre");
			m.setLife(m.getLife() - this.getValue());
		}
		else {
			System.out.println("Oulala! Je me protège");
			c.setDefence(c.getDefence() + this.value);
		}
	}
	
	// A garder à la fin
	public enum TypeAction {
		Attack,
		Defense; 
	}
}
