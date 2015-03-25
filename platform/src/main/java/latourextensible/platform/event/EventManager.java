package latourextensible.platform.event;

import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/** {@code EventManager} will manage distribution of {@code Event} signal.
 *
 * Send an {@code Event} will send it to only one object, while broadcast an {@link latourextensible.platform.event.Event} will send it to all object registered to receive this kind of {@code Event}.
 * It's not necessary to register an object to send an {@code Event} to it. It's necessary to register an object only for broadcast {@code Event}
 *
 * Note: "listener" is an object instantiate from class which implement the {@link latourextensible.platform.event.IEventListener} interface.
 */
public class EventManager {
	/** Constant event action name for broadcast event
	 * This event is send automatically after sending any broadcast event
	 */
	public static final String EVENT_ALL_BROADCAST = "latourextensible.platform.EventManager.ALL_BROADCAST";
	/** Constant extra event name for indicate original event action name
	 */
	public static final String EXTRA_BROADCAST_EVENT_NAME = "latourextensible.platform.EventManager.BROADCAST_EVENT_NAME";
	
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

	/** Registers an object to receive broadcast event for one {@code Event}'s action
	 * @param action The action of wanted {@code Event}
	 * @param o Listener you wanted to register
	 */
	public synchronized void register(String action, IEventListener o) {
		ArrayList<IEventListener> list = this.listeners.get(action);
		if(list == null) {
			list = new ArrayList<IEventListener>();
			this.listeners.put(action, list);
		}
		list.add(o);
	}

	/** Unregisters an object that receive broadcast event for one {@code Event}'s action
	 * @param action The action of wanted {@code Event}
	 * @param o Listener you wanted to unregister
	 * 
	 * @return {@code true} if listener was unregistered, {@code false} otherwise.
	 */
	public synchronized boolean unregister(String action, IEventListener o) {
		ArrayList<IEventListener> list = this.listeners.get(action);
		if(list == null) {
			return false;
		}
		if(list.remove(o)) {
			return true;
		}
		return false;
	}
	
	/** Unregisters an object that receive broadcast event for all {@code Event}'s actions
	 * Note: Prefer usage of {@link #unregister(String, IEventListener) unregister(String, IEventListener)}, for performance reasons.
	 * @param o Listener you wanted to unregister
	 * 
	 * @return List of action for which listener was unregistered.
	 */
	public synchronized List<String> unregister(IEventListener o) {
		List<String> list = new ArrayList<String>();
		for(String action : this.listeners.keySet()) {
			if(this.listeners.get(action).contains(o)) {
				if(this.unregister(action,o)) {
					list.add(action);
				}
			}
		}
		return list;
	}
	
	/** Sends an {@code Event} to specify object
	 * @param recipient The listener to which you want to send the {@code Event}
	 * @param e The {@code Event} you wanted to send
	 */
	public synchronized void send(IEventListener recipient, Event e) {
		recipient.onEvent(e);
	}

	/** Broadcast an {@code Event} to all corresponding registered listeners
	 * @param e The {@code Event} you wanted to send
	 */
	public synchronized void broadcast(Event e) {
		ArrayList<IEventListener> recipients = this.listeners.get(e.getAction());
		if(recipients != null) {
			for(IEventListener r : recipients) {
				send(r,e);
			}
		}
		if(!e.getAction().equals(EventManager.EVENT_ALL_BROADCAST)) {
			e.addExtraString(EventManager.EXTRA_BROADCAST_EVENT_NAME,e.getAction());
			e.setAction(EventManager.EVENT_ALL_BROADCAST);
			broadcast(e);
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
