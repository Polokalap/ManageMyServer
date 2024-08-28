package mel.polokalap.manageMyServer.Commands;

import mel.polokalap.manageMyServer.ManageMyServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class vanish implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        //dont use this, this is buggy as hell please dont use this
        if (cmd.getName().equalsIgnoreCase("vanish")) {
            if (sender.hasPermission("managemyserver.vanish")) {
                Player player = (Player) sender;
                if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                    player.sendMessage(ChatColor.GREEN + "Players can see you!");
                    player.removePotionEffect(PotionEffectType.INVISIBILITY);
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        onlinePlayer.showPlayer(ManageMyServer.getInstance(), player);
                        onlinePlayer.sendMessage(ManageMyServer.getInstance().getConfig().getString("welcome").replaceAll("%player%", player.getName()));
                    }
                }
                else {
                    player.sendMessage(ChatColor.GREEN + "Players can no longer see you!");
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 8000000, 1, true, true, false));
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        onlinePlayer.hidePlayer(ManageMyServer.getInstance(), player);
                        onlinePlayer.sendMessage(ManageMyServer.getInstance().getConfig().getString("quit").replaceAll("%player%", player.getName()));
                    }
                }
            }
            else {
                sender.sendMessage(ChatColor.RED + "You don't have the permisson to do that.");
            }
        }
        return true;
    }
}
