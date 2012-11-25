package ebt.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemPebble extends Item {
	public ItemPebble(int itemID) {
		super(itemID);
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	//This is the texture file//
	public String getTextureFile(){
		return "/ebt.client/resources/items.png";
	}
}
