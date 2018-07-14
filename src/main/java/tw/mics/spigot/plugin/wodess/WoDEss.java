package tw.mics.spigot.plugin.wodess;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import tw.mics.spigot.plugin.wodess.listener.LiquidLimitListener;
import tw.mics.spigot.plugin.wodess.listener.SpeedElytraLimitListener;

public class WoDEss extends JavaPlugin {
    static JavaPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        //設定世界
        WorldSetting.runsetting();

        //註冊 listener
        new LiquidLimitListener(this);
        new SpeedElytraLimitListener(this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll();
        this.getServer().getScheduler().cancelAllTasks();
    }

    public static JavaPlugin getInstance() {
        return instance;
    }

    // log system
    public void log(String str, Object... args) {
        String message = String.format(str, args);
        getLogger().info(message);
    }
}
