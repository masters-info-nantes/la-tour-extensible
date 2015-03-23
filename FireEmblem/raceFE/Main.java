package raceFE;

import interfaces.AbstractRace;
import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.Event;
import latourextensible.platform.event.EventManager;
import latourextensible.platform.event.IEventListener;

public class Main extends RunnablePlugin implements IEventListener{

	FactoryRace raceF;

	@Override
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().register(AbstractRace.sendFromCore, this);
		
		raceF = new FactoryRace();
	}

}
