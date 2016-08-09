package org.dungeonrealms.bungee.player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.dungeonrealms.bungee.DungeonBungee;
import org.dungeonrealms.bungee.player.prompt.DefaultFontInfo;

import java.util.logging.Level;

/**
 * Created by Giovanni on 9-8-2016.
 */
public class VProxiedPlayer
{
    private ProxiedPlayer proxiedPlayer;

    public VProxiedPlayer(ProxiedPlayer proxiedPlayer)
    {
        if (!proxiedPlayer.isConnected())
            DungeonBungee.getBungeeLogger().log(Level.WARNING, "VProxiedPlayer cannot be created if a ProxiedPlayer has not accepted handshake..");
        this.proxiedPlayer = proxiedPlayer;
    }

    public ProxiedPlayer asBungeePlayer()
    {
        return proxiedPlayer;
    }

    public void sendMessage(String message, boolean centered)
    {
        if (centered)
        {
            proxiedPlayer.sendMessage(new TextComponent(getCenteredMessage(message)));
        } else
        {
            proxiedPlayer.sendMessage(new TextComponent(message));
        }
    }

    /**
     * @apiNote https://www.spigotmc.org/threads/free-code-sending-perfectly-centered-chat-message.95872/
     */
    private String getCenteredMessage(String par)
    {
        if (par == null || par.equals("")) return "";
        par = ChatColor.translateAlternateColorCodes('&', par);

        int messagePxSize = 0;
        boolean previousCode = false;
        boolean isBold = false;

        for (char c : par.toCharArray())
        {
            if (c == '§')
            {
                previousCode = true;
            } else if (previousCode)
            {
                previousCode = false;
                isBold = c == 'l' || c == 'L';
            } else
            {
                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
                messagePxSize++;
            }
        }

        int halvedMessageSize = messagePxSize / 2;
        int toCompensate = DefaultFontInfo.getCenterPX() - halvedMessageSize;
        int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
        int compensated = 0;
        StringBuilder sb = new StringBuilder();
        while (compensated < toCompensate)
        {
            sb.append(" ");
            compensated += spaceLength;
        }
        return sb.toString() + par;
    }
}
