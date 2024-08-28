package mel.polokalap.manageMyServer.Commands;

import mel.polokalap.manageMyServer.ManageMyServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class rlconfig implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        if (cmd.getName().equalsIgnoreCase("rlconfig")) {
            if (sender.hasPermission("managemyserver.rlconfig")) {
                ManageMyServer.getInstance().reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "Plugin config has been reloaded.");
            }
            else {
                sender.sendMessage(ChatColor.RED + "You don't have the permisson to do that.");
            }
        }
        return true;
    }
}
