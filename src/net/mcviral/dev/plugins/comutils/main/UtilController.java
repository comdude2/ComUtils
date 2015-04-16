package net.mcviral.dev.plugins.comutils.main;

import java.util.LinkedList;

public class UtilController {
	
	@SuppressWarnings("unused")
	private ComUtils utils = null;
	private LinkedList <UtilPlayer> players = new LinkedList <UtilPlayer> ();
	
	public UtilController(ComUtils utils){
		this.utils = utils;
	}

	public LinkedList <UtilPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(LinkedList <UtilPlayer> players) {
		this.players = players;
	}
	
}
