package org.dungeonrealms.bungee.event;

import net.md_5.bungee.api.plugin.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;

/**
 * Created by Giovanni on 9-8-2016.
 */
public class ReaderCloseEvent extends Event implements IBungeeEvent
{
    private Level logLevel;
    private BufferedReader bufferedReader;
    private String message;

    public ReaderCloseEvent(BufferedReader bufferedReader) throws IOException
    {
        this.bufferedReader = bufferedReader;
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

    public BufferedReader getBufferedReader()
    {
        return bufferedReader;
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
