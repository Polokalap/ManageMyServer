package mel.polokalap.manageMyServer.Listeners;

import mel.polokalap.manageMyServer.ManageMyServer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ToggleChatEvent implements Listener {
    @EventHandler
    public void onChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        if (ManageMyServer.getInstance().getConfig().getBoolean("chat") == false) {
            if (!(player.hasPermission("managemyserver.togglechat"))) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "The chat is currently disabled!");
            }
        }
    }
}
