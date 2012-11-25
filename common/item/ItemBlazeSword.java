package ebt.common.item;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemSword;

public class ItemBlazeSword extends ItemSword {
	protected int damage;
	protected int enchantability;
	
	public ItemBlazeSword(int itemID, EnumToolMaterial enumtoolmaterial) {
		super(itemID, enumtoolmaterial);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxDamage(1000);
		damage = 7;
		enchantability = 14;
	}
	
	//This is the fire attack//
	public boolean hitEntity(ItemStack itemstack, EntityLiving entityLiving, EntityLiving entityLiving1) {
		itemstack.damageItem(2000, entityLiving1);
		entityLiving.setFire(5);
		return true;
	}
	
	public int getDamageVsEntity(Entity entity) {
		return damage;
	}
	
	public int getItemEnchantabliity() {
		return enchantability;
	}
	
	//This is the texture file//
	public String getTextureFile() {
		return "/ebt.client/resources/items.png";
	}
}