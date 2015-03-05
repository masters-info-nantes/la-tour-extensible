package factory;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;

public class Main extends RunnablePlugin implements IEventListener{

	MonsterFactory mf;

	public void run() {
		
		EventManager.getDefaultInstance().register("core.application.CREER_MONSTRE", this);
		EventManager.getDefaultInstance().register("core.application.CREER_RACE", this);
		EventManager.getDefaultInstance().register("core.application.CREER_JOB", this);
		
		mf = new MonsterFactory();
	
	}

	public void onEvent(Event event) {
		// TODO Auto-generated method stub
		switch (event.getAction())
		{
			case "core.application.CREER_MONSTRE":
				InterfaceMonster m = mf.make(1);
				SessionStorqgeManager.getDefaultInstance().put(event.getExtra("storagekey"),m);
				EventManager.getDefaultInstance().broadcast("core.application.CREER_MONSTRE_CREATED");
				break;
			case "core.application.CREER_RACE":
				InterfaceMonster m = mf.make(1);
				SessionStorqgeManager.getDefaultInstance().put(event.getExtra("storagekey"),m);
				EventManager.getDefaultInstance().broadcast("core.application.CREER_RACE_CREATED");
				break;
			case "core.application.CREER_JOB":
				InterfaceMonster m = mf.make(1);
				SessionStorqgeManager.getDefaultInstance().put(event.getExtra("storagekey"),m);
				EventManager.getDefaultInstance().broadcast("core.application.CREER_JOB_CREATED");
				break;
		}
		
	}

}
