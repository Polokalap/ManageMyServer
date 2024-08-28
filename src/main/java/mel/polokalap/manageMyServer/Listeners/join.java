package mel.polokalap.manageMyServer.Listeners;

import mel.polokalap.manageMyServer.ManageMyServer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class join implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage(ManageMyServer.getInstance().getConfig().getString("welcome").replaceAll("%player%", player.getName()));
    }
}
