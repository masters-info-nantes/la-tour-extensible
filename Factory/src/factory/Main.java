package factory;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import latourextensible.platform.storage.SessionStorageManager;

import java.util.*;

public class Main extends RunnablePlugin implements IEventListener{

	MonsterFactory monsterF;
	RaceFactory raceF;
	JobFactory jobF;
	CharacterFactory characterF;

	public void run() {
		
		EventManager.getDefaultInstance().register("core.application.CREER_MONSTRE", this);
		EventManager.getDefaultInstance().register("core.application.CREER_RACE", this);
		EventManager.getDefaultInstance().register("core.application.CREER_JOB", this);
		
		monsterF = new MonsterFactory();
		raceF = new RaceFactory();
		jobF = new JobFactory();
		characterF = new CharacterFactory();
	}

	public void onEvent(Event event) {
		Random random = new Random();
		int i;

		// TODO Auto-generated method stub
		switch (event.getAction())
		{
			case "core.application.CREER_CHARACTER":
				i = (random.nextInt())%characterF.getSize();
				InterfaceCharacter c = characterF.make(i);
				SessionStorageManager.getDefaultInstance().put(event.getExtra("storagekey"),c);
				EventManager.getDefaultInstance().broadcast(new Event("core.application.CREER_CHARACTER_CREATED"));
				break;		
			case "core.application.CREER_MONSTRE":
				i = (random.nextInt())%monsterF.getSize();
				InterfaceMonster m = monsterF.make(i);
				SessionStorageManager.getDefaultInstance().put(event.getExtra("storagekey"),m);
				EventManager.getDefaultInstance().broadcast(new Event("core.application.CREER_MONSTRE_CREATED"));
				break;
			case "core.application.CREER_RACE":
				i = (random.nextInt())%raceF.getSize();
				InterfaceRace r = raceF.make(i);
				SessionStorageManager.getDefaultInstance().put(event.getExtra("storagekey"),r);
				EventManager.getDefaultInstance().broadcast(new Event("core.application.CREER_RACE_CREATED"));
				break;
			case "core.application.CREER_JOB":
				i = (random.nextInt())%jobF.getSize();
				InterfaceJob j = jobF.make(i);
				SessionStorageManager.getDefaultInstance().put(event.getExtra("storagekey"),j);
				EventManager.getDefaultInstance().broadcast(new Event("core.application.CREER_JOB_CREATED"));
				break;
		}
		
	}

}
