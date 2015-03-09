package interfaces;

public abstract class AbstractRace {
	
	protected String race;
	protected int force;
	protected int defence;
	protected int life;

	public abstract String getRace();
	
	public abstract void setRace(String r);
	
	public abstract int getForce();
	
	public abstract void setForce(int force); 

	public abstract int getDefence(); 

	public abstract void setDefence(int defence);
	
	public abstract int getLife();

	public abstract void setLife(int life);
	
}