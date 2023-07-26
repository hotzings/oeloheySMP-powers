package me.oeloheysmp.powers.powers

import me.oeloheysmp.powers.Powers
import me.oeloheysmp.powers.utils.ColorUtil
import me.oeloheysmp.powers.utils.ConfigUtil
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.scheduler.BukkitRunnable

class WindMedallion : Listener {

    @EventHandler
    fun windDash(event: PlayerInteractEvent) {

        var ownerPlayerName = ConfigUtil.getConfig()?.getString("WIND_MEDALLION.OWNER")
        var player = event.player

        if (event.action == Action.RIGHT_CLICK_AIR){
            if (player.name == ownerPlayerName){
                if(Powers.Cooldowns["${player.name}.WIND_DASH"] == null || Powers.Cooldowns["${player.name}.WIND_DASH"] == 0) {
                    player.sendMessage(ColorUtil.CC("Used Wind Dash"))

                    player.velocity = player.location.direction.multiply(5)

                    Powers.Cooldowns["${player.name}.WIND_DASH"] = 10

                    object : BukkitRunnable() {
                        override fun run() {
                            if (Powers.Cooldowns["${player.name}.WIND_DASH"]!! > 0) {
                                Powers.Cooldowns["${player.name}.WIND_DASH"] = Powers.Cooldowns["${player.name}.WIND_DASH"]!! - 1
                            } else {
                                Powers.Cooldowns["${player.name}.WIND_DASH"] = 0
                                cancel()
                            }
                        }

                    }.runTaskTimerAsynchronously(Powers.instance, 0, 20)


                }
            }

        }



    }



}