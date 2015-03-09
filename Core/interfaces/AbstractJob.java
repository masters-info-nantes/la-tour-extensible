package interfaces;

public abstract class AbstractJob {
	
	protected String job;
	protected int force;
	protected int defence;
	protected int file;
		
	public abstract String getJob();
	
	public abstract void setJob(String j);
	
	public abstract int getForce();
	
	public abstract void setForce(int force); 

	public abstract int getDefence(); 

	public abstract void setDefence(int defence);
	
	public abstract int getLife();

	public abstract void setLife(int life);
}