package me.oeloheysmp.powers.powers.goldenPaw;

import me.oeloheysmp.powers.utils.checkPlayerItems;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

/*
Currently untested
using id "golden_paw"
uuid for attribute: "b4e53dc2-f228-406a-9f96-e29283f94032"
*/

public class goldenPaw extends BukkitRunnable {


    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            AttributeModifier speedModifier = new AttributeModifier(UUID.fromString("b4e53dc2-f228-406a-9f96-e29283f94032"), "generic.movementSpeed", 0.15, AttributeModifier.Operation.ADD_NUMBER);
            AttributeInstance speedAttribute = player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);

            if(checkPlayerItems.hasCustomItem(player, "golden_paw")) { // check if player has the golden_paw item in there inventory

                // give potion effect
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 1, false, false));

                // add attribute
                assert speedAttribute != null;
                speedAttribute.addModifier(speedModifier);
            }
            else{
                // Remove attributes
                assert speedAttribute != null;
                speedAttribute.removeModifier(speedModifier);
            }
        }
    }
}
