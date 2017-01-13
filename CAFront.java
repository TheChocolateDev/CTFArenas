package com.thechocolatedev;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CAFront extends JavaPlugin{
	
	public void OnEnable() {
		
		Bukkit.getServer().getPluginManager().registerEvents(new SignCreation(), this);
		
	}

}
