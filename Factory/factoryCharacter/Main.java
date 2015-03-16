package factoryCharacter;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import factoryCharacter.CharacterFactory;
import interfaces.AbstractCharacter;

public class Main extends RunnablePlugin implements IEventListener{

	CharacterFactory characterF;

	public void run() {
		
		EventManager.getDefaultInstance().register(AbstractCharacter.sendFromCore,this);
		
		characterF = new CharacterFactory();
	}

	public void onEvent(Event event) {

		// TODO Auto-generated method stub
		if (event.getAction() == AbstractCharacter.sendFromCore){
			Event e = new Event(AbstractCharacter.waitFromCore);
			e.addExtra("Character", characterF.getList());
			EventManager.getDefaultInstance().broadcast(e);
		}
	}

}

