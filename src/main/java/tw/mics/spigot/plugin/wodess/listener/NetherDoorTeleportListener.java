package tw.mics.spigot.plugin.wodess.listener;

import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import tw.mics.spigot.plugin.wodess.WoDEss;;

public class NetherDoorTeleportListener extends MyListener {
    public NetherDoorTeleportListener(WoDEss instance) {
        super(instance);
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e) {
        if (
                e.getCause() == TeleportCause.NETHER_PORTAL && 
                e.getTo().getWorld().getEnvironment() == Environment.NORMAL
        ) {
            Player p = e.getPlayer();
            plugin.netherdoor.setTeleportLocation(p, e.getFrom(), e.getTo());
        }
    }
}