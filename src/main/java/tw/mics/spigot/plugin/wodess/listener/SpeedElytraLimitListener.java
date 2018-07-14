package tw.mics.spigot.plugin.wodess.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import tw.mics.spigot.plugin.wodess.WoDEss;

public class SpeedElytraLimitListener extends MyListener {
    static double ELYTRA_SPEED_LIMIT_SPEED = 0.9;
    
    public SpeedElytraLimitListener(WoDEss instance) {
        super(instance);
    }

    // 限制鞘翅速度
    @EventHandler
    public void onPlayerFly(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(!p.isGliding())return;
        Vector v = p.getVelocity();
        Double speed = Math.sqrt(Math.pow(v.getX(), 2.0) + Math.pow(v.getZ(), 2.0));
        if(speed > ELYTRA_SPEED_LIMIT_SPEED)
            p.setVelocity( v.multiply(ELYTRA_SPEED_LIMIT_SPEED/speed) );
    }
}