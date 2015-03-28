package begnion;

import java.util.Random;

import interfaces.AbstractIAMonster;
import interfaces.AbstractMonster;
import latourextensible.platform.PluginManager;
import latourextensible.platform.PluginProperty;
import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.Event;
import latourextensible.platform.event.EventManager;
import latourextensible.platform.event.IEventListener;

public class Main extends RunnablePlugin implements IEventListener{

	BegnionFactory begnionF;
	@Override
	public void onEvent(Event event) {
		// TODO Auto-generated method stub
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
			
			i = (random.nextInt())%begnionF.getSize();
			i = Math.abs(i);
			AbstractMonster m = begnionF.make(i);
			Event e = new Event(AbstractMonster.waitFromCore);
			e.addExtra("Monster",m);
			EventManager.getDefaultInstance().broadcast(e);
		}	

		else if(event.getAction() == AbstractMonster.waitFromMonster){
			begnionF.difficultee = (AbstractIAMonster) event.getExtra("IA");
			System.out.println("je recois ma diff:    "+begnionF.difficultee);
		}
		
		else if(event.getAction() == AbstractMonster.waitLVLUpFromCore){
			
			this.begnionF.setNumSalle(this.begnionF.getNumSalle() + 1);
			
			if(this.begnionF.getNumSalle()%2 == 0){
				this.begnionF.setCoef(this.begnionF.getCoef() + 1);
			}
		}
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().unregister(AbstractMonster.sendFromCore, this);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().register(AbstractMonster.sendFromCore, this);
		EventManager.getDefaultInstance().register(AbstractMonster.waitFromMonster, this);
		
		begnionF = new BegnionFactory();
	}

	private void waitEvents(){
		// TODO Auto-generated method stub
		int nb_secondes = 0;

		while(begnionF.difficultee == null && nb_secondes<5){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//je verifie toutes les secondes
			nb_secondes++;
		}
		
	}
}
