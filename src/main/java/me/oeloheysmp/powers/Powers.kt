package me.oeloheysmp.powers

import org.bukkit.plugin.java.JavaPlugin

class Powers : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        instance = this


    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    companion object{
        lateinit var instance : Powers


    }



}