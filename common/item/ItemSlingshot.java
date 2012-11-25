package ebt.common.item;

import ebt.common.EntityPebble;
import ebt.common.EverythingButThe;
import ebt.common.lib.Reference;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Enchantment;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBow;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemSlingshot extends Item {

	public ItemSlingshot(int itemID) {
		super(itemID);
		this.setIconIndex(12);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.maxStackSize = 1;
		this.setMaxDamage(500);
	}
	
	public int getIconIndex(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if (usingItem != null && usingItem.getItem().shiftedIndex == ModItems.slingshot.shiftedIndex) {
			int k = usingItem.getMaxItemUseDuration() - useRemaining;
			if (k >= 18) return 15;
			if (k > 11) return 14;
			if (k > 0) return 13;
		}
		return getIconIndex(stack);			
	}
	
	 public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
	        int var6 = this.getMaxItemUseDuration(par1ItemStack) - par4;
	        
	        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, var6);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled()) {
	            return;
	        }
	        var6 = event.charge;
	        
	        boolean var5 = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

	        if (var5 || par3EntityPlayer.inventory.hasItem(ModItems.pebble.shiftedIndex)) {
	            float var7 = (float)var6 / 20.0F;
	            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;

	            if ((double)var7 < 0.1D) {
	                return;
	            }

	            if (var7 > 1.0F) {
	                var7 = 1.0F;
	            }

	            EntityPebble var8 = new EntityPebble(par2World, par3EntityPlayer, var7 * 2.0F);

	            if (var7 == 1.0F) {
	                var8.setIsCritical(true);
	            }

	            int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

	            if (var9 > 0) {
	                var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
	            }

	            int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

	            if (var10 > 0) {
	                var8.setKnockbackStrength(var10);
	            }

	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0) {
	                var8.setFire(100);
	            }

	            par1ItemStack.damageItem(1, par3EntityPlayer);
	            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);

	            if (var5) {
	                var8.canBePickedUp = 2;
	            }
	            else {
	                par3EntityPlayer.inventory.consumeInventoryItem(ModItems.pebble.shiftedIndex);
	            }
	            if (!par2World.isRemote) {
	                par2World.spawnEntityInWorld(var8);
	            }
	        }
	    }

	    public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
	        return par1ItemStack;
	    }

	    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
	        return 72000;
	    }

	    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
	        return EnumAction.bow;
	    }

	    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
	        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled()) {
	            return event.result;
	        }
	        
	        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(ModItems.pebble.shiftedIndex)) {
	            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
	        }

	        return par1ItemStack;
	    }

	    public int getItemEnchantability() {
	        return 1;
	    }
    
    public String getTextureFile() {
    	return Reference.ITEM_SPRITE_SHEET;
    }

}
