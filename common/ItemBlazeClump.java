package ebt.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemBlazeClump extends Item {
	public ItemBlazeClump(int itemID) {
		super(itemID);
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	//This is the texture file//
	public String getTextureFile(){
		return "/ebt.client/resources/items.png";
	}
}
