package ebt.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemSilicon extends Item {
	public ItemSilicon(int blockID) {
		super(blockID);
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	//This is the texture file//
	public String getTextureFile(){
		return "/Tile.png";
	}
}