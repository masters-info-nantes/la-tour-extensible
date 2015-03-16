package interfaces;

public abstract class AbstractCharacter {
	
	protected String name;
	protected int force;
	protected int defence;
	protected int life;
	
	protected AbstractJob job;
	protected AbstractRace race;

	public AbstractJob getJob() {
		return job;
	}

	public void setJob(AbstractJob job) {
		this.job = job;
	}

	public AbstractRace getRace() {
		return race;
	}

	public void setRace(AbstractRace race) {
		this.race = race;
	}

	public final static String waitFromCore = "core.application.CREER_CHARACTER_CREATED";
	public final static String sendFromCore = "core.application.CREER_CHARACTER";
	
	public AbstractCharacter(String name, int force, int defence, int life) {
		super();
		this.name = name;
		this.force = force;
		this.defence = defence;
		this.life = life;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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