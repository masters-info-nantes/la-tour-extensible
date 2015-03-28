package interfaces;

public abstract class AbstractMonster {
	
	protected int force;
	protected int defence;
	protected int life;
	protected String chemin_sprite;
	protected String nom; 
	protected AbstractIAMonster ia;
	
	public final static String waitFromCore = "core.application.CREER_MONSTRE_CREATED";
	public final static String sendFromCore = "core.application.CREER_MONSTRE";
	
	public final static String waitDifficultee = "monster.RECEVOIR_DIFFICULTEE";
	
	public final static String waitFromMonster = "monster.CREER_DIFFICULTEE_CREATED";
	public final static String sendFromMonster = "monster.CREER_DIFFICULTEE";
	
	public final static String waitLVLUpFromCore = "core.application.LVL_UP";	
	
	public AbstractMonster(String nom, String sprite, int force, int defence, int life) {
		super();
		this.force = force;
		this.defence = defence;
		this.life = life;
		this.nom = nom;
		this.chemin_sprite = sprite;
	}
	
	public AbstractIAMonster getIa() {
		return ia;
	}

	public void setIa(AbstractIAMonster ia) {
		this.ia = ia;
	}
	
	public String getChemin_sprite() {
		return chemin_sprite;
	}

	public void setChemin_sprite(String chemin_sprite) {
		this.chemin_sprite = chemin_sprite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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