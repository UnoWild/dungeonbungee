package org.dungeonrealms.bungee.event;

import java.util.logging.Level;

/**
 * Created by Giovanni on 9-8-2016.
 */
public interface IBungeeEvent
{
    void setLogLevel(Level level);

    void setLogMessage(String message);
}
