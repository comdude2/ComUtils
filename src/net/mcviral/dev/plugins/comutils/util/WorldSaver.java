package net.mcviral.dev.plugins.comutils.util;

import java.io.File;
import java.util.LinkedList;

import org.bukkit.ChatColor;
import org.bukkit.World;

import net.mcviral.dev.plugins.comutils.main.ComUtils;

public class WorldSaver implements Runnable{
	
	private ComUtils utils = null;
	private int checkTask = -1;
	private LinkedList <CopyTask> tasks = new LinkedList <CopyTask> ();
	private int next = 1;
	private boolean stop = false;
	
	public WorldSaver(final ComUtils utils){
		this.utils = utils;
		checkTask = utils.getServer().getScheduler().scheduleSyncRepeatingTask(utils, new Runnable(){

			@Override
			public void run() {
				boolean zero = true;
				if (tasks.size() > 0){
					utils.log.info("Cleaning up copy threads...");
					zero = false;
				}
				for (CopyTask t : tasks){
					if (t.isFinished()){
						tasks.remove(t);
						World w = utils.getServer().getWorld(t.getWorldName());
						if (w != null){
							w.setAutoSave(true);
						}
						utils.log.info("Removed copy thread for world: " + t.getWorldName());
					}
				}
				if (zero == false){
					utils.log.info("Finished cleaning.");
				}
			}
			
		}, 200L, 100L);
	}
	
	public void stop(){
		utils.log.info("Stopping saver...");
		stop = true;
		utils.getServer().getScheduler().cancelTask(checkTask);
		for (CopyTask t : tasks){
			t.stop();
			utils.getServer().getScheduler().cancelTask(t.getID());
		}
		utils.log.info("Stopped.");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		utils.getLogger().info("Saver thread running...");
		if (!stop){
			if (next == 11){
				next = 1;
			}
			utils.getServer().broadcastMessage(ChatColor.GRAY + "[Server] Saving worlds...");
			int id = -1;
			for (World w : utils.getServer().getWorlds()){
				File[] files = new File(utils.getDataFolder() + "/worlds/set " + next + "/").listFiles();
				if (files.length > 0){
					for (File f : files){
						try{
							f.delete();
						}catch(Exception e){
							utils.log.warning("Failed to delete: " + e.getMessage());
						}
					}
				}
				try{
					w.setAutoSave(false);
					w.save();
					CopyTask t = new CopyTask(w.getName(), w.getWorldFolder(), new File(utils.getDataFolder() + "/worlds/set " + next + "/" + w.getName() + "/"));
					id = utils.getServer().getScheduler().scheduleAsyncDelayedTask(utils, t, 0L);
					t.setID(id);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			next++;
		}
	}
	
	public void loadWorld(String name){
		
	}
	
	public void loadWorlds(){
		
	}
	
}
