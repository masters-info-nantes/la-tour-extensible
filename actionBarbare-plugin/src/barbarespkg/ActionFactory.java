package barbarespkg;

public class ActionFactory {

	int nbAction;
	
	public ActionFactory() {
		nbAction = 8;
	}
	
	public Action[] make() {
		
		Action list[] = new Action[8];
		list[0]=new ArracherYeux();
		list[1]=new BatteCloutee();
		list[2]=new Charge();
		list[3]=new CoupDeBotte();
		list[4]=new CoupDePoing();
		list[5]=new Decapitation();
		list[6]=new Emasculation();
		list[7]=new Raaah();
		
		return list;
	}

	public int getNbAction() {
		return nbAction;
	}

	public void setNbAction(int nbAction) {
		this.nbAction = nbAction;
	}
	
}