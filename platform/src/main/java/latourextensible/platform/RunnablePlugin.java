package latourextensible.platform;

import java.lang.Thread;

public abstract class RunnablePlugin extends Thread {
	public abstract void run();
	public abstract void onStop();
	
	public final void end() {
		this.onStop();
		switch(this.getState()) {
		// running or similar states
		case RUNNABLE:
		case BLOCKED:
		case WAITING:
		case TIMED_WAITING:
			super.stop();
			break;
		// not running
		case NEW:
		case TERMINATED:
			break;
		}
	}
}
