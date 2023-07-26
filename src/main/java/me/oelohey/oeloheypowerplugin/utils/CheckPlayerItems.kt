package me.oeloheysmp.powers.utils

import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

object CheckPlayerItems {
    @JvmStatic
    fun hasCustomItem(player: Player, Id: String): Boolean { // Checks if the player has the item in there inventory
        val inv: Inventory = player.inventory // get the players inventory
        for (item in inv.contents!!) { // loop through the content
            if (item != null) {
                val data = item.itemMeta!!.asString // get nbt tags i think
                if (data.contains("itemsadder:{id:\"$Id\"")) { // check if it contains the items adder id for the item
                    return true
                }
            }
        }
        return false // return false if it failed the model check
    }

    fun hasCustomItemInMainHand(player: Player, ID: String): Boolean { // checks if the player is holding the item
        val item = player.inventory.itemInMainHand // get the players inventory
        val data = item.itemMeta!!.asString
        return data.contains("itemsadder:{id:\"$ID\"") // return false if it failed the model check
    }
}