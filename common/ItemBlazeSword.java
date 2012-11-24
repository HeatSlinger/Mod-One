package ebt.common;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemSword;

public class ItemBlazeSword extends ItemSword {
	public ItemBlazeSword(int itemID, EnumToolMaterial enumtoolmaterial) {
		super(itemID, enumtoolmaterial);
	}
	
	//This is the fire attack//
	public boolean hitEntity(ItemStack itemstack, EntityLiving entityLiving, EntityLiving entityLiving1) {
		itemstack.damageItem(2000, entityLiving1);
		entityLiving.setFire(5);
		return true;
	}
	
	//This is the texture file//
	public String getTextureFile() {
		return "/ebt.client/resources/swords.png";
	}
}