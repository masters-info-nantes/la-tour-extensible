package factory;

public interface InterfaceJob {
		
	public abstract String getJob();
	
	public abstract void setJob(String j);
	
	public abstract int getForce();
	
	public abstract void setForce(int force); 

	public abstract int getDefence(); 

	public abstract void setDefence(int defence);
	
	public abstract int getLife();

	public abstract void setLife(int life);
}