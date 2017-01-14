package com.thechocolatedev;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class GameWait implements Listener{
	
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent event) {
		
		//Get the player of the event
		Player player = (Player) event.getPlayer();
		
		//Get the player's new world
		World9 newWorld = (World) player.getWorld();
		
		//Get the amount of players in the player's new world
		List<Player> players = newWorld.getPlayers();
		int playerAmount = players.size();
		
		if(playerAmount == 1) {
			
			player.sendMessage(ChatColor.RED + "Please wait for more players, to begin the game");
			
		}
		
		else if(playerAmount < 8){
			
			// A for statement telling everyone the status of the wait
			for (Player p : newWorld.getPlayers()) {
				
			      p.sendMessage(ChatColor.RED + "The game needs at least 8 players to begin.");
			      
			}
			
		}
		
		else if(playerAmount == 8){
			
			// A for statement telling everyone the status of the wait
			for (Player p : newWorld.getPlayers()) {
				
			      p.sendMessage(ChatColor.AQUA + "The game will begin in" + ChatColor.DARK_AQUA + "30" + ChatColor.AQUA + "seconds.");
			      
			}
			
		}
		
		else if(playerAmount == 9) {
			
			// A for statement telling everyone the status of the wait
			for (Player p : newWorld.getPlayers()) {
				
			      p.sendMessage(ChatColor.AQUA + "The game will begin in" + ChatColor.DARK_AQUA + "15" + ChatColor.AQUA + "seconds.");
			      
			}
			
		}
		
		else if(playerAmount == 10) {
			
			// A for statement telling everyone the status of the wait
			for (Player p : newWorld.getPlayers()) {
				
			      p.sendMessage(ChatColor.AQUA + "The game will begin in" + ChatColor.DARK_AQUA + "5" + ChatColor.AQUA + "seconds.");
			      
			}
			
		}
		
		else if(playerAmount >= 11) {
			
			//Get the main lobby world and put it in a location and teleport the player to that location
			World mainLobby = (World) Bukkit.getServer().getWorld("Lobby");
			Location mlLoc = new Location(mainLobby, 0, 100, 0);
			player.teleport(mlLoc);
			player.sendMessage("That game is full. Please wait till next round or find another game.");
			
		}
		
	}

}
