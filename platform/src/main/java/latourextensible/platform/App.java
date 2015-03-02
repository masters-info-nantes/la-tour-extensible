package latourextensible.platform;

import java.io.*;

public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Plateform start");
		
		PluginManager pluginMgr = PluginManager.getDefaultInstance();
		pluginMgr.addPath("./plugins");
		
		//~ Plugin core = (Plugin)pluginMgr.getPlugin("Core");
		//~ core.run();
		
		RunnablePlugin debug = pluginMgr.getPluginInstance("Debug");
		if(debug != null) {
			debug.run();
		} else {
			System.out.println("No \"Debug\" plugin found");
		}
		
		System.out.println("Plateform end");
	}
}
