package latourextensible.platform;

import java.lang.String;
import java.util.ArrayList;
import java.net.URL;

public class PluginProperty {
	private String name;
	private String description;
	private String service;
	private String packageName;
	private String mainClassName;
	private URL jarPath;
	private ArrayList<String> dependancies;
	private ArrayList<String> options;

	private RunnablePlugin instance;

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

	public PluginProperty(URL jarPath) {
		this(null,null,null,null,null,jarPath);
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public String getService() {
		return this.service;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public String getMainClassName() {
		return this.mainClassName;
	}

	public URL getJarPath() {
		return this.jarPath;
	}

	public ArrayList<String> getDependancies() {
		return this.dependancies;
	}

	public ArrayList<String> getOptions() {
		return this.options;
	}

	RunnablePlugin getInstance() {
		return this.instance;
	}

	public boolean isInstanciate() {
		return this.instance != null;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setMainClassName(String mainClassName) {
		this.mainClassName = mainClassName;
	}

	public void addDependancy(String dependancy) {
		this.dependancies.add(dependancy);
	}

	public void addOption(String option) {
		this.options.add(option);
	}

	void setInstance(RunnablePlugin plugin) {
		this.instance = plugin;
	}


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
