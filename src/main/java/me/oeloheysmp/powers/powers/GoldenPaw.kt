package me.oeloheysmp.powers.powers

import me.oeloheysmp.powers.utils.CheckPlayerItems.hasCustomItem
import org.bukkit.Bukkit
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable
import java.util.*

/*
Currently untested
using id "golden_paw"
uuid for attribute: "b4e53dc2-f228-406a-9f96-e29283f94032"
*/
class GoldenPaw() : BukkitRunnable() {
    override fun run() {
        for (player in Bukkit.getOnlinePlayers()) {
            player.sendMessage("test")
            val speedModifier = AttributeModifier(
                UUID.fromString("b4e53dc2-f228-406a-9f96-e29283f94032"),
                "generic.movementSpeed",
                0.15,
                AttributeModifier.Operation.ADD_NUMBER
            )
            val speedAttribute = player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)
            if (hasCustomItem(player, "golden_paw")) { // check if player has the golden_paw item in there inventory

                // give potion effect
                player.addPotionEffect(PotionEffect(PotionEffectType.JUMP, 100, 1, false, false))
                assert(speedAttribute != null)
                speedAttribute!!.addModifier(speedModifier)
            } else {
                // Remove attributes
                assert(speedAttribute != null)
                speedAttribute!!.removeModifier(speedModifier)
            }
        }
    }
}