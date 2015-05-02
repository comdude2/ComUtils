package net.mcviral.dev.plugins.comutils.scoreboard;

import java.util.LinkedList;

import net.mcviral.dev.plugins.comutils.main.ComUtils;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {
	
	private ComUtils utils = null;
	private ScoreboardHolder main = null;
	private LinkedList <ScoreboardHolder> scoreboards = new LinkedList <ScoreboardHolder> ();
	
	public ScoreboardManager(ComUtils utils){
		this.utils = utils;
		this.main = new ScoreboardHolder("MAIN", null, 0);
		scoreboards = new LinkedList <ScoreboardHolder> ();
	}
	
	public void registerMainScoreboard(Scoreboard board){
		ScoreboardHolder holder = null;
		if (main.getScoreboard() != null){
			holder = main;
			
		}else{
			holder = new ScoreboardHolder("MAIN", board, 0);
		}
		
		
	}
	
	public LinkedList <ScoreboardHolder> getScoreboards(){
		return scoreboards;
	}
	
	public ScoreboardHolder registerScoreboard(String name, Scoreboard board, int priority){
		ScoreboardHolder holder = new ScoreboardHolder(name, board, priority);
		scoreboards.add(holder);
		return holder;
	}
	
	public void unregisterScoreboard(String boardName){
		for (ScoreboardHolder holder : scoreboards){
			if (holder.getScoreboardName().equals(boardName)){
				scoreboards.remove(holder);
			}
		}
	}
	
	public void unregisterScoreboard(Scoreboard board){
		for (ScoreboardHolder holder : scoreboards){
			if (holder.getScoreboard().equals(board)){
				scoreboards.remove(holder);
				for (Player p : utils.getServer().getOnlinePlayers()){
					if (p.getScoreboard().equals(holder.getScoreboard())){
						p.setScoreboard(main.getScoreboard());
					}
				}
			}
		}
	}
	
	public boolean isScoreboardRegistered(String boardName){
		for (ScoreboardHolder holder : scoreboards){
			if (holder.getScoreboardName().equals(boardName)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isScoreboardRegistered(Scoreboard board){
		for (ScoreboardHolder holder : scoreboards){
			if (holder.getScoreboard().equals(board)){
				return true;
			}
		}
		return false;
	}
	
	public ScoreboardHolder getScoreboard(String scoreboardName){
		for (ScoreboardHolder holder : scoreboards){
			if (holder.getScoreboardName().equalsIgnoreCase(scoreboardName)){
				return holder;
			}
		}
		return null;
	}
	
	public boolean changeScoreboard(Player p, ScoreboardHolder h){
		ScoreboardHolder holder = determineScoreboard(p);
		if (holder != null){
			if (holder == h){
				p.setScoreboard(h.getScoreboard());
			}else{
				return false;
			}
		}else{
			p.setScoreboard(h.getScoreboard());
			return true;
		}
		return false;
	}
	
	public boolean updateScoreboard(String scoreboardName,  Scoreboard updated){
		for (ScoreboardHolder holder : scoreboards){
			if (holder.getScoreboardName().equalsIgnoreCase(scoreboardName)){
				holder.setScoreboard(updated);
				for (Player p : utils.getServer().getOnlinePlayers()){
					ScoreboardHolder h = determineScoreboard(p);
					if (h != null){
						p.setScoreboard(h.getScoreboard());
					}else{
						if (holder.getPlayers().contains(p.getUniqueId())){
							p.setScoreboard(updated);
						}
					}
					
				}
				return true;
			}
		}
		return false;
	}
	
	private ScoreboardHolder determineScoreboard(Player p){
		ScoreboardHolder top = null;
		for (ScoreboardHolder holder : scoreboards){
			if (holder.getPlayers().contains(p.getUniqueId())){
				if (top != null){
					if (top.getPriority() < holder.getPriority()){
						//change
						top = holder;
					}
				}else{
					top = holder;
				}
			}
		}
		return top;
	}
	
}
