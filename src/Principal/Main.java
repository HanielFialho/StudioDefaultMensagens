package Principal;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import Eventos.SpigotDefaultMensagems;

public class Main extends JavaPlugin {

	public static Main getPlugin() {
		return JavaPlugin.getPlugin(Main.class);
	}

	@Override
	public void onEnable() {
		org.bukkit.Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD
				+ "Sua luta não termina quando sentir cansaço, mas sim quando atingir o sucesso tão merecido.");
		RegistrarEventos();
		saveDefaultConfig();
	}

	private void RegistrarEventos() {
		getServer().getPluginManager().registerEvents(new SpigotDefaultMensagems(), this);
	}

	@Override
	public void onDisable() {
	}

}
