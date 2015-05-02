package net.mcviral.dev.plugins.comutils.scoreboard;

import java.util.LinkedList;
import java.util.UUID;

import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHolder {
	
	private String scoreboardName = null;
	private Scoreboard scoreboard = null;
	private int priority = 0;
	private LinkedList <UUID> players = new LinkedList <UUID> ();
	
	public ScoreboardHolder(String scoreboardName, Scoreboard board, int priority){
		this.scoreboardName = scoreboardName;
		this.scoreboard = board;
		this.priority = priority;
	}
	
	public String getScoreboardName() {
		return scoreboardName;
	}
	
	public void setScoreboardName(String scoreboardName) {
		this.scoreboardName = scoreboardName;
	}
	
	public Scoreboard getScoreboard() {
		return scoreboard;
	}
	
	public void setScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public LinkedList <UUID> getPlayers() {
		return players;
	}

	public void setPlayers(LinkedList <UUID> players) {
		this.players = players;
	}
	
	public void addPlayer(UUID uuid){
		this.players.add(uuid);
	}
	
	public void removePlayer(UUID uuid){
		this.players.remove(uuid);
	}
	
}
