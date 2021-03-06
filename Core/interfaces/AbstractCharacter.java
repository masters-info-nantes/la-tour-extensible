package interfaces;

import javax.swing.ImageIcon;

public abstract class AbstractCharacter {
	
	protected String name;
	protected int force;
	protected int defence;
	protected int life;
	protected String chemin_sprite;
	protected AbstractJob job;
	protected AbstractRace race;
	
	public final static String waitFromCore = "core.application.CREER_CHARACTER_CREATED";
	public final static String sendFromCore = "core.application.CREER_CHARACTER";
	
	public AbstractCharacter(String sprite, String name, int force, int defence, int life) {
		super();
		this.name = name;
		this.force = force;
		this.defence = defence;
		this.life = life;
		this.chemin_sprite = sprite;
	}
	
	abstract public AbstractCharacter copie();

	public String getChemin_sprite() {
		return chemin_sprite;
	}

	public void setChemin_sprite(String chemin_sprite) {
		this.chemin_sprite = chemin_sprite;
	}

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