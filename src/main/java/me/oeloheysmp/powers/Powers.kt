package me.oeloheysmp.powers

import me.oeloheysmp.powers.powers.WindMedallion
import me.oeloheysmp.powers.utils.ConfigUtil
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Powers : JavaPlugin() {

    override fun onEnable() {
        instance = this

        ConfigUtil.init()


        Bukkit.getPluginManager().registerEvents(WindMedallion(), this)

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    companion object{
        lateinit var instance : Powers
        var Cooldowns : HashMap<String, Int> = HashMap()

    }
}