package me.nate.randomdrops;

import org.bukkit.plugin.java.JavaPlugin;

import me.nate.randomdrops.listeners.BreakListen;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		new BreakListen(this);
	}
	
}
