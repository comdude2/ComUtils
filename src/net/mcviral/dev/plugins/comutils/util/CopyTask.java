package net.mcviral.dev.plugins.comutils.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CopyTask implements Runnable{
	
	private int taskID = -1;
	private boolean stop = false;
	private String worldName = null;
	private File src = null;
	private File dest = null;
	private boolean finished = false;
	
	public CopyTask(String worldName, File src, File dest){
		this.setWorldName(worldName);
		this.src = src;
		this.dest = dest;
	}
	
	public String getWorldName() {
		return worldName;
	}

	public void setWorldName(String worldName) {
		this.worldName = worldName;
	}

	public void setID(int taskID){
		this.taskID = taskID;
	}
	
	public int getID(){
		return taskID;
	}
	
	public void stop(){
		stop = true;
	}
	
	public boolean isFinished(){
		return finished;
	}

	@Override
	public void run() {
		if (!stop){
			copy(src, dest);
			finished = true;
		}
	}
	
	private static boolean copy(File src, File dest){
		try {
			FileUtils.copyDirectory(src, dest);
			System.out.println("Copied: " + src.getName());
			return true;
		} catch (IOException e) {
			System.out.println("Failed to copy file '" + src.getName() + "' Reason: " + e.getMessage());
		}
		return false;
	}
	
}
