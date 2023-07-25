package me.oeloheysmp.powers.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class checkPlayerItems {
    public static boolean hasCustomItem(Player player, String Id) { // Checks if the player has the item in there inventory
        Inventory inv = player.getInventory(); // get the players inventory

        for (ItemStack item : inv.getContents()) { // loop through the content
            if (item!=null){
                String data = item.getItemMeta().getAsString(); // get nbt tags i think

                if(data.contains("itemsadder:{id:\"" + Id + "\"")){ // check if it contains the items adder id for the item
                    return true;
                }
            }
        }
        return false; // return false if it failed the model check
    }

    public static boolean hasCustomItemInMainHand(Player player, String ID) { // checks if the player is holding the item
        ItemStack item = player.getInventory().getItemInMainHand(); // get the players inventory

        String data = item.getItemMeta().getAsString();

        return data.contains("itemsadder:{id:\"" + ID + "\"");// return false if it failed the model check
    }
}
