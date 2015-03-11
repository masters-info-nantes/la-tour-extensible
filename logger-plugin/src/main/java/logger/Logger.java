package logger;

import java.util.Date;

import latourextensible.platform.RunnablePlugin;
import latourextensible.platform.event.*;

public class Logger extends RunnablePlugin implements IEventListener {
	public static final String EVENT_STARTED = "logger.Logger.STARTED";
	public static final String EXTRA_STARTED_DATE = "logger.Logger.STARTED_DATE";
	
	public void run() {
		System.out.println("Logger Started");
		EventManager.getDefaultInstance().register(EventManager.EVENT_ALL_BROADCAST,this);
	}
	
	public void onEvent(Event event) {
		System.out.println("================ New Event ================");
		System.out.println(event.toString());
		System.out.println("===========================================");
	}
}
