package ebt.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemPlateBlaze extends ItemArmor implements IArmorTextureProvider {
	public ItemPlateBlaze(int blockID, EnumArmorMaterial enumArmorMaterialBlaze, int par3, int par4) {
		super(blockID, enumArmorMaterialBlaze, par3, par4);
		this.setCreativeTab(CreativeTabs.tabCombat);
		
	}

	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		return null;
	}
	
}
