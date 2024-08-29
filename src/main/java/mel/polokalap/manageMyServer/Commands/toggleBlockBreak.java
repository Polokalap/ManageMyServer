package mel.polokalap.manageMyServer.Commands;

import mel.polokalap.manageMyServer.ManageMyServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class toggleBlockBreak implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        if (cmd.getName().equalsIgnoreCase("toggleblockbreak")) {
            if (sender.hasPermission("managemyserver.toggleblockbreak")) {
                ManageMyServer.getInstance().getConfig().set("block", !ManageMyServer.getInstance().getConfig().getBoolean("block"));
                ManageMyServer.getInstance().saveConfig();
                ManageMyServer.getInstance().reloadConfig();
                if (ManageMyServer.getInstance().getConfig().getBoolean("block") == true) {
                    sender.sendMessage(ChatColor.GREEN + "You have enabled block break/place!");
                }
                if (ManageMyServer.getInstance().getConfig().getBoolean("block") == false) {
                    sender.sendMessage(ChatColor.GREEN + "You have disabled block break/place!");
                }
            }
            else {
                sender.sendMessage(ChatColor.RED + "You don't have permisson to do that!");
            }
        }
        return true;
    }
}
