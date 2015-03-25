package latourextensible.platform;

import java.lang.Thread;

/** Abstract class that must be extends by the main class of a plugin.
 */
public abstract class RunnablePlugin extends Thread {
	/** This method will be call when plugin will be run
	 */
	public abstract void run();
	/** This method will call will be call when plugin will be stop.
	 * Remember to remove all instance of the plugin you have created before, for example unregister all {@code Event} you register in the {@link latourextensible.platform.event.EventManager}.
	 */
	public abstract void onStop();
	
	/** This method could be call to stop execution of the plugin.
	 */
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
