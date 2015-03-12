package interfaces;

public abstract class AbstractJob {
	
	protected String job;
	protected int force;
	protected int defence;
	protected int file;
	
	public AbstractJob(String job, int force, int defence, int file) {
		super();
		this.job = job;
		this.force = force;
		this.defence = defence;
		this.file = file;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getFile() {
		return file;
	}

	public void setFile(int file) {
		this.file = file;
	}
		
	
}