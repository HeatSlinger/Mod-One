package ebt.common.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import ebt.common.EverythingButThe;
import ebt.common.lib.BlockIds;
import ebt.common.EverythingButThe;

public class ModBlocks {
	
	//Declaring Blocks//
	public static Block oreChromium;
	public static Block oreMagnesium;
	
	
	public static Block mercuryStill;
	public static Block mercuryFlowing;
	
	public static void init() {
		
		oreChromium = new BlockOreChromium(BlockIds.ORE_CHROMIUM, 0);
		oreMagnesium = new BlockOreMagnesium(BlockIds.ORE_MAGNESIUM, 1);
		

		
		GameRegistry.registerBlock(oreChromium);
		GameRegistry.registerBlock(oreMagnesium);
		

		
		LanguageRegistry.addName(oreChromium, "Chromium Ore");
		LanguageRegistry.addName(oreMagnesium, "Magnesium Ore");
		

		
	}
}
