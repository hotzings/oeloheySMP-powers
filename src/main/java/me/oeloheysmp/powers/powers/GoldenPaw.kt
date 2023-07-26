package me.oeloheysmp.powers.powers

import me.oeloheysmp.powers.utils.CheckPlayerItems.hasCustomItem
import org.bukkit.Bukkit
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import java.util.*

/*
Currently untested
using id "golden_paw"
uuid for speed attribute: "b4e53dc2-f228-406a-9f96-e29283f94032"
uuid for damage attribute: b4e53dc2-f228-406a-9f96-e29283f94033
*/
class GoldenPaw(){
    fun run() {
        for (player in Bukkit.getOnlinePlayers()) {
            player.sendMessage("test")
            val SpeedModifier = AttributeModifier(
                UUID.fromString("b4e53dc2-f228-406a-9f96-e29283f94032"),
                "generic.movementSpeed",
                0.15,
                AttributeModifier.Operation.ADD_NUMBER
            )
            val DamageModifier = AttributeModifier(
                UUID.fromString("b4e53dc2-f228-406a-9f96-e29283f94033"),
                "generic.attack_damage",
                1.1,
                AttributeModifier.Operation.MULTIPLY_SCALAR_1
            )
            val speedAttribute = player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)
            val DamageAttribute = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)

            if (hasCustomItem(player, "golden_paw")) { // check if player has the golden_paw item in there inventory

                // give potion effect
                player.addPotionEffect(PotionEffect(PotionEffectType.JUMP, 100, 1, false, false))

                // give attributes
                assert(speedAttribute != null)
                speedAttribute!!.addModifier(SpeedModifier)
                DamageAttribute!!.addModifier(DamageModifier)
            } else {
                // Remove attributes
                assert(speedAttribute != null)
                speedAttribute!!.removeModifier(SpeedModifier)
                DamageAttribute!!.removeModifier(DamageModifier)
            }
        }
    }
}