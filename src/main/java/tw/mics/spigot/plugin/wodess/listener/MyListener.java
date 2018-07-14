
package tw.mics.spigot.plugin.wodess.listener;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import tw.mics.spigot.plugin.wodess.WoDEss;

public abstract class MyListener implements Listener {
	protected WoDEss plugin;
	public MyListener(WoDEss instance){
		this.plugin = instance;
	    this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}
	
	public void unregisterListener(){
		HandlerList.unregisterAll(this);
	}
}