package factoryJobPokemon;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import factoryJobPokemon.JobFactory;
import interfaces.AbstractJob;

public class Main extends RunnablePlugin implements IEventListener{

	JobFactory jobF;

	public void run() {
		
		EventManager.getDefaultInstance().register(AbstractJob.sendFromCore, this);
		
		jobF = new JobFactory();
	}

	public void onEvent(Event event) {

		// TODO Auto-generated method stub
		if (event.getAction() == AbstractJob.sendFromCore){
			Event e = new Event(AbstractJob.waitFromCore);
			e.addExtra("Job", jobF.getList());
			EventManager.getDefaultInstance().broadcast(e);
		}
	}

	public void onStop() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().unregister(AbstractJob.sendFromCore, this);
	}

}

