package net.mcviral.dev.plugins.comutils.main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class Listeners implements Listener{
	
	private ComUtils utils = null;
	
	public Listeners(ComUtils utils){
		this.utils = utils;
	}
	
	public void register(){
		utils.getServer().getPluginManager().registerEvents(this, utils);
	}
	
	public void unregister(){
		HandlerList.unregisterAll(this);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event){
		
	}
	
	@EventHandler
	public void onServerPingEvent(ServerListPingEvent event){
		
	}
	
}
