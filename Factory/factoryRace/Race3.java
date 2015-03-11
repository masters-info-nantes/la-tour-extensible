package factoryRace;

import interfaces.AbstractRace;

public class Race3 extends AbstractRace {
	
	private String race;
	private int force;
	private int defence;
	private int life;
	
	public Race3(){
		setRace("race3");
		setForce(100);
		setDefence(100);
		setLife(100);
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
