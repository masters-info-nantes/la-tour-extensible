package factoryPokemon;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;
import factoryPokemon.PokemonFactory;
import interfaces.AbstractCharacter;

public class Main extends RunnablePlugin implements IEventListener{

	PokemonFactory characterF;

	public void run() {
		
		EventManager.getDefaultInstance().register(AbstractCharacter.sendFromCore,this);
		
		characterF = new PokemonFactory();
	}

	public void onEvent(Event event) {

		// TODO Auto-generated method stub
		if (event.getAction() == AbstractCharacter.sendFromCore){
			Event e = new Event(AbstractCharacter.waitFromCore);
			e.addExtra("Character", characterF.getList());
			EventManager.getDefaultInstance().broadcast(e);
		}
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		EventManager.getDefaultInstance().unregister(AbstractCharacter.sendFromCore,this);
	}

}

