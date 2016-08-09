package org.dungeonrealms.bungee.event;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Event;
import org.dungeonrealms.bungee.player.VProxiedPlayer;

import java.util.logging.Level;

/**
 * Created by Giovanni on 9-8-2016.
 */
public class HandshakeStartEvent extends Event implements IBungeeEvent
{
    private Level logLevel;
    private String message;
    private VProxiedPlayer vProxiedPlayer;
    private ProxyServer proxyServer;

    public HandshakeStartEvent(ProxyServer proxyServer, VProxiedPlayer vProxiedPlayer)
    {
        this.proxyServer = proxyServer;
        this.vProxiedPlayer = vProxiedPlayer;
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
}
