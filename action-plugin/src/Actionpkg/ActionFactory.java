package Actionpkg;

import java.util.ArrayList;

public class ActionFactory {

	int nbAction;
	
	public ActionFactory() {
		nbAction = 3;
	}
	
	public ArrayList<Action> make() {
		
		ArrayList<Action> list = new ArrayList<Action>();
		list.add(new Passer());
		list.add(new Manger());
		list.add(new SeCacher());
		return null;
	}

	public int getNbAction() {
		return nbAction;
	}

	public void setNbAction(int nbAction) {
		this.nbAction = nbAction;
	}
	
}