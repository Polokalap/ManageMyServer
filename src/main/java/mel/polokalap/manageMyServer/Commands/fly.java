package mel.polokalap.manageMyServer.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class fly implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("managemyserver.fly")) {

                    Player player = (Player) sender;

                    if (player.getAllowFlight()) {
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.sendMessage(ChatColor.GREEN + "You are no longer flying!");
                    } else {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendMessage(ChatColor.GREEN + "You are now flying!");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have the right permisson to do that!");
                }
            }
            else {
                sender.sendMessage(ChatColor.RED + "You must be a player to run this command!");
            }
        }
        return true;
    }
}
