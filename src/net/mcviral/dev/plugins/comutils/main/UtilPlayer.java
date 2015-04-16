package net.mcviral.dev.plugins.comutils.main;

import java.util.UUID;

public class UtilPlayer {
	
	private UUID uuid = null;
	private String name = null;
	private String Ipv4 = null;
	private String customMOTD = null;
	
	public UtilPlayer(UUID uuid, String name, String Ipv4){
		this.uuid = uuid;
		this.name = name;
		this.Ipv4 = Ipv4;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpv4() {
		return Ipv4;
	}

	public void setIpv4(String ipv4) {
		Ipv4 = ipv4;
	}

	public String getCustomMOTD() {
		return customMOTD;
	}

	public void setCustomMOTD(String customMOTD) {
		this.customMOTD = customMOTD;
	}
	
}
