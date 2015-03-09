package interfaces;

public abstract class AbstractCharacter {
	
	protected String name;
	protected int force;
	protected int defence;
	protected int life;
	
	public abstract String getName();
	
	public abstract void setName(String name);
	
	public abstract int getForce();
	
	public abstract void setForce(int force); 

	public abstract int getDefence(); 

	public abstract void setDefence(int defence);
	
	public abstract int getLife();

	public abstract void setLife(int life);
	
}