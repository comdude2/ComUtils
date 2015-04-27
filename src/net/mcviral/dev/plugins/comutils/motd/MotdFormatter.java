package net.mcviral.dev.plugins.comutils.motd;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.mcviral.dev.plugins.comutils.main.ComUtils;

public class MotdFormatter {
	
	private ComUtils utils = null;
	
	public MotdFormatter(ComUtils utils){
		this.utils = utils;
	}
	
	public String format(String motd){
		return null;
	}
	
	public String fillTag(MotdTag tag){
		if (tag.getTagType() == MotdTagType.SERVER_NAME){
			return utils.getServer().getName();
		}else if (tag.getTagType() == MotdTagType.SERVER_MOTD){
			return utils.getServer().getMotd();
		}else if (tag.getTagType() == MotdTagType.COLOUR){
			if (tag.getValue() != null){
				ChatColor c = ChatColor.valueOf(tag.getValue());
				return c + "";
			}else{
				//error
			}
		}else if (tag.getTagType() == MotdTagType.PLAYER_STATUS){
			if (tag.getValue() != null){
				Player p = utils.getServer().getPlayer(tag.getValue());
				if (p != null){
					return "Online";
				}else{
					return "Offline";
				}
			}else{
				//error
			}
		}else if (tag.getTagType() == MotdTagType.WHITELISTED){
			if (utils.getServer().hasWhitelist()){
				return "On";
			}else{
				return "Off";
			}
		}else if (tag.getTagType() == MotdTagType.SERVER_NAME){
			
		}else{
			//error
		}
		return null;
	}
	
	public String colour(String msg){
		String coloredMsg = "";
		for(int i = 0; i < msg.length(); i++){
			if(msg.charAt(i) == '&'){
				coloredMsg += '§';
			}else{
				coloredMsg += msg.charAt(i);
			}
    	}
		//chat.getServer().getConsoleSender().sendMessage(coloredMsg);
    	return coloredMsg;
    }
	
}
