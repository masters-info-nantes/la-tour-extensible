package latourextensible.platform;

import java.io.*;

public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		PluginManager pluginMgr = PluginManager.getDefaultInstance();
		pluginMgr.addPath((new File("./plugins")).getCanonicalPath());
		//~ Plugin core = (Plugin)pluginMgr.getPlugin("Core");
		//~ core.run();
		//~ System.out.println("getPlugin");
		Plugin core = (Plugin)pluginMgr.getPlugin("Debug");
		core.run();
	}
}
