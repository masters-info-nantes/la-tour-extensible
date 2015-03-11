package factoryRace;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import latourextensible.platform.storage.SessionStorageManager;
import interfaces.AbstractRace;

public class Main extends RunnablePlugin implements IEventListener{

	RaceFactory raceF;

	public void run() {
		
		EventManager.getDefaultInstance().register("core.application.CREER_RACE", this);
		raceF = new RaceFactory();
	}

	public void onEvent(Event event) {

		// TODO Auto-generated method stub
		if  (event.getAction()=="core.application.CREER_RACE")
		{
				AbstractRace r = raceF.make("race1");
				SessionStorageManager.getDefaultInstance().put(event.getExtra("storagekey"),r);
				EventManager.getDefaultInstance().broadcast(new Event("core.application.CREER_RACE_CREATED"));
		}
		
	}

}
