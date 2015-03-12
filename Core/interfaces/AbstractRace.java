package interfaces;

public abstract class AbstractRace {
	
	protected String race;
	protected int force;
	protected int defence;
	protected int life;

	public AbstractRace(String r, int f, int d, int l){
		this.race = r;
		this.force = f;
		this.defence = d;
		this.life = l;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
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