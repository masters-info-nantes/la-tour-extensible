package interfaces;

public abstract class AbstractJob {
	
	protected String job;
	protected int force;
	protected int defence;
	protected int life;
	
	public final static String waitFromCore = "core.application.CREER_JOB_CREATED";
	public final static String sendFromCore = "core.application.CREER_JOB";
	
	public AbstractJob(String job, int force, int defence, int file) {
		super();
		this.job = job;
		this.force = force;
		this.defence = defence;
		this.life = file;
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

	public int getLife() {
		return life;
	}

	public void setLife(int file) {
		this.life = file;
	}
		
	
}