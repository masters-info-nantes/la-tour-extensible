package latourextensible.platform;

import java.io.*;
import java.util.*;

import latourextensible.platform.event.*;

public class Platform {
	
	public final static String ACTION_PLATFORM_END_LOADED = "latourextensible.platform.Platform.ACTION_PLATFORM_END_LOADED";
	
	public static void main(String[] args) throws Exception {
		System.out.println("Plateform start");
		
		PluginManager pluginMgr = PluginManager.getDefaultInstance();
		pluginMgr.addPluginsPath("./plugins");
		
		//~ Plugin core = (Plugin)pluginMgr.getPlugin("Core");
		//~ core.run();
		
		//~ RunnablePlugin debug = pluginMgr.getPluginInstance("Debug");
		//~ if(debug != null) {
			//~ debug.run();
		//~ } else {
			//~ System.out.println("No \"Debug\" plugin found");
		//~ }
		List<PluginProperty> debugs = pluginMgr.getLoadablePlugins("Debug");
		if(debugs.isEmpty()) {
			System.out.println("No \"Debug\" plugin found");
		} else {
			for(PluginProperty pp : debugs) {
				if(!pluginMgr.runPlugin(pp)) {
					System.out.println("Plugin \""+pp.getName()+"\" cannot be started");
				}
			}
		}
		
		EventManager.getDefaultInstance().broadcast(new Event(ACTION_PLATFORM_END_LOADED));
		
		System.out.println("Plateform end");
	}
}
