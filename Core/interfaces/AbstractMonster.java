package interfaces;

public abstract class AbstractMonster {
	
	protected int force;
	protected int defence;
	protected int life;
	
	public final static String waitFromCore = "core.application.CREER_MONSTRE_CREATED";
	public final static String sendFromCore = "core.application.CREER_MONSTRE";
	
	public AbstractMonster(int force, int defence, int life) {
		super();
		this.force = force;
		this.defence = defence;
		this.life = life;
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