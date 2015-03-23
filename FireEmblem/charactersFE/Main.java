package charactersFE;

import interfaces.AbstractCharacter;
import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.Event;
import latourextensible.platform.event.EventManager;
import latourextensible.platform.event.IEventListener;

public class Main  extends RunnablePlugin implements IEventListener{

	FactoryCharacters characterF;

	@Override
	public void onEvent(Event event) {
		// TODO Auto-generated method stub
		if (event.getAction() == AbstractCharacter.sendFromCore){
			Event e = new Event(AbstractCharacter.waitFromCore);
			e.addExtra("Character", characterF.getList());
			EventManager.getDefaultInstance().broadcast(e);
		}
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().unregister(AbstractCharacter.sendFromCore,this);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().register(AbstractCharacter.sendFromCore,this);
		
		characterF = new FactoryCharacters();
	}

}
