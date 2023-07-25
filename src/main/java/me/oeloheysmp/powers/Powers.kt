package me.oeloheysmp.powers

import me.oeloheysmp.powers.powers.goldenPaw.goldenPaw
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Powers : JavaPlugin() {

    override fun onEnable() {
        instance = this
        print("Powers plugin booting up")

        // Schedule a repeating task to run every 20 ticks (1 second)
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, ::goldenPaw, 0, 20)

        print("powers plugin loaded")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    companion object{
        lateinit var instance : Powers
    }
}