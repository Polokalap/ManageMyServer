package mel.polokalap.manageMyServer.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class kickall implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        if (cmd.getName().equalsIgnoreCase("kickall")) {
            if (sender.hasPermission("managemyserver.kickall")) {
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    if (!(onlinePlayer.getName() == sender.getName())) {
                        onlinePlayer.kick();
                    }
                }
            }
        }
        return true;
    }
}
