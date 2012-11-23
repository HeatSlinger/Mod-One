package ebt.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.Item;

public class ItemHelmetBlaze extends Item {
	public ItemHelmetBlaze(int blockID, EnumArmorMaterial enumArmorMaterialBlaze) {
		super(blockID);
		this.setCreativeTab(CreativeTabs.tabCombat);
		
	}
	
}
