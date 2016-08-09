package org.dungeonrealms.bungee;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import org.dungeonrealms.bungee.event.ReaderCloseEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Giovanni on 9-8-2016.
 */
public class DungeonBungee extends Plugin
{
    private static final Logger log = Logger.getLogger(DungeonBungee.class.getName());

    private static DungeonBungee instance;

    private static Configuration configuration;

    private static BufferedReader bufferedReader;

    public void onEnable()
    {
        log.log(Level.INFO, "Starting up [..]");

        instance = this;
    }

    private void createConfiguration()
    {
        if (getDataFolder().exists())
        {
            File file = new File(getDataFolder() + "bungee.yml");
            try
            {
                configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        } else
        {
            log.log(Level.WARNING, "Directory doesn't exist, create one? (Y/N)");
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (!locked())
            {
                try
                {
                    String command = bufferedReader.readLine();
                    if (command.contains("Y"))
                    {
                        getDataFolder().mkdir();
                    } else if (command.contains("N"))
                    {
                        bufferedReader.close();
                        getProxy().getPluginManager().callEvent(new ReaderCloseEvent(bufferedReader));
                        log.log(Level.INFO, "BufferedReader close, directory not initialized [..]");
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                } finally
                {
                    try
                    {
                        bufferedReader.close();
                        getProxy().getPluginManager().callEvent(new ReaderCloseEvent(bufferedReader));
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean locked()
    {
        return configuration.getBoolean("main.locked");
    }

    public static Logger getBungeeLogger()
    {
        return log;
    }

    public static DungeonBungee getInstance()
    {
        return instance;
    }

    public static Configuration getConfiguration()
    {
        return configuration;
    }

    public static BufferedReader getBufferedReader()
    {
        return bufferedReader;
    }
}
