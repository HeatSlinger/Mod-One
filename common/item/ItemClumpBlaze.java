package ebt.common.item;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemClumpBlaze extends Item {
	public ItemClumpBlaze(int itemID) {
		super(itemID);
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	//This is the texture file//
	public String getTextureFile(){
		return "/ebt.client/resources/items.png";
	}
}