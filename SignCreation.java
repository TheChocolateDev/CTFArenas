package com.thechocolatedev;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignCreation implements Listener{
	
	/*Creating the sign creation event as a SignChangeEvent,
	which will initiate when a new sign is created and new text is entered */
	@EventHandler
	public void onSignCreate(SignChangeEvent event) {
		
		//Getting the sign's line for easier use
		String line1 = event.getLine(0);
		String line2 = event.getLine(1);
		String line3 = event.getLine(2);
		String line4 = event.getLine(3);
		
		//An if statement checking to see if the first line says [Join]
		if(line1.equals("[Join]") && line2.equals("CTF") && line3.equals("Lobby:")) {
			
			//Set the first line to the same string, but in green color
			event.setLine(0, ChatColor.GREEN + line1);
			
			//Set the second line to the same string, but in red, orange, and yellow.
			event.setLine(1, ChatColor.RED + "C" + ChatColor.GOLD + "T" + ChatColor.YELLOW + "F");
			
			//Set the third line to the same string, but in blue (aqua)
			event.setLine(2, ChatColor.AQUA + line3);
			
			//Set the fourth line to the same string, but in blue (aqua)
			event.setLine(3, ChatColor.AQUA + line4);
			
		}
		
	}

}

