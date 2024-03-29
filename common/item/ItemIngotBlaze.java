package ebt.common.item;

import ebt.common.lib.Reference;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemIngotBlaze extends Item {
	public ItemIngotBlaze(int itemID) {
		super(itemID);
		this.setIconIndex(1);
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	//This is the texture file//
	public String getTextureFile(){
		return Reference.ITEM_SPRITE_SHEET;
	}
}
