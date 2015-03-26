package latourextensible.platform.storage;

import java.lang.*;
import java.util.HashMap;

public class SessionStorageManager implements IStorageManager{
	
	private static SessionStorageManager instance = null;
	private HashMap<String,Object> content;
	
	private SessionStorageManager() {
		super();
		this.content = new HashMap<String,Object>();
	}
	
	/** Gets the default instance of {@code SessionStorageManager}
	 * @return The default instance of {@code SessionStorageManager}
	 */
	public static SessionStorageManager getDefaultInstance() {
		if(instance == null) {
			instance = new SessionStorageManager();
		}
		return instance;
	}
	
	/** Gets {@code Object} data
	 * @param key The key of wanted extra.
	 * @return The data corresponding to the passing key, {@code null} otherwise.
	 */
	public Object get(String key) {
		return this.content.get(key);
	}
	
	/** Gets {@code Boolean} data
	 * @param key The key of wanted extra.
	 * @return The data corresponding to the passing key, {@code null} otherwise.
	 */
	public Boolean getBoolean(String key) {
		Object o = this.get(key);
		if(o != null && o instanceof Boolean) {
			return ((Boolean)o);
		}
		return null;
	}
	
	/** Gets {@code int} data
	 * @param key The key of wanted data.
	 * @param defaultValue The value that will be return if the value corresponding to key can't be return.
	 * @return The data corresponding to the passing key, {@code defaultValue} otherwise.
	 */
	public int getInt(String key, int defaultValue) {
		Object o = this.get(key);
		if(o != null && o instanceof Integer) {
			return ((Integer)o).intValue();
		}
		return defaultValue;
	}
	
	/** Gets {@code float} data
	 * @param key The key of wanted data.
	 * @param defaultValue The value that will be return if the value corresponding to key can't be return.
	 * @return The data corresponding to the passing key, {@code defaultValue} otherwise.
	 */
	public float getFloat(String key, float defaultValue) {
		Object o = this.get(key);
		if(o != null && o instanceof Float) {
			return ((Float)o).floatValue();
		}
		return defaultValue;
	}
	
	/** Gets {@code String} data
	 * @param key The key of wanted extra.
	 * @return The data corresponding to the passing key, {@code null} otherwise.
	 */
	public String getString(String key) {
		Object o = this.get(key);
		if(o != null && o instanceof String) {
			return (String)o;
		}
		return null;
	}
	
	/** Sets {@code Object} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public boolean put(String key, Object o) {
		this.content.put(key,o);
		return true;
	}
	
	/** Sets {@code String} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public boolean putBoolean(String key, boolean o) {
		return this.put(key,new Boolean(o));
	}
	
	/** Sets {@code int} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public boolean putInt(String key, int o) {
		return this.put(key,new Integer(o));
	}
	
	/** Sets {@code float} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public boolean putFloat(String key, float o) {
		return this.put(key,new Float(o));
	}
	
	/** Sets {@code String} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public boolean putString(String key, String o) {
		return this.put(key,o);
	}
	
	/** Removes key value couple
	 * @param key The key of the data you wanted to remove.
	 * @return {@code true} if value was removed, {@code false} otherwise.
	 */
	public boolean remove(String key) {
		return this.content.remove(key) != null;
	}
}
