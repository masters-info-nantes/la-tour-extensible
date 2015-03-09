package latourextensible.platform.storage;

import java.lang.String;

public abstract class AbstractStorageManager {
	
	private AbstractStorageManager() {
	}
	
	public abstract Object get(String key);
	public abstract boolean put(String key, Object o);
	
}
