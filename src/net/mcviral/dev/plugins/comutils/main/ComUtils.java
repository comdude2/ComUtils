package net.mcviral.dev.plugins.comutils.main;

import net.mcviral.dev.plugins.comutils.util.Log;

import org.bukkit.plugin.java.JavaPlugin;

public class ComUtils extends JavaPlugin{
	
	public Log log = null;
	private Listeners listeners = null;
	
	public void onEnable(){
		log = new Log(this.getDescription().getName());
		listeners = new Listeners(this);
		listeners.register();
	}
	
	public void onDisable(){
		listeners.unregister();
	}
	
}
