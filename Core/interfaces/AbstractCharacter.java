package interfaces;

public abstract class AbstractCharacter {
	
	protected String name;
	protected int force;
	protected int defence;
	protected int life;
	
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