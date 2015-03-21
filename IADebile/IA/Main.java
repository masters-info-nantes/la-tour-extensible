package IA;

import interfaces.AbstractAction;
import interfaces.AbstractIAMonster;
import interfaces.AbstractMonster;
import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.Event;
import latourextensible.platform.event.EventManager;
import latourextensible.platform.event.IEventListener;

public class Main extends RunnablePlugin implements IEventListener {

	@Override
	public void onEvent(Event event) {
		if (event.getAction() == AbstractMonster.sendFromMonster){
			Event envoieIA = new Event(AbstractMonster.waitFromMonster);
			AbstractIAMonster ia = new IADebile();
			envoieIA.addExtra("IA", ia);
			EventManager.getDefaultInstance().broadcast(envoieIA);

		
		}
	}

	@Override
	public void onStop() {
		
	}

	@Override
	public void run() {
		EventManager.getDefaultInstance().register(AbstractMonster.sendFromMonster, this);

	}

}
