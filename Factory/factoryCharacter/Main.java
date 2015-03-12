package factoryCharacter;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import latourextensible.platform.storage.SessionStorageManager;
import factoryCharacter.CharacterFactory;
import interfaces.AbstractCharacter;
import interfaces.AbstractJob;
import interfaces.AbstractRace;

import java.util.*;

public class Main extends RunnablePlugin implements IEventListener{

	CharacterFactory characterF;

	public void run() {
		
		EventManager.getDefaultInstance().register("core.application.CREER_CHARACTER", this);
		
		characterF = new CharacterFactory();
	}

	public void onEvent(Event event) {
		Random random = new Random();
		int i;

		// TODO Auto-generated method stub
		if (event.getAction() =="core.application.CREER_CHARACTER"){
			i = (random.nextInt())%characterF.getSize();
			AbstractCharacter c = characterF.make(i);
			Event e = new Event("core.application.CREER_CHARACTER_CREATED");
			e.addExtra("list", characterF.getList());
			EventManager.getDefaultInstance().broadcast(e);
		}
	}

}

