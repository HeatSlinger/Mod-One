package ebt.common.core.handlers;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;

import ebt.common.lib.BlockIds;
import ebt.common.lib.ConfigurationSettings;
import ebt.common.lib.ItemIds;
import ebt.common.lib.Reference;
import ebt.common.lib.Strings;

import static net.minecraftforge.common.Configuration.*;

public class ConfigurationHandler {
	public static void init(File configFile) {
		Configuration configuration = new Configuration(configFile);
		
		try {
			configuration.load();
			
			ConfigurationSettings.AUTO_RESOLVE_BLOCK_IDS = configuration
		             .get(CATEGORY_BLOCK, ConfigurationSettings.AUTO_RESOLVE_BLOCK_IDS_CONFIGNAME, ConfigurationSettings.AUTO_RESOLVE_BLOCK_IDS_DEFAULT)
		             .getBoolean(ConfigurationSettings.AUTO_RESOLVE_BLOCK_IDS_DEFAULT);
			BlockIds.ORE_CHROMIUM = configuration
					.getBlock(Strings.ORE_CHROMIUM_NAME, BlockIds.ORE_CHROMIUM_DEFAULT)
					.getInt(BlockIds.ORE_CHROMIUM);
			BlockIds.ORE_MAGNESIUM = configuration
					.getBlock(Strings.ORE_MAGNESIUM_NAME, BlockIds.ORE_MAGNESIUM_DEFAULT)
					.getInt(BlockIds.ORE_MAGNESIUM);
			
			ItemIds.BLAZE_SWORD = configuration
		             .getItem(Strings.BLAZE_SWORD_NAME, ItemIds.BLAZE_SWORD_DEFAULT)
		             .getInt(ItemIds.BLAZE_SWORD_DEFAULT);
			ItemIds.BLAZE_CLUMP = configuration
		             .getItem(Strings.CLUMP_BLAZE_NAME, ItemIds.BLAZE_CLUMP_DEFAULT)
		             .getInt(ItemIds.BLAZE_CLUMP_DEFAULT);
			ItemIds.BLAZE_INGOT = configuration
		             .getItem(Strings.INGOT_BLAZE_NAME, ItemIds.BLAZE_INGOT_DEFAULT)
		             .getInt(ItemIds.BLAZE_INGOT_DEFAULT);
			ItemIds.INGOT_CHROMIUM = configuration
		             .getItem(Strings.INGOT_CHROMIUM_NAME, ItemIds.INGOT_CHROMIUM_DEFAULT)
		             .getInt(ItemIds.INGOT_CHROMIUM_DEFAULT);
			ItemIds.INGOT_MAGNESIUM = configuration
		             .getItem(Strings.INGOT_MAGNESIUM_NAME, ItemIds.INGOT_MAGNESIUM_DEFAULT)
		             .getInt(ItemIds.INGOT_MAGNESIUM_DEFAULT);
			ItemIds.PEBBLE = configuration
		             .getItem(Strings.PEBBLE_NAME, ItemIds.PEBBLE_DEFAULT)
		             .getInt(ItemIds.PEBBLE_DEFAULT);
			ItemIds.SILICON = configuration
		             .getItem(Strings.SILICON_NAME, ItemIds.SILICON_DEFAULT)
		             .getInt(ItemIds.SILICON_DEFAULT);
			ItemIds.SLINGSHOT = configuration
		             .getItem(Strings.SLINGSHOT_NAME, ItemIds.SLINGSHOT_DEFAULT)
		             .getInt(ItemIds.SLINGSHOT_DEFAULT);
			ItemIds.BLAZE_HELMET = configuration
		             .getItem(Strings.BLAZE_HELMET_NAME, ItemIds.BLAZE_HELMET_DEFAULT)
		             .getInt(ItemIds.BLAZE_HELMET_DEFAULT);
			ItemIds.BLAZE_CHEST = configuration
		             .getItem(Strings.BLAZE_CHEST_NAME, ItemIds.BLAZE_CHEST_DEFAULT)
		             .getInt(ItemIds.BLAZE_CHEST_DEFAULT);
			ItemIds.BLAZE_LEGS = configuration
		             .getItem(Strings.BLAZE_LEGS_NAME, ItemIds.BLAZE_LEGS_DEFAULT)
		             .getInt(ItemIds.BLAZE_LEGS_DEFAULT);
			ItemIds.BLAZE_BOOTS = configuration
		             .getItem(Strings.BLAZE_BOOTS_NAME, ItemIds.BLAZE_BOOTS_DEFAULT)
		             .getInt(ItemIds.BLAZE_BOOTS_DEFAULT);
		}
		
		
		catch (Exception e) {
	          FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
		}
		finally {
	            configuration.save();
		}
	}
}
