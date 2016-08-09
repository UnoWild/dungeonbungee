package org.dungeonrealms.bungee.handshake;

/**
 * Created by Giovanni on 9-8-2016.
 * TODO
 */
public class Handshake
{
    private Side side;

    public Handshake(Side side)
    {
        this.side = side;
    }

    public Side getSide()
    {
        return side;
    }

    public boolean iSide(Side side)
    {
        return side == getSide();
    }
}
