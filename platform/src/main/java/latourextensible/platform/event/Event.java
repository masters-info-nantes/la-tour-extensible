package latourextensible.platform.event;

import java.lang.*;
import java.util.HashMap;
import java.util.Set;

/** {@code Event} class representation
 * 
 * {@code Event} contain an action name which identify it.
 * An {@code Event} could also contains some exta data identified by a key.
 */
public class Event {
	private String action;
	private HashMap<String,Object> extra;
	
	/** Construct a new {@code Event}
	 * @param action The name of the {@code Event}.
	 */	
	public Event(String action) {
		this.action = action;
		this.extra = new HashMap<String,Object>();
	}
	
	/** Gets the action name
	 * @return the action name
	 */
	public String getAction() {
		return this.action;
	}
	
	/** Sets the action name
	 * @param action the new action name
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/** Gets all the keys of extra data
	 * @return The keys of extra data
	 */
	public Set<String> getExtraKeys() {
		return this.extra.keySet();
	}
	
	/** Gets extra {@code Object} data
	 * @param key The key of wanted extra.
	 * @return The data corresponding to the passing key, {@code null} otherwise.
	 */
	public Object getExtra(String key) {
		return this.extra.get(key);
		
	}
	
	/** Gets extra {@code String} data
	 * @param key The key of wanted extra.
	 * @return The data corresponding to the passing key, {@code null} otherwise.
	 */
	public String getExtraString(String key) {
		Object o = this.getExtra(key);
		if(o instanceof String) {
			return (String)o;
		} else {
			return null;
		}
	}
	
	/** Gets extra {@code int} data
	 * @param key The key of wanted extra.
	 * @param defaultValue The value that will be return if the value corresponding to key can't be return.
	 * @return The data corresponding to the passing key, {@code defaultValue} otherwise.
	 */
	public int getExtraInt(String key, int defaultValue) {
		Object o = this.getExtra(key);
		if(o instanceof Integer) {
			return ((Integer)o).intValue();
		} else {
			return defaultValue;
		}
	}
	
	/** Gets extra {@code float} data
	 * @param key The key of wanted extra.
	 * @param defaultValue The value that will be return if the value corresponding to key can't be return.
	 * @return The data corresponding to the passing key, {@code defaultValue} otherwise.
	 */
	public float getExtraFloat(String key, float defaultValue) {
		Object o = this.getExtra(key);
		if(o instanceof Float) {
			return ((Float)o).floatValue();
		} else {
			return defaultValue;
		}
	}
	
	/** Gets extra {@code boolean} data
	 * @param key The key of wanted extra.
	 * @return The data corresponding to the passing key, {@code null} otherwise.
	 */
	public Boolean getExtraBoolean(String key) {
		Object o = this.getExtra(key);
		if(o instanceof Boolean) {
			return ((Boolean)o);
		} else {
			return null;
		}
	}
	
	/** Adds extra {@code Object} data
	 * @param key The key wanted for the extra.
	 * @param value The value you wanted to store
	 */
	public void addExtra(String key, Object value) {
		this.extra.put(key,value);
	}
	
	/** Adds extra {@code String} data
	 * @param key The key wanted for the extra.
	 * @param value The value you wanted to store
	 */
	public void addExtraString(String key, String value) {
		this.extra.put(key,value);
	}
	
	/** Adds extra {@code int} data
	 * @param key The key wanted for the extra.
	 * @param value The value you wanted to store
	 */
	public void addExtraInt(String key, int value) {
		this.extra.put(key,new Integer(value));
	}
	
	/** Adds extra {@code float} data
	 * @param key The key wanted for the extra.
	 * @param value The value you wanted to store
	 */
	public void addExtraFloat(String key, float value) {
		this.extra.put(key,new Float(value));
	}
	
	/** Adds extra {@code boolean} data
	 * @param key The key wanted for the extra.
	 * @param value The value you wanted to store
	 */
	public void addExtraBoolean(String key, boolean value) {
		this.extra.put(key,new Boolean(value));
	}
	
	/** Returns whether this {@code Event} contains extra.
	 * @return {@code true} if this Event has no extra, {@code false} otherwise.
	 */
	public boolean emptyExtra() {
		return this.extra.isEmpty();
	}
	
	/** Returns a string containing a concise, human-readable description of this {@code Event}.
	 * @return a printable representation of this object.  
	 */
	public String toString() {
		String ret = "ACTION = \""+this.action+"\"\n"
					+"EXTRA = [";
		for(String k : this.extra.keySet()) {
			ret += "\n\t\""+k+"\" : \""+this.extra.get(k).toString()+"\"";
		}
		return ret+"]";
	}
}
