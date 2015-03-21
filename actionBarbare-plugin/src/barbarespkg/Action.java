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
		
		int defTemp = 0;
		if (this.getType()==TypeAction.Attack) {
			System.out.println("Bim! Attaque du monstre");
			int attack = this.getValue() + c.getJob().getForce() + c.getRace().getForce();
			m.setLife((m.getLife() + m.getDefence()) - attack);
		}
		else {
			System.out.println("Oulala! Je me protège");
			defTemp =  this.getValue();
			c.setDefence(c.getDefence() + defTemp);
		}
		
		if(m.getLife()>0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			m.getIa().doAction(c, m);
		}
		c.setDefence(c.getDefence() - defTemp);

	}
	
	// A garder à la fin
	public enum TypeAction {
		Attack,
		Defense; 
	}
}
