package me.oeloheysmp.powers

import me.oeloheysmp.powers.Commands.Quack
import me.oeloheysmp.powers.powers.GoldenPaw
import me.oeloheysmp.powers.powers.WindMedallion
import me.oeloheysmp.powers.utils.ConfigUtil
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Powers : JavaPlugin() {

    override fun onEnable() {
        instance = this

        ConfigUtil.init()

        // Powers
        Bukkit.getPluginManager().registerEvents(WindMedallion(), this)

        //Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, GoldenPaw(), 0 ,20) // oelohey please fix

        // Commands
        getCommand("quack")?.setExecutor(Quack)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    companion object{
        lateinit var instance : Powers

        var Cooldowns : HashMap<String, Int> = HashMap()
    }
}