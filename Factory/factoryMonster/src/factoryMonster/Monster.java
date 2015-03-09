package factoryMonster;

import interfaces.AbstractMonster;

public class Monster extends AbstractMonster {
	private int force;
	private int defence;
	private int life;
	
	public Monster(int f, int d, int v)	{
		force =f;
		defence = d;
		life = v;
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
