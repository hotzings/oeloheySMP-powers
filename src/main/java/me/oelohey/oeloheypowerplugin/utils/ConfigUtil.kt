package me.oeloheysmp.powers.utils

import org.bukkit.configuration.file.FileConfiguration

class ConfigUtil {

    companion object{
        var configuration: FileConfiguration? = null

        fun getConfig(): FileConfiguration?{
            return configuration
        }

        fun init(){
            configuration = YamlConfigUtil("config.yml")
        }
    }
}