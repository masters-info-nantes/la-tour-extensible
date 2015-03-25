package latourextensible.platform;

import java.lang.String;
import java.util.ArrayList;
import java.net.URL;

/** {@code PluginProperty} class representation
 * 
 * {@code PluginProperty} contain all elements which define a plugin.
 * The {@code Service} attribute is a string which difine what service offer the plugin. By default only 2 services are defined and recognize by the system, "Core" and "Debug". But you can define every service you want, just remember only Core and Debug plugin could be start as first plugin.
 */
public class PluginProperty {
	/** Constant service name for core plugins
	 */
	public static final String SERVICE_CORE = "Core";
	/** Constant service name for debuging plugins
	 */
	public static final String SERVICE_DEBUG = "Debug";
	
	private String name;
	private String description;
	private String service;
	private String packageName;
	private String mainClassName;
	private URL jarPath;
	private ArrayList<String> dependancies;
	private ArrayList<String> options;

	private RunnablePlugin instance;
	
	
	/** Constructs a new {@code PluginProperty}
	 * @param name The name of the plugin.
	 * @param description The description of the plugin.
	 * @param service The service name of the plugin.
	 * @param packageName The package name of the plugin.
	 * @param mainClassName The main class name of the plugin.
	 * @param jarPath The path of the jar which contain the plugin.
	 */
	public PluginProperty(String name, String description, String service, String packageName, String mainClassName, URL jarPath) {
		this.name = name;
		this.description = description;
		this.service = service;
		this.packageName = packageName;
		this.mainClassName = mainClassName;
		this.jarPath = jarPath;
		this.dependancies = new ArrayList<String>();
		this.options = new ArrayList<String>();

		this.instance = null;
	}
	
	/** Constructs a new {@code PluginProperty}
	 * @param jarPath The path of the jar which contain the plugin.
	 */
	public PluginProperty(URL jarPath) {
		this(null,null,null,null,null,jarPath);
	}
	
	/** Gets the plugin name
	 * @return the plugin name
	 */
	public String getName() {
		return this.name;
	}

	/** Gets the plugin description
	 * @return the plugin description
	 */
	public String getDescription() {
		return this.description;
	}

	/** Gets the plugin service name
	 * @return the plugin service name
	 */
	public String getService() {
		return this.service;
	}

	/** Gets the plugin package name
	 * @return the plugin package name
	 */
	public String getPackageName() {
		return this.packageName;
	}

	/** Gets the plugin main class name
	 * @return the plugin main class name
	 */
	public String getMainClassName() {
		return this.mainClassName;
	}

	/** Gets the plugin jar path
	 * @return the plugin jar path
	 */
	public URL getJarPath() {
		return this.jarPath;
	}

	/** Gets the plugin dependancies list
	 * @return the plugin dependancies list
	 */
	public ArrayList<String> getDependancies() {
		return this.dependancies;
	}

	/** Gets the current plugin instance
	 * @return the current plugin instance
	 */
	RunnablePlugin getInstance() {
		return this.instance;
	}
	
	/** Gets wether plugin is instanciate.
	 * @return {@code true} if the plugin is instanciated, {@code false} otherwise.
	 */
	public boolean isInstanciate() {
		return this.instance != null;
	}

	/** Sets the plugin name
	 * @param name the new plugin name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** Sets the plugin description
	 * @param description the new plugin description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Sets the plugin service name
	 * @param service the new plugin service name
	 */
	public void setService(String service) {
		this.service = service;
	}

	/** Sets the plugin package name
	 * @param packageName the new plugin package name
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/** Sets the plugin main class name
	 * @param mainClassName the new main class name
	 */
	public void setMainClassName(String mainClassName) {
		this.mainClassName = mainClassName;
	}

	/** Adds a new dependancy
	 * @param dependancy The dependancy you wanted to add.
	 */
	public void addDependancy(String dependancy) {
		this.dependancies.add(dependancy);
	}

	/** Sets the current plugin instance
	 * @param plugin the new plugin instance
	 */
	void setInstance(RunnablePlugin plugin) {
		this.instance = plugin;
	}


	/** Returns a string containing a concise, human-readable description of this {@code PluginProperty}.
	 * @return a printable representation of this object.  
	 */
	public String toString() {

		return "{\n\tname:\""+this.name
				+"\",\n\tdescription:\""+this.description
				+"\",\n\tservice:\""+this.service
				+"\",\n\tpackageName:\""+this.packageName
				+"\",\n\tmainClassName:\""+this.mainClassName
				+"\",\n\tjarPath:\""+this.jarPath.toString()
				+"\",\n\tdependancies:"+json(this.dependancies)
				+",\n\toptions:"+json(this.options)+"\n}";
	}

	private String json(ArrayList<String> list) {
		String ret = "[";
		boolean first = true;
		for(String e : list) {
			if(first) {
				ret += "\n\t\""+e+"\"";
				first = false;
			} else {
				ret += ",\n\t\""+e+"\"";
			}
		}
		if(!first) {// if dependancy
			ret += "\n\t";
		}
		return ret+"]";
	}
}
