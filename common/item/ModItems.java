package ebt.common.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ebt.common.block.ModBlocks;
import ebt.common.lib.ItemIds;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.EnumHelper;
import ebt.common.EverythingButThe;

public class ModItems {
	
	public static Item ingotChromium;
	public static Item ingotMagnesium;
	public static Item clumpBlaze;
	public static Item ingotBlaze;
	public static Item silicon;
	
	public static Item blazeSword;
	public static Item slingshot;
	public static Item pebble;
	
	static EnumToolMaterial BlazeTool = EnumHelper.addToolMaterial("Blaze", 0, 400, 7F, 4, 14);
	
	public static void init() {
		
		//Defining Items//
		ingotChromium = new ItemIngotChromium(ItemIds.INGOT_CHROMIUM_DEFAULT) .setIconIndex(4) .setItemName("ingotChromium");
		ingotMagnesium = new ItemIngotMagnesium(ItemIds.INGOT_MAGNESIUM_DEFAULT) .setIconIndex(5) .setItemName("ingotMagnesium");
		clumpBlaze = new ItemClumpBlaze(ItemIds.BLAZE_CLUMP_DEFAULT) .setIconIndex(0) .setItemName("clumpBlaze");
		ingotBlaze = new ItemIngotBlaze(ItemIds.BLAZE_INGOT_DEFAULT) .setIconIndex(1) .setItemName("ingotBlaze");
		silicon = new ItemSilicon(ItemIds.SILICON_DEFAULT) .setIconIndex(3) .setItemName("silicon");
		pebble = new ItemPebble(ItemIds.PEBBLE_DEFAULT) .setIconIndex(2) .setItemName("pebble");
		
		blazeSword = new ItemBlazeSword(ItemIds.BLAZE_SWORD_DEFAULT, BlazeTool).setIconIndex(16) .setItemName("blazeSword"); 
		slingshot = new ItemSlingshot(ItemIds.SLINGSHOT_DEFAULT) .setIconIndex(12) .setItemName("slingshot");
		
		
		LanguageRegistry.addName(ingotChromium, "Chromium Ingot");
		LanguageRegistry.addName(ingotMagnesium, "Magnesium Ingot");
		LanguageRegistry.addName(clumpBlaze, "Blaze Clump");
		LanguageRegistry.addName(ingotBlaze, "Blaze Ingot");
		LanguageRegistry.addName(silicon, "Silicon");
		
		LanguageRegistry.addName(blazeSword, "Blaze Sword"); 
		LanguageRegistry.addName(slingshot, "Slingshot");
		LanguageRegistry.addName(pebble, "Pebble");
		
		
		
		GameRegistry.addSmelting(ModBlocks.oreChromium.blockID, new ItemStack(ingotChromium), .1F);
		GameRegistry.addSmelting(ModBlocks.oreMagnesium.blockID, new ItemStack(ingotMagnesium), .1F);
		GameRegistry.addSmelting(clumpBlaze.shiftedIndex, new ItemStack(ingotBlaze), .1F);
		
		
		GameRegistry.addRecipe(new ItemStack(clumpBlaze), new Object[]{
			"XX", "XX", 'X', Item.blazeRod
		});		
		GameRegistry.addRecipe(new ItemStack(blazeSword), new Object[]{
			" X ", " X ", " Y ", 'X', ingotBlaze, 'Y', Item.blazeRod
		});
	}
}
