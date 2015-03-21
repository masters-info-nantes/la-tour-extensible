package factoryTeamRocket;

import latourextensible.platform.PluginManager;
import latourextensible.platform.PluginProperty;
import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import factoryTeamRocket.TeamRocketFactory;
import interfaces.AbstractIAMonster;
import interfaces.AbstractMonster;

import java.util.*;

public class Main extends RunnablePlugin implements IEventListener{

	TeamRocketFactory monsterF;


	public void run() {
		
		EventManager.getDefaultInstance().register(AbstractMonster.sendFromCore, this);
		EventManager.getDefaultInstance().register(AbstractMonster.waitFromMonster, this);
		
		monsterF = new TeamRocketFactory();
	}

	public void onEvent(Event event) {
		Random random = new Random();
		int i;

		// TODO Auto-generated method stub
		if (event.getAction() == AbstractMonster.sendFromCore){
			PluginManager pluginMgr = PluginManager.getDefaultInstance();
			try {
				boolean difficulteeRun = pluginMgr.runPlugin((PluginProperty) event.getExtra("IA"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Event demandeIA = new Event(AbstractMonster.sendFromMonster);
			EventManager.getDefaultInstance().broadcast(demandeIA);
			waitEvents();
			pluginMgr.stopPlugin((PluginProperty) event.getExtra("IA"));
			
			i = (random.nextInt())%monsterF.getSize();
			i = Math.abs(i);
			AbstractMonster m = monsterF.make(i);
			Event e = new Event(AbstractMonster.waitFromCore);
			e.addExtra("Monster",m);
			EventManager.getDefaultInstance().broadcast(e);
		}	

		else if(event.getAction() == AbstractMonster.waitFromMonster){
			monsterF.difficultee = (AbstractIAMonster) event.getExtra("IA");
			System.out.println("je recois ma diff:    "+monsterF.difficultee);
		}
	}
	
	private void waitEvents(){
		// TODO Auto-generated method stub
		int nb_secondes = 0;
		System.out.println("j'attend:    "+monsterF.difficultee);

		while(monsterF.difficultee == null && nb_secondes<5){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//je verifie toutes les secondes
			nb_secondes++;
		}
		
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().unregister(AbstractMonster.sendFromCore, this);
		
	}

}


