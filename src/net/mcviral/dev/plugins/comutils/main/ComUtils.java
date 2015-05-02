package net.mcviral.dev.plugins.comutils.main;

import java.io.File;

import net.mcviral.dev.plugins.comutils.util.Log;
import net.mcviral.dev.plugins.comutils.util.WorldSaver;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
		stopSchedule();
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
		saver = new WorldSaver(this);
		int id = this.getServer().getScheduler().scheduleSyncRepeatingTask(this, saver, 2400L, 6000L);
		return id;
	}
	
	public void stopSchedule(){
		saver.stop();
		this.getServer().getScheduler().cancelTask(saves);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("uuid")) {
			if (sender instanceof Player){
				Player p = (Player) sender;
				if (args.length > 0){
					
				}else{
					sender.sendMessage(ChatColor.GREEN + "Your UUID: " + p.getUniqueId());
				}
			}
			return true;
		}else{
			return false;
		}
	}
	
}
