package me.tab.TabList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.md_5.bungee.api.ChatColor;

public class main extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\n\nTab Plugin Enabled\n\n");
		getServer().getScheduler().runTaskTimer(this, new Runnable()
		{
			@Override
			public void run() 
			{
				
				Scoreboard sb = getServer().getScoreboardManager().getMainScoreboard();
				
				Team owner = sb.getTeam("Owner");
				Team admin = sb.getTeam("Admin");
				Team srmod = sb.getTeam("SrMod");
				Team mod = sb.getTeam("Mod");
				Team trial = sb.getTeam("Trial");
				Team def= sb.getTeam("Default");
				
				if(owner == null)
				{
					owner = sb.registerNewTeam("Owner");
					owner.setPrefix(ChatColor.DARK_RED + "");
				}
				else if(admin == null)
				{
					admin = sb.registerNewTeam("Admin");
					admin.setPrefix(ChatColor.RED + "");
				}
				else if(srmod == null)
				{
					srmod = sb.registerNewTeam("SrMod");
					srmod.setPrefix(ChatColor.LIGHT_PURPLE + "");
				}
				else if(mod == null)
				{
					mod = sb.registerNewTeam("Mod");
					mod.setPrefix(ChatColor.AQUA + "");
				}
				else if(trial == null)
				{
					trial = sb.registerNewTeam("Trial");
					trial.setPrefix(ChatColor.YELLOW + "");
				}
				else if(def == null)
				{
					def = sb.registerNewTeam("Default");
					def.setPrefix(ChatColor.WHITE + "");
				}
		
				for(Player player : getServer().getOnlinePlayers())
				{
					if(player.hasPermission("tab.owner"))
					{
						owner.addEntry(player.getName());
						owner.setPrefix(ChatColor.DARK_RED + "");
					}
					else if(player.hasPermission("tab.admin"))
					{
						admin.addEntry(player.getName());
						admin.setPrefix(ChatColor.RED + "");
					}
					else if(player.hasPermission("tab.srmod"))
					{
						srmod.addEntry(player.getName());
					}
					else if(player.hasPermission("tab.mod"))
					{
						mod.addEntry(player.getName());
					}
					else if(player.hasPermission("tab.trial"))
					{
						trial.addEntry(player.getName());
					}
					else if(player.hasPermission("tab.default"))
					{
						def.addEntry(player.getName());
					}
				}
			}
			
		}, 0, 40);
	}
	
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\n\nTab Plugin Disabled\n\n");
	}
}
