package latourextensible.platform;

import java.io.*;
import java.util.*;

import latourextensible.platform.event.*;

public class Platform {
	
	public final static String ACTION_PLATFORM_END_LOADED = "latourextensible.platform.Platform.ACTION_PLATFORM_END_LOADED";
	
	public static void main(String[] args) throws Exception {
		System.out.println("Plateform start");
		
		PluginManager pluginMgr = PluginManager.getDefaultInstance();
		File defaultPluginDir = new File("./plugins");
		if(!defaultPluginDir.exists()) {
			defaultPluginDir.mkdir();
		}
		pluginMgr.addPluginsPath("./plugins");
		
		// Cores
		List<PluginProperty> cores = pluginMgr.getLoadablePlugins("Core");
		if(cores.isEmpty()) {
			System.out.println("No \"Core\" plugin found");
			System.exit(1);
		} else if(cores.size() == 1) {// only one Core => load it directly
			PluginProperty pp = cores.get(0);
			if(!pluginMgr.runPlugin(pp)) {
				System.out.println("Plugin \""+pp.getName()+"\" cannot be started");
			}
		} else {// more than one, leave choice to user
			Scanner in = new Scanner(System.in);
			System.out.println("Choose program you wanted to start :");
			for(int i=0;i<cores.size();i++) {
				PluginProperty p = cores.get(i);
				System.out.println("["+(i+1)+"] "+p.getName());
				if(!p.getDescription().isEmpty()) {
					System.out.println(p.getDescription());
				}
				System.out.println("");
			}
			boolean valid = false;
			int coreChoosed = 0;
			String input = "";
			while(!valid) {
				try {
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
					input = bufferedReader.readLine();
					coreChoosed = Integer.parseInt(input);
				} catch (NumberFormatException ex) {
					System.out.println("Not a number !");
					continue;
				} catch (IOException e) {
					e.printStackTrace();
					continue;
				}
				if(0 < coreChoosed && coreChoosed <= cores.size()) {
					valid = true;
				} else {
					System.out.println("\""+coreChoosed+"\" is not a valid entry !");
				}
			}
			PluginProperty ppCoreChoosed = cores.get(coreChoosed-1);// -1 => plugin printed with number 1 -> numberOfPlugin
			if(!pluginMgr.runPlugin(ppCoreChoosed)) {
				System.out.println("Plugin \""+ppCoreChoosed.getName()+"\" cannot be started");
			}
		}
		
		// Debugs
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
