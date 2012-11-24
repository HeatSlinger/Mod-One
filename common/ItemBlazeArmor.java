package ebt.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemBlazeArmor extends ItemArmor implements IArmorTextureProvider {
	public ItemBlazeArmor(int blockID, EnumArmorMaterial enumArmorMaterialBlaze, int j, int k) {
		super(blockID, enumArmorMaterialBlaze, j, k);
		this.setCreativeTab(CreativeTabs.tabCombat);
		
	}
	
	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		 if(itemstack.itemID == EverythingButThe.blazeHelmet.shiftedIndex || itemstack.itemID == EverythingButThe.blazePlate.shiftedIndex || itemstack.itemID == EverythingButThe.blazeBoots.shiftedIndex) {
                         return "/ebt.client/resources/blaze1.png";
         }
         if(itemstack.itemID == EverythingButThe.blazeLegs.shiftedIndex) {
                         return "/ebt.client/resources/blaze2.png";
         }
		return null;
	}
	
	//This is the texture file//
	public String getTextureFile() {
		return "/items.png";
	}
}