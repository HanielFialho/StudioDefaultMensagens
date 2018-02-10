package Eventos;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import Principal.Main;

public class SpigotDefaultMensagems implements org.bukkit.event.Listener {

	@org.bukkit.event.EventHandler(priority = org.bukkit.event.EventPriority.MONITOR)
	public void WhitelistMsg(PlayerLoginEvent event) {
		if ((!event.getPlayer().isWhitelisted()) && (org.bukkit.Bukkit.hasWhitelist())) {
			if (Main.getPlugin().getConfig().getBoolean("Whitelist.Studio.NovaMensagem") == true) {
				event.disallow(org.bukkit.event.player.PlayerLoginEvent.Result.KICK_WHITELIST,
						(ChatColor.translateAlternateColorCodes('&',
								Main.getPlugin().getConfig().getString("WhitelistMensagem"))));
			} else {
			}
		}
	}

	@org.bukkit.event.EventHandler
	public void ServidorCheio(PlayerLoginEvent event) {
		if (event.getResult() == org.bukkit.event.player.PlayerLoginEvent.Result.KICK_FULL) {
			if (Main.getPlugin().getConfig().getBoolean("ServidorCheio.NovaMensagem") == true) {
				event.setKickMessage(ChatColor.translateAlternateColorCodes('&',
						Main.getPlugin().getConfig().getString("FullMensagem")));
			} else {
			}
		}
	}

	@org.bukkit.event.EventHandler(priority = org.bukkit.event.EventPriority.HIGHEST)
	public void ComandoHelp(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (!event.isCancelled()) {
			String command = event.getMessage().split(" ")[0];
			org.bukkit.help.HelpTopic Studio = org.bukkit.Bukkit.getServer().getHelpMap().getHelpTopic(command);
			if (Studio == null) {
				if (Main.getPlugin().getConfig().getBoolean("Help.NovaMensagem") == true) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							Main.getPlugin().getConfig().getString("HelpMensagem")));
					event.setCancelled(true);
				} else {

				}
			}
		}
	}
}
