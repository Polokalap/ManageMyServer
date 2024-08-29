package mel.polokalap.manageMyServer.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class sit implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        if (cmd.getName().equalsIgnoreCase("sit")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (player.hasPermission("managemyserver.sit")) {
                    makePlayerSit(player);
                    player.sendMessage(ChatColor.GREEN + "You are now sitting.");
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            }
        }
        return true;
    }

    private void makePlayerSit(Player player) {
        Location loc = player.getLocation();

        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);

        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setSmall(true);
        armorStand.setMarker(true);
        armorStand.setInvulnerable(true);

        armorStand.addPassenger(player);
    }
}