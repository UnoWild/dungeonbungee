package org.dungeonrealms.bungee.event;

import net.md_5.bungee.api.plugin.Event;
import org.dungeonrealms.bungee.player.VProxiedPlayer;

import java.util.logging.Level;

/**
 * Created by Giovanni on 9-8-2016.
 */
public class PlayerLoginFailEvent extends Event implements IBungeeEvent
{
    private Level logLevel;
    private String message;
    private VProxiedPlayer proxiedPlayer;

    public PlayerLoginFailEvent(VProxiedPlayer proxiedPlayer)
    {
        this.proxiedPlayer = proxiedPlayer;
    }

    @Override
    public void setLogLevel(Level logLevel)
    {
        this.logLevel = logLevel;
    }

    @Override
    public void setLogMessage(String message)
    {
        this.message = message;
    }

    public Level getLogLevel()
    {
        return logLevel;
    }

    public String getMessage()
    {
        return message;
    }

    public VProxiedPlayer getProxiedPlayer()
    {
        return proxiedPlayer;
    }
}
