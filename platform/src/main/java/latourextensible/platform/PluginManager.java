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


	public Object getPlugin(String pluginType) throws Exception {
		// TODO exception when not finded plugin
		PluginProperty pluginProp = getPluginPropertyForType(pluginType);

		//~ Class<?> cl = Class.forName(pluginProp.getPackageName()+"."+pluginProp.getName(),false, pluginProp.getClassLoader());
		//~ System.out.println("Class.forName(\""+pluginProp.getPackageName()+"."+pluginProp.getMainClassName()+"\")");
//~
		//~ for(URL u : this.getURLs()) {
			//~ System.out.println("dispo = "+u.toString());
		//~ }

		//~ Class<?> cl = Class.forName(pluginProp.getPackageName()+"."+pluginProp.getMainClassName(),false, this);
		Class<?> cl = Class.forName(pluginProp.getPackageName()+"."+pluginProp.getMainClassName(),false, this);

		return cl.newInstance();
	}

	public void addPath(String path) throws PathAlreadyExistingException, Exception {
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
			cur.setName((String)props.get("Name"));
			cur.setType((String)props.get("Type"));
			cur.setPackageName((String)props.get("PackageName"));
			cur.setMainClassName((String)props.get("MainClassName"));

			pluginsList.add(cur);
		}
		this.plugins.put(path,pluginsList);
	}
}
