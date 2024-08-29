package mel.polokalap.manageMyServer.Listeners;

import mel.polokalap.manageMyServer.ManageMyServer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class ToggleBlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (ManageMyServer.getInstance().getConfig().getBoolean("block") == false) {
            if (!(player.hasPermission("managemyserver.toggleblockbreak"))) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't destroy blocks!");
            }
        }
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (ManageMyServer.getInstance().getConfig().getBoolean("block") == false) {
            if (!(player.hasPermission("managemyserver.toggleblockbreak"))) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't place blocks!");
            }
        }
    }
}
