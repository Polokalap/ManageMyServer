package mel.polokalap.manageMyServer.Listeners;

import mel.polokalap.manageMyServer.ManageMyServer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class chat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (ManageMyServer.getInstance().getConfig().getBoolean("log")) {
            Player player = event.getPlayer();
            String message = String.format("%s> %s", player.getName(), event.getMessage());
            sendDiscordMessage(message);
        }
    }

    private void sendDiscordMessage(String message) {
        try {
            String webhookUrl = ManageMyServer.getInstance().getConfig().getString("webhook");
            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            String jsonPayload = String.format("{\"content\":\"%s\"}", message);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonPayload.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                ManageMyServer.getInstance().getLogger().warning("Failed to send message to Discord webhook. Response code: " + responseCode);
            }

        } catch (Exception e) {
            ManageMyServer.getInstance().getLogger().severe("Error sending message to Discord webhook: " + e.getMessage());
            e.printStackTrace();
        }
    }
}