/*
ComChat - A chat plugin for Minecraft servers
Copyright (C) 2015  comdude2 (Matt Armer)

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

Contact: admin@mcviral.net
*/

package net.mcviral.dev.plugins.comutils.util;

import org.bukkit.Bukkit;

public class Log {

	private String name = null;
	
	public Log(String mname){
		name = mname;
	}
	
	public void info(String message){
		Bukkit.getLogger().info("[" + name + "] " + message);
	}
	
	public void warning(String message){
		Bukkit.getLogger().warning("[" + name + "] " + message);
	}
	
	public void severe(String message){
		Bukkit.getLogger().severe("[" + name + "] " + message);
	}
}
