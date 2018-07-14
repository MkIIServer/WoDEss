package tw.mics.spigot.plugin.wodess;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.World.Environment;

public class WorldSetting {
    static public void runsetting(){
        List<World> worlds = Bukkit.getServer().getWorlds();
        for(World world : worlds){
            world.setGameRuleValue("maxEntityCramming", "8");
            if(world.getEnvironment() == Environment.NORMAL){
                world.getWorldBorder().setCenter(0, 0);
                world.getWorldBorder().setSize(32000);
            } else if (world.getEnvironment() == Environment.NETHER) {
                world.getWorldBorder().setCenter(0, 0);
                world.getWorldBorder().setSize(4000);
            } else if (world.getEnvironment() == Environment.THE_END) {
                world.getWorldBorder().setCenter(0, 0);
                world.getWorldBorder().setSize(20000);
            }
        }
    }
}