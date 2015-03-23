package jobFE;

import interfaces.AbstractJob;
import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.Event;
import latourextensible.platform.event.EventManager;
import latourextensible.platform.event.IEventListener;


public class Main extends RunnablePlugin implements IEventListener{

	JobFEFactory factory;
	
	@Override
	public void onEvent(Event event) {
		// TODO Auto-generated method stub
		if (event.getAction() == AbstractJob.sendFromCore){
			Event e = new Event(AbstractJob.waitFromCore);
			e.addExtra("Job", factory.getList());
			EventManager.getDefaultInstance().broadcast(e);
		}
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().unregister(AbstractJob.sendFromCore, this);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().register(AbstractJob.sendFromCore, this);
		factory = new JobFEFactory();
	}

}
