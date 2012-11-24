package ebt.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Enchantment;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBow;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemSlingshot extends Item {

	public ItemSlingshot(int itemID) {
		super(itemID);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.maxStackSize = 1;
		setMaxDamage(5000);
	}
}
