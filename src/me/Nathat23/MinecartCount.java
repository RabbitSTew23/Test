package me.Nathat23;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecartCount extends JavaPlugin implements Listener  {

	@Override
	public void onEnable(){
	getLogger().info("Minecart Counter v1.0");	
	this.getConfig().addDefault("Enabled", true);
	this.getConfig().options().copyDefaults(true);
	this.saveConfig();
	this.getServer().getPluginManager().registerEvents(this, this);
	}
	@Override
	public void onDisable(){
		
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent ea){
		Player player = (Player) ea.getPlayer();
		int Player = this.getConfig().getInt(ea.getPlayer().getName());
		if(Player >= 1){
			
		}else{
			this.getConfig().set(player.getName(), 0);
			this.saveConfig();
			}
	}
	@EventHandler
	public void onMinecart(VehicleEnterEvent e){
		//Gets the passenger
		Entity p = e.getEntered();
		//Gets if it is enabled in config
		if(this.getConfig().getBoolean("Enabled") == true){
				//Checks that the Passanger is a player
				if(p instanceof Player){
					//Defines the player
				Player player = (Player) p;
				//Gets the amount if the player has ridden before
				int amount = this.getConfig().getInt(((Player) p).getName());
				//Sets it to the config file
				this.getConfig().set(player.getName(), amount + 1);
				//Saves the config
				this.saveConfig();
				player.sendMessage("You just entered a minecart! " + player.getName());
				}
		}
	}
}
