package loufoquepkg;

public class ActionFactory {
	
	int nbAction;
	
	public ActionFactory() {
		nbAction = 16;
	}
	
	public Action[] make() {
		
		Action list[] = new Action[16];
		list[0]=new Android();
		list[1]=new Apero();
		list[2]=new BrosserDents();
		list[3]=new ChouFleur();
		list[4]=new Creuser();
		list[5]=new Dancer();
		list[6]=new FouetterCheveux();
		list[7]=new JouerTrombone();
		list[8]=new LancerChaussures();
		list[9]=new LancerFleurs();
		list[10]=new Macbook();
		list[11]=new Prier();
		list[12]=new SeDeguiser();
		list[13]=new SucerGlacons();
		list[14]=new Tricoter();
		list[15]=new TrierBoulons();
		
		return list;
	}

	public int getNbAction() {
		return nbAction;
	}

	public void setNbAction(int nbAction) {
		this.nbAction = nbAction;
	}
}
