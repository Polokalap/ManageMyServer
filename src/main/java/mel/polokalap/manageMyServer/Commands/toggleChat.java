package mel.polokalap.manageMyServer.Commands;

import mel.polokalap.manageMyServer.ManageMyServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class toggleChat implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        if (cmd.getName().equalsIgnoreCase("togglechat")) {
            if (sender.hasPermission("managemyserver.togglechat")) {
                ManageMyServer.getInstance().getConfig().set("chat", !ManageMyServer.getInstance().getConfig().getBoolean("chat"));
                ManageMyServer.getInstance().saveConfig();
                ManageMyServer.getInstance().reloadConfig();
                if (ManageMyServer.getInstance().getConfig().getBoolean("chat") == true) {
                    sender.sendMessage(ChatColor.GREEN + "You have enabled chat!");
                }
                if (ManageMyServer.getInstance().getConfig().getBoolean("chat") == false) {
                    sender.sendMessage(ChatColor.GREEN + "You have disabled chat!");
                }
            }
            else {
                sender.sendMessage(ChatColor.RED + "You don't have permisson to do that!");
            }
        }
        return true;
    }
}
