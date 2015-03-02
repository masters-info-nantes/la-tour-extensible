package latourextensible.platform;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public class PluginManager extends URLClassLoader {

	private static PluginManager instance = null;
	private HashMap<String,ArrayList<PluginProperty>> plugins;

	private PluginManager() {
		super(new URL[0],Thread.currentThread().getContextClassLoader());
		plugins = new HashMap<String,ArrayList<PluginProperty>>();
	}

	public static PluginManager getDefaultInstance() {
		if(instance == null)
			instance = new PluginManager();
		return PluginManager.instance;
	}

	private PluginProperty getPluginPropertyForType(String type) {
		for(String path : plugins.keySet()) {
			ArrayList<PluginProperty> list = plugins.get(path);
			for(PluginProperty p : list) {
				if(p.getType() != null && p.getType().equals(type)) {
					return p;
				}
			}
		}
		return null;
	}


	public RunnablePlugin getPluginInstance(String pluginType) throws Exception {
		// TODO exception when not finded plugin
		PluginProperty pluginProp = getPluginPropertyForType(pluginType);

		Class<?> cl = Class.forName(pluginProp.getPackageName()+"."+pluginProp.getMainClassName(),false, this);
		// TODO correct "false" with isAssignableFrom
		System.out.println("cl.isAssignableFrom(RunnablePlugin.class) = >"+(cl.isAssignableFrom(RunnablePlugin.class))+"<");
		//~ if(cl.isAssignableFrom(RunnablePlugin.class)) {
			return (RunnablePlugin)cl.newInstance();
		//~ } else {
			//~ return null;
		//~ }
	}

	public void addPath(String jarPath) throws PathAlreadyExistingException, Exception {
		String path = (new File(jarPath)).getCanonicalPath();
		if(this.plugins.keySet().contains(path)) {
			throw new PathAlreadyExistingException();
		}
		ArrayList<PluginProperty> pluginsList = new ArrayList<PluginProperty>();
		File dir = new File(path);
		String[] jarList = dir.list();
		/*String[] jarList = dir.list(new FilenameFilter() {
				public boolean accept(File dir, String filename) {
					return true;
					// TODO filter to have only jar file
				}
			});*/
		PluginProperty cur;
		for(String jar : jarList) {
			this.addURL(new URL("file://"+path+"/"+jar));
			InputStream fileStream = this.getResourceAsStream("plugin.prop");
			Properties props = new Properties();
			props.load(fileStream);

			cur = new PluginProperty();// TODO ensure property is set
			Object prop;
			prop = props.get("Name");
			if(prop != null) {
				cur.setName((String)prop);
			} else {
				throw new InvalidPluginPropertiesException("\"Name\" property is needed");
			}
			prop = props.get("PackageName");
			if(prop != null) {
				cur.setPackageName((String)prop);
			} else {
				throw new InvalidPluginPropertiesException("\"PackageName\" property is needed");
			}
			prop = props.get("Type");
			if(prop != null) {
				cur.setType((String)prop);
			} else {
				throw new InvalidPluginPropertiesException("\"Type\" property is needed");
			}
			prop = props.get("MainClassName");
			if(prop != null) {
				cur.setMainClassName((String)prop);
				cur.addOption("run");
			} else {
				cur.setMainClassName("");
			}
			
			prop = props.get("Options");
			if(prop != null) {
				String[] optionsList = ((String)prop).split(" ");
				for(String opt : optionsList) {
					if(!opt.equals("")) {
						cur.addOption(opt);
					}
				}
			}
			
			prop = props.get("Dependancies");
			if(prop != null) {
				String[] depsList = ((String)prop).split(" ");
				for(String dep : depsList) {
					if(!dep.equals("")) {
						cur.addDependancy(dep);
					}
				}
			}
			
			pluginsList.add(cur);
		}
		this.plugins.put(path,pluginsList);
	}
}
