package factoryJob;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import latourextensible.platform.storage.SessionStorageManager;
import factoryJob.JobFactory;
import interfaces.AbstractJob;

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
			SessionStorageManager.getDefaultInstance().put(event.getExtra("storagekey"),j);
			EventManager.getDefaultInstance().broadcast(new Event("core.application.CREER_JOB_CREATED"));
		}
	}

}

