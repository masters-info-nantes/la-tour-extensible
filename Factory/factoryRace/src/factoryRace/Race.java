package factoryRace;

import interfaces.AbstractRace;

public class Race extends AbstractRace {
	
	private String race;
	private int force;
	private int defence;
	private int life;
	
	public Race(String s, int f, int d, int l){
		setRace(s);
		setForce(f);
		setDefence(d);
		setLife(l);
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
