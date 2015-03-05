package factory;

public class Job implements InterfaceJob {

	private String job;
	private int force;
	private int defence;
	private int life;
	
	public Job(String s, int f, int d, int l){
		setJob(s);
		setForce(f);
		setDefence(d);
		setLife(l);
	}

	public String getJob() {
		return job;
	}

	public void setJob(String j) {
		this.job = j;
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

	public void setLife(int life) {
		this.life = life;
	}

}
