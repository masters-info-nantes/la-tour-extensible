package latourextensible.platform;

import java.lang.String;
import java.util.ArrayList;

public class PluginProperty {
	private String name;
	private String type;
	private String packageName;
	private String mainClassName;
	private ArrayList<String> dependancies;
	private ArrayList<String> options;

	private boolean instanciate;

	public PluginProperty(String name, String type, String packageName, String mainClassName) {
		this.name = name;
		this.type = type;
		this.packageName = packageName;
		this.mainClassName = mainClassName;
		this.dependancies = new ArrayList<String>();
		this.options = new ArrayList<String>();

		this.instanciate = false;
	}

	public PluginProperty() {
		this(null,null,null,null);
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public String getMainClassName() {
		return this.mainClassName;
	}

	public ArrayList<String> getDependancies() {
		return this.dependancies;
	}

	public ArrayList<String> getOptions() {
		return this.options;
	}

	public boolean getInstanciate() {
		return this.instanciate;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
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

	public void setInstanciate(boolean instanciate) {
		this.instanciate = instanciate;
	}


	public String toString() {

		return "{\n\tname:\""+this.name
				+"\",\n\ttype:\""+this.type
				+"\",\n\tpackageName:\""+this.packageName
				+"\",\n\tmainClassName:\""+this.mainClassName
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
