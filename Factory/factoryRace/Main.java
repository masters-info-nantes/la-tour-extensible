package factoryRace;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import latourextensible.platform.storage.SessionStorageManager;
import factoryRace.RaceFactory;
import interfaces.AbstractRace;

import java.util.*;

public class Main extends RunnablePlugin implements IEventListener{

	RaceFactory raceF;

	public void run() {
		
		EventManager.getDefaultInstance().register("core.application.CREER_JOB", this);
		
		raceF = new RaceFactory();
	}

	public void onEvent(Event event) {
		Random random = new Random();
		int i;

		// TODO Auto-generated method stub
		if (event.getAction() =="core.application.CREER_CHARACTER"){
			i = (random.nextInt())%raceF.getSize();
			AbstractRace r = raceF.make(i);
			SessionStorageManager.getDefaultInstance().put(event.getExtra("storagekey"),r);
			EventManager.getDefaultInstance().broadcast(new Event("core.application.CREER_JOB_CREATED"));
		}
	}

}

