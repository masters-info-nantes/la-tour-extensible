package factoryMonster;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import factoryMonster.MonsterFactory;
import interfaces.AbstractMonster;

import java.util.*;

public class Main extends RunnablePlugin implements IEventListener{

	MonsterFactory monsterF;


	public void run() {
		
		EventManager.getDefaultInstance().register(AbstractMonster.sendFromCore, this);
		
		monsterF = new MonsterFactory();
	}

	public void onEvent(Event event) {
		Random random = new Random();
		int i;

		// TODO Auto-generated method stub
		if (event.getAction() == AbstractMonster.sendFromCore)
		{
				i = (random.nextInt())%monsterF.getSize();
				AbstractMonster m = monsterF.make(i);
				Event e = new Event(AbstractMonster.waitFromCore);
				e.addExtra("Monster",m);
				EventManager.getDefaultInstance().broadcast(e);
		}
		
	}

}


