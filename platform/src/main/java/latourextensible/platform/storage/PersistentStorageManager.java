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
	
	public static void setDefaultDir(String dir) {
		defaultDir = dir;
	}
	
	public static PersistentStorageManager getDefaultInstance() throws DefaultDirNotDeclareException, IOException{
		if(instance == null) {
			instance = new PersistentStorageManager();
			instance.init();
		}
		return instance;
	}
	
	public Boolean getBoolean(String key) {
		String strVal = this.content.getProperty(key);
		if(strVal != null) {
			return Boolean.valueOf(strVal);
		} else {
			return null;
		}
	}

	public int getInt(String key, int defaultValue) {
		String strVal = this.content.getProperty(key);
		try {
			int val = Integer.parseInt(strVal);
			return val;
		} catch(NumberFormatException ex) {
			return defaultValue;
		}
	}

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

	public String getString(String key) {
		return this.content.getProperty(key);
	}


	public boolean putBoolean(String key, boolean o) {
		return putString(key,Boolean.toString(o));
	}

	public boolean putInt(String key, int o) {
		return putString(key,Integer.toString(o));
	}

	public boolean putFloat(String key, float o) {
		return putString(key,Float.toString(o));
	}

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
