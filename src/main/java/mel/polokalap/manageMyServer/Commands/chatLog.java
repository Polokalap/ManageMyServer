package mel.polokalap.manageMyServer.Commands;

import mel.polokalap.manageMyServer.ManageMyServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class chatLog implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        if (cmd.getName().equalsIgnoreCase("chatLog")) {
            if (sender.hasPermission("managemyserver.chatlog")) {
                ManageMyServer.getInstance().getConfig().set("log", !ManageMyServer.getInstance().getConfig().getBoolean("log"));
                ManageMyServer.getInstance().saveConfig();
                ManageMyServer.getInstance().reloadConfig();

                if (ManageMyServer.getInstance().getConfig().getBoolean("log") == true) {
                    sender.sendMessage(ChatColor.GREEN + "Chat log is now tuned on! edit the webhook url in confim.yml.");
                }
                if (ManageMyServer.getInstance().getConfig().getBoolean("log") == false) {
                    sender.sendMessage(ChatColor.GREEN + "Chat log is now tuned off!");
                }
            }
            else {
                sender.sendMessage(ChatColor.RED + "YOu don't have the permisson to do this.");
            }
        }
        return true;
    }
}
