package net.lomeli.magiks.api;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;

/**
 * Used to gain access to blocks in the mod. Thanks to Azanor and his Thaumcraft
 * API, of which this API is based off of.
 * 
 * This gets the block by the name I gave the block class. For example, Mancery
 * glass is:
 * 
 * public static Block manceryGlass;
 * 
 * so, when using this api, I would do:
 * 
 * BlockAPI.getBlock("manceryGlass", 1);
 * 
 * You can check the block names in com.lomeli.magiks.blocks.ModBlocksMagiks in
 * the mod's source: https://github.com/Lomeli12/MechroMagiks
 * 
 * @author Anthony
 * 
 */
public class BlockAPI
{
    public static ItemStack getBlock(String itemString, int meta)
    {
        ItemStack item = null;

        try
        {
            String itemClass = "net.lomeli.magiks.blocks.ModBlocksMagiks";
            Object obj = Class.forName(itemClass).getField(itemString)
                    .get(null);
            if (obj instanceof Block)
            {
                item = new ItemStack((Block) obj, 1, meta);
            } else if (obj instanceof ItemStack)
            {
                item = (ItemStack) obj;
            }
        } catch (Exception ex)
        {
            FMLLog.warning("[MechroMagik] Could not retrieve block identified by: "
                    + itemString);
        }
        return item;
    }

    public static ItemStack getBlock(String itemString)
    {
        ItemStack item = null;

        try
        {
            String itemClass = "net.lomeli.magiks.blocks.ModBlocksMagiks";
            Object obj = Class.forName(itemClass).getField(itemString)
                    .get(null);
            if (obj instanceof Block)
            {
                item = new ItemStack((Block) obj);
            } else if (obj instanceof ItemStack)
            {
                item = (ItemStack) obj;
            }
        } catch (Exception ex)
        {
            FMLLog.warning("[MechroMagik] Could not retrieve block identified by: "
                    + itemString);
        }
        return item;
    }
}
