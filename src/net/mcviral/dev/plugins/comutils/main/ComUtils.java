package net.mcviral.dev.plugins.comutils.main;

import java.io.File;

import net.mcviral.dev.plugins.comutils.util.Log;
import net.mcviral.dev.plugins.comutils.util.WorldSaver;

import org.bukkit.plugin.java.JavaPlugin;

public class ComUtils extends JavaPlugin{
	
	public Log log = null;
	private Listeners listeners = null;
	private int saves = 0;
	private WorldSaver saver = null;
	
	public void onEnable(){
		this.saveDefaultConfig();
		log = new Log(this.getDescription().getName());
		listeners = new Listeners(this);
		listeners.register();
		setupStorage();
		saves = scheduleSaves();
	}
	
	public void onDisable(){
		listeners.unregister();
	}
	
	public void setupStorage(){
		File f = new File(this.getDataFolder() + "/worlds/set 1/");
		f.mkdirs();
		f = new File(this.getDataFolder() + "/worlds/set 2/");
		f.mkdirs();
		f = new File(this.getDataFolder() + "/worlds/set 3/");
		f.mkdirs();
		f = new File(this.getDataFolder() + "/worlds/set 4/");
		f.mkdirs();
		f = new File(this.getDataFolder() + "/worlds/set 5/");
		f.mkdirs();
		f = new File(this.getDataFolder() + "/worlds/set 6/");
		f.mkdirs();
		f = new File(this.getDataFolder() + "/worlds/set 7/");
		f.mkdirs();
		f = new File(this.getDataFolder() + "/worlds/set 8/");
		f.mkdirs();
		f = new File(this.getDataFolder() + "/worlds/set 9/");
		f.mkdirs();
		f = new File(this.getDataFolder() + "/worlds/set 10/");
		f.mkdirs();
	}
	
	public int scheduleSaves(){
		//this.getServer().getWorld("").save();
		saver = new WorldSaver(this);
		int id = this.getServer().getScheduler().scheduleSyncRepeatingTask(this, saver, 3600L, 2400L);
		//saver.run();
		return id;
	}
	
	public void stopSchedule(){
		saver.stop();
		this.getServer().getScheduler().cancelTask(saves);
	}
	
}
