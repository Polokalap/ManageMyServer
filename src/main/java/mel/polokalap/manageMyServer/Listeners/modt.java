package mel.polokalap.manageMyServer.Listeners;

import mel.polokalap.manageMyServer.ManageMyServer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class modt implements Listener {
    @EventHandler
    public void onRefresh(ServerListPingEvent event) {
        if (ManageMyServer.getInstance().getConfig().getBoolean("custommotd") == true) {
            event.setMotd(ManageMyServer.getInstance().getConfig().getString("motd"));
        }
    }
}
