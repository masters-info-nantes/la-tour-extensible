package factoryJob;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import latourextensible.platform.storage.SessionStorageManager;
import factoryJob.JobFactory;
import interfaces.AbstractJob;
import interfaces.AbstractMonster;

import java.util.*;

public class Main extends RunnablePlugin implements IEventListener{

	JobFactory jobF;

	public void run() {
		
		EventManager.getDefaultInstance().register("core.application.CREER_JOB", this);
		
		jobF = new JobFactory();
	}

	public void onEvent(Event event) {
		Random random = new Random();
		int i;

		// TODO Auto-generated method stub
		if (event.getAction() =="core.application.CREER_CHARACTER"){
			i = (random.nextInt())%jobF.getSize();
			AbstractJob j = jobF.make(i);
			Event e = new Event("core.application.CREER_JOB_CREATED");
			e.addExtra("list", jobF.getList());
			EventManager.getDefaultInstance().broadcast(e);
		}
	}

}

