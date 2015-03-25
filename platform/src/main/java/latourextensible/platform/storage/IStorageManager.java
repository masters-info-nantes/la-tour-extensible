package latourextensible.platform.storage;

import java.lang.Boolean;
import java.lang.String;

public interface IStorageManager {
	
	public abstract Boolean getBoolean(String key);
	public abstract int getInt(String key, int defaultValue);
	public abstract float getFloat(String key, float defaultValue);
	public abstract String getString(String key);
	
	public abstract boolean putBoolean(String key, boolean o);
	public abstract boolean putInt(String key, int o);
	public abstract boolean putFloat(String key, float o);
	public abstract boolean putString(String key, String o);
	
	public abstract boolean remove(String key);
}
