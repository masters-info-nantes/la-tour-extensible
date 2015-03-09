package factoryMonster;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import latourextensible.platform.storage.SessionStorageManager;
import factoryMonster.MonsterFactory;

import interfaces.AbstractMonster;

import java.util.*;

public class Main extends RunnablePlugin implements IEventListener{

	MonsterFactory monsterF;


	public void run() {
		
		EventManager.getDefaultInstance().register("core.application.CREER_MONSTRE", this);
		
		monsterF = new MonsterFactory();
	}

	public void onEvent(Event event) {
		Random random = new Random();
		int i;

		// TODO Auto-generated method stub
		if (event.getAction()=="core.application.CREER_MONSTRE")
		{
				i = (random.nextInt())%monsterF.getSize();
				AbstractMonster m = monsterF.make(i);
				SessionStorageManager.getDefaultInstance().put(event.getExtra("storagekey"),m);
				EventManager.getDefaultInstance().broadcast(new Event("core.application.CREER_MONSTRE_CREATED"));
		}
		
	}

}


