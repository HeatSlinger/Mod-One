package ebt.common.item;

import ebt.common.lib.Reference;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemPebble extends Item {
	public ItemPebble(int itemID) {
		super(itemID);
		this.setIconIndex(2);
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	//This is the texture file//
	public String getTextureFile(){
		return Reference.ITEM_SPRITE_SHEET;
	}
}
