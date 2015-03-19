package barbarespkg;

import interfaces.AbstractAction;
import latourextensible.platform.event.*;
import latourextensible.platform.RunnablePlugin;

public class App extends RunnablePlugin implements IEventListener {

	ActionFactory myFactory;
	public void run() {
		EventManager.getDefaultInstance().register(AbstractAction.sendFromCore, this);
		myFactory = new ActionFactory();
	}

	@Override
	public void onEvent(Event event) {
		if(event.getAction().equals(AbstractAction.sendFromCore)) {
			Event envoiAction = new Event(AbstractAction.waitFromCore);
			envoiAction.addExtra("Action", myFactory.make());
			EventManager.getDefaultInstance().broadcast(envoiAction);
		}
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().unregister(AbstractAction.sendFromCore, this);
	}

}
