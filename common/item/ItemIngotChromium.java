package ebt.common.item;

import ebt.common.lib.Reference;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemIngotChromium extends Item {
	public ItemIngotChromium(int itemID) {
		super(itemID);
		this.setIconIndex(5);
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	//This is the texture file//
	public String getTextureFile(){
		return Reference.ITEM_SPRITE_SHEET;
	}
}
