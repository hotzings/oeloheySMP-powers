package me.oelohey.minicreates.utils
import org.bukkit.configuration.file.FileConfiguration

class configUtil {

    companion object{
        var configuration: FileConfiguration? = null

        fun getConfig(): FileConfiguration?{
            return configuration
        }

        fun init(){
            configuration = yamlConfigUtil("config.yml")
        }
    }
}