package latourextensible.platform.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.String;
import java.util.Properties;

public class PersistentStorageManager implements IStorageManager {
	
	private static PersistentStorageManager instance = null;
	private static String defaultDir = null;

	private File contentFile;
	private Properties content;
	
	private PersistentStorageManager() {
		super();
		this.content = new Properties();
	}
	
	private void init() throws DefaultDirNotDeclareException, IOException {
		if(defaultDir != null) {
			this.contentFile = new File(defaultDir+"/PersistentStorageManager.db");
			if(!this.contentFile.exists()) {
				this.contentFile.createNewFile();
			}
		} else {
			throw new DefaultDirNotDeclareException("No default directory destination declare. See PersistentStorageManager.setDefaultDir().");
		}
		this.content.load(new FileInputStream(this.contentFile));
	}
	
	/** Sets the default directory for the persistance storage location
	 * @param dir The directory where datas will be stored
	 */
	public static void setDefaultDir(String dir) {
		defaultDir = dir;
	}
	
	/** Gets the default instance of {@code PersistentStorageManager}
	 * @return The default instance of {@code PersistentStorageManager}
	 */
	public static PersistentStorageManager getDefaultInstance() throws DefaultDirNotDeclareException, IOException{
		if(instance == null) {
			instance = new PersistentStorageManager();
			instance.init();
		}
		return instance;
	}
	
	/** Gets {@code Boolean} data
	 * @param key The key of wanted extra.
	 * @return The data corresponding to the passing key, {@code null} otherwise.
	 */
	public Boolean getBoolean(String key) {
		String strVal = this.content.getProperty(key);
		if(strVal != null) {
			return Boolean.valueOf(strVal);
		} else {
			return null;
		}
	}

	/** Gets {@code int} data
	 * @param key The key of wanted data.
	 * @param defaultValue The value that will be return if the value corresponding to key can't be return.
	 * @return The data corresponding to the passing key, {@code defaultValue} otherwise.
	 */
	public int getInt(String key, int defaultValue) {
		String strVal = this.content.getProperty(key);
		try {
			int val = Integer.parseInt(strVal);
			return val;
		} catch(NumberFormatException ex) {
			return defaultValue;
		}
	}

	/** Gets {@code float} data
	 * @param key The key of wanted data.
	 * @param defaultValue The value that will be return if the value corresponding to key can't be return.
	 * @return The data corresponding to the passing key, {@code defaultValue} otherwise.
	 */
	public float getFloat(String key, float defaultValue) {
		String strVal = this.content.getProperty(key);
		if(strVal != null) {
			try {
				float val = Float.parseFloat(strVal);
				return val;
			} catch(NumberFormatException ex) {
				return defaultValue;
			}
		} else {
			return defaultValue;
		}
	}

	/** Gets {@code String} data
	 * @param key The key of wanted extra.
	 * @return The data corresponding to the passing key, {@code null} otherwise.
	 */
	public String getString(String key) {
		return this.content.getProperty(key);
	}


	/** Sets {@code String} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public boolean putBoolean(String key, boolean o) {
		return putString(key,Boolean.toString(o));
	}

	/** Sets {@code int} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public boolean putInt(String key, int o) {
		return putString(key,Integer.toString(o));
	}

	/** Sets {@code float} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public boolean putFloat(String key, float o) {
		return putString(key,Float.toString(o));
	}

	/** Sets {@code String} data
	 * @param key The key wanted for the data.
	 * @param o The data you wanted to store
	 * @return {@code true} if value was stored, {@code false} otherwise.
	 */
	public boolean putString(String key, String o) {
		this.content.put(key,o);
		try {
			this.content.store(new FileOutputStream(this.contentFile),null);
			return true;
		} catch(FileNotFoundException ex) {
			return false;
		} catch(IOException ex) {
			return false;
		}
	}
	
	/** Removes key value couple
	 * @param key The key of the data you wanted to remove.
	 * @return {@code true} if value was removed, {@code false} otherwise.
	 */
	public boolean remove(String key) {
		if(this.content.remove(key) != null) {
			try {
				this.content.store(new FileOutputStream(this.contentFile),null);
				return true;
			} catch(FileNotFoundException ex) {
				return false;
			} catch(IOException ex) {
				return false;
			}
		} else {
			return false;
		}
	}
	
}
