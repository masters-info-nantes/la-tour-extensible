package factory;
public class Character implements InterfaceCharacter
{
	private String name;
	private int force;
	private int defence;
	private int life;
	
	public Character(String n, int f, int d, int v)
	{
		name =n;
		force =f;
		defence = d;
		life = v;
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

