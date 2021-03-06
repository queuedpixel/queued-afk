/*

queued-afk : Prevent players from being kicked for going AFK.

Copyright (c) 2020 Queued Pixel <git@queuedpixel.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

*/

package com.queuedpixel.queuedafk;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class QueuedAfkPlugin extends JavaPlugin implements Listener
{
    public void onEnable()
    {
        this.getServer().getPluginManager().registerEvents( this, this );
    }

    public void onDisable()
    {
    }

    @EventHandler
    public void onPlayerKickEvent( PlayerKickEvent event )
    {
        if (( event.getReason().equals( "You have been idle for too long!" )) &&
            ( event.getPlayer().hasPermission( "queuedafk.noafk" )))
        {
            this.getLogger().info( "Preventing player from being kicked: " + event.getPlayer().getName() );
            event.setCancelled( true );
        }
    }
}
