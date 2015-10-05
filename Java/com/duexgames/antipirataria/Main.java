package com.duexgames.antipirataria;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	
	public static Main pl;
	
	@Override
	public void onEnable() {
		pl = this;
		AntiPirataria.AntiPiratariaDono = getConfig().getString("user");
		AntiPirataria.AntiPiratariaKey = getConfig().getString("key");
		AntiPirataria.checarPirataria();
	}

}
