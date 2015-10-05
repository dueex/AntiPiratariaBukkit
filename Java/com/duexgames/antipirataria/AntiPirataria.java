package com.duexgames.antipirataria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class AntiPirataria {
	
	/*
	* AntiPirataria
	* Feito por
	* Dueex
	* www.duexgames.com
	* 
	*/
	
	public static String AntiPiratariaIP = Bukkit.getIp() + ":" +  Bukkit.getPort();
	public static String AntiPiratariaDono;
	public static String AntiPiratariaKey;
	
	public static String resposta;
	
	public static void pirataria() {
		try {
			 URL url = new URL("http://localhost/bestepvp.php?ip="+ AntiPiratariaIP + "&key=" + AntiPiratariaKey + "&dono=" + AntiPiratariaDono);   
			 URLConnection con = url.openConnection();
			 con.connect();
			 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			 String inputLine;
			 while((inputLine = in.readLine()) != null) {
				 resposta=inputLine;
			 }
			 in.close();
			 
		} catch (IOException e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
	}
	
	
	public static void checarPirataria() {
		pirataria();
		new BukkitRunnable() {
			@Override
			public void run() {
				if(resposta.equals("true")) {
					Bukkit.getConsoleSender().sendMessage("§2Plugin original");
					Bukkit.getConsoleSender().sendMessage("§2IP: " + AntiPiratariaIP);
					Bukkit.getConsoleSender().sendMessage("§2Dono: " + AntiPiratariaDono);
					Bukkit.getConsoleSender().sendMessage("§2Key: " + AntiPiratariaKey);
				}
				else {
					for(int i=1; i<50; i++){
						Bukkit.getConsoleSender().sendMessage("§cPlugin pirata");
						Bukkit.getConsoleSender().sendMessage("§cIP: " + AntiPiratariaIP);
						Bukkit.getConsoleSender().sendMessage("§cDono: " + AntiPiratariaDono);
						Bukkit.getConsoleSender().sendMessage("§cKey: " + AntiPiratariaKey);
					}
					new BukkitRunnable() {
						@Override
						public void run() {
							for(Player p : Bukkit.getOnlinePlayers()) {
								p.kickPlayer("§cPlugin pirateado!!\n"
										+ "§cCompre uma licenca em \n"
										+ "§cwww.duexgames.com");
							}
							Bukkit.shutdown();
						}
					}.runTaskLater(Main.pl, 150);
				}
			}
		}.runTaskLater(Main.pl, 200);
	}

}
