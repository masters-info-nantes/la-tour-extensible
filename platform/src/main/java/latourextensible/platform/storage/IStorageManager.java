package latourextensible.platform.storage;

import java.lang.Boolean;
import java.lang.String;

public interface IStorageManager {
	
	/** Gets {@code Boolean} data
	 * @param key The key of wanted extra.
	 * @return The data corresponding to the passing key, {@code null} otherwise.
	 */
	public abstract Boolean getBoolean(String key);
	/** Gets {@code int} data
	 * @param key The key of wanted data.
	 * @param defaultValue The value that will be return if the value corresponding to key can't be return.
	 * @return The data corresponding to the passing key, {@code defaultValue} otherwise.
	 */
	public abstract int getInt(String key, int defaultValue);
	/** Gets {@code float} data
	 * @param key The key of wanted data.
	 * @param defaultValue The value that will be return if the value corresponding to key can't be return.
	 * @return The data corresponding to the passing key, {@code defaultValue} otherwise.
	 */
	public abstract float getFloat(String key, float defaultValue);
	/** Gets {@code String} data
	 * @param key The key of wanted extra.
	 * @return The data corresponding to the passing key, {@code null} otherwise.
	 */
	public abstract String getString(String key);
	
	/** Sets {@code String} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public abstract boolean putBoolean(String key, boolean o);
	/** Sets {@code int} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public abstract boolean putInt(String key, int o);
	/** Sets {@code float} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public abstract boolean putFloat(String key, float o);
	/** Sets {@code String} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public abstract boolean putString(String key, String o);
	
	/** Removes key value couple
	 * @param key The key of the data you wanted to remove.
	 * @return {@code true} if value was removed, {@code false} otherwise.
	 */
	public abstract boolean remove(String key);
}
