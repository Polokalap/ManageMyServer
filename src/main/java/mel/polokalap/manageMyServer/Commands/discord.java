package mel.polokalap.manageMyServer.Commands;

import mel.polokalap.manageMyServer.ManageMyServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class discord implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        if (cmd.getName().equalsIgnoreCase("discord")) {
            Player player = (Player) sender;
            player.sendMessage(ManageMyServer.getInstance().getConfig().getString("discord"));
        }
        return true;
    }
}
