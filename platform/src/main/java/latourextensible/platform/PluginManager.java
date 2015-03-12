package latourextensible.platform;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

import latourextensible.platform.event.*;

public class PluginManager extends URLClassLoader {

	/** Constant extra event name for indicate original event action name
	 */
	public static final String ACTION_PLUGIN_LOADED = "latourextensible.platform.PluginManager.PLUGIN_LOADED";
	/** Constant extra event name for indicate original event action name
	 * This extra is an instance of PluginProperty
	 */
	public static final String EXTRA_PLUGIN_PROPERTY = "latourextensible.platform.PluginManager.PLUGIN_PROPERTY";
	
	private static PluginManager instance = null;
	private HashMap<String,PluginProperty> plugins;

	private PluginManager() {
		super(new URL[0],Thread.currentThread().getContextClassLoader());
		plugins = new HashMap<String,PluginProperty>();
	}

	public static PluginManager getDefaultInstance() {
		if(instance == null)
			instance = new PluginManager();
		return PluginManager.instance;
	}
	
	public List<PluginProperty> getLoadablePlugins(String pluginService) {
		List<PluginProperty> ret = new ArrayList<PluginProperty>();
		
		for(String pluginUrl : this.plugins.keySet()) {
			PluginProperty p = this.plugins.get(pluginUrl);
			if(p.getService() != null && p.getService().equals(pluginService)) {
				ret.add(p);
			}
		}
		return ret;
	}
	
	public boolean runPlugin(PluginProperty p) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Class<?> cl = Class.forName(p.getPackageName()+"."+p.getMainClassName(),false, this);// ClassNotFoundException
		// TODO correct "false" with isAssignableFrom
		RunnablePlugin pluginInstance = (RunnablePlugin)cl.newInstance();// InstantiationException IllegalAccessException
		pluginInstance.run();// start new thread
		Event eventOk = new Event(PluginManager.ACTION_PLUGIN_LOADED);
		eventOk.addExtra(PluginManager.EXTRA_PLUGIN_PROPERTY,p);
		EventManager.getDefaultInstance().broadcast(eventOk);
		return true;
	}
	
	public boolean addPlugin(URL pluginUrl) throws InvalidPluginPropertiesException, IOException {
		this.addURL(pluginUrl);
		InputStream fileStream = this.getResourceAsStream("plugin.prop");
		if(fileStream == null) {
			return false;
		}
		
		Properties props = new Properties();
		props.load(fileStream);// IOException
		PluginProperty newPlugin = new PluginProperty(pluginUrl);// TODO ensure property is set
		Object prop;
		prop = props.get("Name");
		if(prop != null) {
			newPlugin.setName((String)prop);
		} else {
			throw new InvalidPluginPropertiesException("\"Name\" property is needed in "+pluginUrl);
		}
		
		prop = props.get("Description");
		if(prop != null) {
			newPlugin.setDescription((String)prop);
		}
		
		prop = props.get("PackageName");
		if(prop != null) {
			newPlugin.setPackageName((String)prop);
		} else {
			throw new InvalidPluginPropertiesException("\"PackageName\" property is needed in "+pluginUrl);
		}
		
		prop = props.get("Service");
		if(prop != null) {
			newPlugin.setService((String)prop);
		} else {
			throw new InvalidPluginPropertiesException("\"Services\" property is needed in "+pluginUrl);
		}
		
		prop = props.get("MainClassName");
		if(prop != null) {
			newPlugin.setMainClassName((String)prop);
		} else {
			throw new InvalidPluginPropertiesException("\"MainClassName\" property is needed in "+pluginUrl);
		}
		
		prop = props.get("Options");
		if(prop != null) {
			String[] optionsList = ((String)prop).split(" ");
			for(String opt : optionsList) {
				if(!opt.equals("")) {
					newPlugin.addOption(opt);
				}
			}
		}
		
		prop = props.get("Dependancies");
		if(prop != null) {
			String[] depsList = ((String)prop).split(" ");
			for(String dep : depsList) {
				if(!dep.equals("")) {
					newPlugin.addDependancy(dep);
				}
			}
		}
		
		this.plugins.put(newPlugin.getJarPath().toString(),newPlugin);
		return true;
	}
	
	public void addPluginsPath(String jarPath) throws InvalidPluginPropertiesException, Exception {
		String path = (new File(jarPath)).getCanonicalPath();
		ArrayList<PluginProperty> pluginsList = new ArrayList<PluginProperty>();
		File dir = new File(path);
		String[] jarList = dir.list();
		/*String[] jarList = dir.list(new FilenameFilter() {
				public boolean accept(File dir, String filename) {
					return true;
					// TODO filter to have only jar file
				}
			});*/
		URL jarUrl;
		for(String jar : jarList) {
			jarUrl = new URL("file://"+path+"/"+jar);
			if(this.plugins.containsKey(jarUrl.toString())) {
				continue;
			}
			if(!this.addPlugin(jarUrl)) {
				throw new Exception("Impossible to add plugin "+jarUrl);
			}
		}
	}
}
