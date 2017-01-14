package com.thechocolatedev;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class GameJoinSign implements Listener{
	
	@EventHandler
	public void onSignClick(PlayerInteractEvent event){
		
		//Setting variables
		Player player = (Player) event.getPlayer();
		Block clicked = (Block) event.getClickedBlock();
		
		//An if statement checking to see if the clicked block is a sign
		if(clicked.getType() == Material.SIGN || clicked.getType() == Material.SIGN_POST || clicked.getType() == Material.WALL_SIGN) {
			
			//Getting the sign's state
			Sign sign = (Sign) clicked.getState();
			
			if(sign.getLine(0).equals("[Join]") && sign.getLine(1).equals("CTF") && sign.getLine(2).equals("Lobby:")) {
				
				//Getting the lobby number on the fourth line and setting it as a variable
				String signThirdLine = sign.getLine(4);
				
				//Switching the lobby number from a string to a double
				int lobbyNumber = Integer.parseInt(signThirdLine);
				
				//Creating the lobby world
				
				//Creating a new location for the lobby world
				Location lobbyLoc = new Location(Bukkit.getServer().getWorld("Lobby" + lobbyNumber), 0, 0, 0, -180, 0);
				
				//Teleport the player to the location
				player.teleport(lobbyLoc);
				
			}
			
		}
		
	}
	
}
