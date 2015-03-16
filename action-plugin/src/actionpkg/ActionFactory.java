package actionpkg;

public class ActionFactory {

	int nbAction;
	
	public ActionFactory() {
		nbAction = 3;
	}
	
	public Action[] make() {
		
		Action list[] = new Action[3];
		list[0]=new Passer();
		list[1]=new Manger();
		list[2]=new SeCacher();
		return list;
	}

	public int getNbAction() {
		return nbAction;
	}

	public void setNbAction(int nbAction) {
		this.nbAction = nbAction;
	}
	
}