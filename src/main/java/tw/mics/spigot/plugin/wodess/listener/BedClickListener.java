package tw.mics.spigot.plugin.wodess.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import tw.mics.spigot.plugin.wodess.WoDEss;

public class BedClickListener extends MyListener {
	public BedClickListener(WoDEss instance)
	{
	    super(instance);
	}
	
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.isCancelled())return;
        Block b = event.getClickedBlock();
        Player p = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(
                b.getType() == Material.BED_BLOCK &&
                b.getWorld().getEnvironment() == Environment.NORMAL &&
                !this.checkPlayerSpawn(b.getLocation(), p)
            ){
                p.setBedSpawnLocation(b.getLocation());
                p.sendMessage("重生點已紀錄。");
                event.setCancelled(true);
                return;
            }
        }
    }

    //確認玩家重生安全
	private boolean checkPlayerSpawn(Location l, Player p) {
        if(l == null || p.getBedSpawnLocation() == null) return false;
        if(l.getWorld() != p.getBedSpawnLocation().getWorld()) return false;
        Double dist = l.distance(p.getBedSpawnLocation());
        if(dist <= 2.24)
            return true;
        return false;
	}
}