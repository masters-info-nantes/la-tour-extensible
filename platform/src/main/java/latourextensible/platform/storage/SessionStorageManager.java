package latourextensible.platform.storage;

import java.lang.*;
import java.util.HashMap;

public class SessionStorageManager {
	
	private static SessionStorageManager instance = null;
	private HashMap<String,Object> content;
	
	private SessionStorageManager() {
		super();
		this.content = new HashMap<String,Object>();
	}
	
	public static SessionStorageManager getDefaultInstance() {
		if(instance == null) {
			instance = new SessionStorageManager();
		}
		return instance;
	}
	
	public Object get(String key) {
		return this.content.get(key);
	}
	
	public Boolean getBoolean(String key) {
		Object o = this.get(key);
		if(o != null && o instanceof Boolean) {
			return ((Boolean)o);
		}
		return null;
	}
	
	public int getInt(String key, int defaultValue) {
		Object o = this.get(key);
		if(o != null && o instanceof Integer) {
			return ((Integer)o).intValue();
		}
		return defaultValue;
	}
	
	public float getFloat(String key, float defaultValue) {
		Object o = this.get(key);
		if(o != null && o instanceof Float) {
			return ((Float)o).floatValue();
		}
		return defaultValue;
	}
	
	public String getString(String key) {
		Object o = this.get(key);
		if(o != null && o instanceof String) {
			return (String)o;
		}
		return null;
	}
	
	public boolean put(String key, Object o) {
		if(this.content.get(key) != null) {
			return false;
		}
		this.content.put(key,o);
		return true;
	}
	
	public boolean putBoolean(String key, boolean o) {
		return this.put(key,new Boolean(o));
	}
	
	public boolean putInt(String key, int o) {
		return this.put(key,new Integer(o));
	}
	
	public boolean putFloat(String key, float o) {
		return this.put(key,new Float(o));
	}
	
	public boolean putString(String key, String o) {
		return this.put(key,o);
	}
	
}
