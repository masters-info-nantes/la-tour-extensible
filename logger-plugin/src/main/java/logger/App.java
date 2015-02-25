package logger;

import java.util.Date;

import latourextensible.platform.event.*;

public class App {
	public static void main( String[] args ) {
		Logger l = new Logger();
		l.run();
		
		Event e = new Event(Logger.EVENT_STARTED);
		e.addExtra(Logger.EXTRA_STARTED_DATE,(new Date()).toString());
		EventManager.getDefaultInstance().broadcast(e);
		
		EventManager.getDefaultInstance().broadcast(new Event("je suis un event quelconque"));
	}
}
