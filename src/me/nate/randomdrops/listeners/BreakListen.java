package me.nate.randomdrops.listeners;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;

import me.nate.randomdrops.Main;

public class BreakListen implements Listener {
	
	private Main plugin;
	
	public BreakListen(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void breakEvent(BlockDropItemEvent d) {
		
		Material[] matlist = Material.values();
        int random = new Random().nextInt(matlist.length);
        Material mat = matlist[random];
        
        Location blockLoc = d.getBlock().getLocation();
		ItemStack ranDrop = new ItemStack(mat);
		List<Item> drops = d.getItems();
		drops.clear();
		Player breaker = d.getPlayer();
		Location breakerloc = breaker.getLocation();
		World w = breakerloc.getWorld();
		w.dropItem(blockLoc, ranDrop);
		
	}

}
