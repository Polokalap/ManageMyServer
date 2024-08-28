package mel.polokalap.manageMyServer;

import mel.polokalap.manageMyServer.Commands.fly;
import mel.polokalap.manageMyServer.Commands.rlconfig;
import mel.polokalap.manageMyServer.Commands.vanish;
import mel.polokalap.manageMyServer.Listeners.join;
import mel.polokalap.manageMyServer.Listeners.modt;
import mel.polokalap.manageMyServer.Listeners.quit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ManageMyServer extends JavaPlugin {

    private static ManageMyServer instance;

    @Override
    public void onEnable() {
        getLogger().info("The plugin has started!");
        register_events();
        register_commands();
        getConfig().options().copyDefaults(true);
        saveConfig();

        instance = this;
    }

    public void register_events() {
        getServer().getPluginManager().registerEvents(new modt(), this);
        getServer().getPluginManager().registerEvents(new join(), this);
        getServer().getPluginManager().registerEvents(new quit(), this);
    }

    public void register_commands() {
        getCommand("rlconfig").setExecutor(new rlconfig());
        getCommand("fly").setExecutor(new fly());
        getCommand("vanish").setExecutor(new vanish());
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has shut down.");
    }

    public static ManageMyServer getInstance() {
        return instance;
    }
}
