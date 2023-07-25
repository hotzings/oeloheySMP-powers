package me.oeloheysmp.powers

import me.oeloheysmp.powers.powers.goldenPaw.goldenPaw
import org.bukkit.plugin.java.JavaPlugin

class Powers : JavaPlugin() {

    override fun onEnable() {
        instance = this

        // Schedule a repeating task to run every 20 ticks (1 second)
        server.scheduler.runTaskTimer(this, ::goldenPaw, 0, 20)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    companion object{
        lateinit var instance : Powers
    }
}