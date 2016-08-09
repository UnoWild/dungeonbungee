package org.dungeonrealms.bungee.handshake.test;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.dungeonrealms.bungee.DungeonBungee;
import org.dungeonrealms.bungee.handshake.Handshake;
import org.dungeonrealms.bungee.handshake.Side;
import org.dungeonrealms.bungee.player.VProxiedPlayer;

import java.util.logging.Level;

/**
 * Created by Giovanni on 9-8-2016.
 * <p>
 * This is a test..
 */
public class BambooShake extends Handshake
{
    public BambooShake(String message, ProxiedPlayer proxiedPlayer)
    {
        super(Side.SERVER);
        if (this.getSide() == Side.SERVER)
        {
            DungeonBungee.getBungeeLogger().log(Level.INFO, message);
        } else
        {
            new VProxiedPlayer(proxiedPlayer).sendMessage(a(), true);
        }
    }

    public String a()
    {
        return "I think Bamboo is mad at me?";
    }
}
