package factoryRace;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import factoryRace.RaceFactory;
import interfaces.AbstractRace;


public class Main extends RunnablePlugin implements IEventListener{

	RaceFactory raceF;

	public void run() {
		
		EventManager.getDefaultInstance().register(AbstractRace.sendFromCore, this);
		
		raceF = new RaceFactory();
	}

	public void onEvent(Event event) {

		// TODO Auto-generated method stub
		if (event.getAction() == AbstractRace.sendFromCore){
			Event e = new Event(AbstractRace.waitFromCore);
			e.addExtra("Race", raceF.getList());
			EventManager.getDefaultInstance().broadcast(e);
		}
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().unregister(AbstractRace.sendFromCore, this);
		
	}

}

