package latourextensible.platform;

import java.util.ArrayList;
import java.util.HashMap;

/** {@code EventManager} will manage distribution of {@code Event} signal.
 *
 * Send an {@code Event} will send it to only one object, while broadcast an {@see latourextensible.platform.Event} will send it to all object registered to receive this kind of {@code Event}.
 * It's not necessary to register an object to send an {@code Event} to it. It's necessary to register an object only for broadcast {@code Event}
 *
 * Note: "listener" is an object instantiate from class which implement the {@see latourextensible.platform.IEventListener} interface.
 */
public class EventManager {

	private static EventManager instance = null;
	private HashMap<String,ArrayList<IEventListener>> listeners;

	private EventManager() {
		this.listeners = new HashMap<String,ArrayList<IEventListener>>();
	}

	/** Gets the default instance of {@code EventManager}
	 * @return The default instance of {@code EventManager}
	 */
	public static EventManager getDefaultInstance() {
		if(EventManager.instance == null)
			EventManager.instance = new EventManager();
		return EventManager.instance;
	}

	/** Registers an object to receive broadcast event for one {@code Event} action
	 * @param action The action of wanted {@code Event}
	 * @param o Listener you wanted to register
	 */
	public void register(String action, IEventListener o) {
		ArrayList<IEventListener> list = this.listeners.get(action);
		if(list == null) {
			list = new ArrayList<IEventListener>();
			this.listeners.put(action, list);
		}
		list.add(o);
	}

	/** Sends an {@code Event} to specify object
	 * @param recipient The listener to which you want to send the {@code Event}
	 * @param e The {@code Event} you wanted to send
	 */
	public void send(IEventListener recipient, Event e) {
		recipient.onEvent(e);
	}

	/** Broadcast an {@code Event} to all corresponding registered listeners
	 * @param e The {@code Event} you wanted to send
	 */
	public void broadcast(Event e) {
		ArrayList<IEventListener> recipients = this.listeners.get(e.getAction());
		if(recipients != null) {
			for(IEventListener r : recipients) {
				send(r,e);
			}
		}
	}

	/** Returns a string containing a concise, human-readable description of this {@code EventManager}.
	 * @return a printable representation of this object.
	 */
	public String toString() {
		String ret = "REGISTERED = [";
		for(String k : this.listeners.keySet()) {
			ret += "\n\t\""+k+"\" : "+this.listeners.get(k).size();
		}
		return ret+"]";
	}
}
