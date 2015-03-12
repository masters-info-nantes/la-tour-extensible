package loufoquepkg;

import latourextensible.platform.Event;
import latourextensible.platform.EventManager;
import latourextensible.platform.IEventListener;
import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.storage.SessionStorageManager;

public class App extends RunnablePlugin implements IEventListener {

	ActionFactory myFactory;
	public void run() {
		EventManager.getDefaultInstance().register("core.application.ACTION_LIST", this);
		myFactory = new ActionFactory();
	}

	@Override
	public void onEvent(Event event) {
		if(event.getAction().equals("core.application.ACTION_LIST")) {
			SessionStorageManager.getDefaultInstance().put(event.getExtra("storagekey"), myFactory.make());
		}
	}

}
