package ebt.common;
 
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = "mod", name = "Everything But The", version = "1.0")
 
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
 
public class EverythingButThe {
       
	@Instance
	//Declaring Instance//
	public static EverythingButThe instance = new EverythingButThe();
	
		
	//Declaring Blocks//
	public static Block chromiumOre;
	public static Block magnesiumOre;
	public static Block nickelOre;
	
	
	//Declaring Items//
	public static Item blazeClump;
	public static Item blazeIngot;
	public static Item silicon;
	
	
	//Declaring Id's//
	public int chromiumOreBlockID = 250;
	public int magnesiumOreBlockID = 251;
	public int nickelOreBlockID = 252;
	
	public int blazeClumpID = 1200;
	public int blazeIngotID = 1201;
	public int siliconID = 1202;
	
	
	//The Client and Common Proxy//
	@SidedProxy(clientSide = "ebt.client.ClientProxy", serverSide = "ebt.common.CommonProxy")
	public static CommonProxy proxy;
	
	
	@PreInit
	public void PreLoad(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		int chromiumOreOreBlockID = config.getBlock("Chromium Ore Block ID", Configuration.CATEGORY_BLOCK, 120).getInt();
		int magnesiumOreBlockID = config.getBlock("Magnesium Ore Block ID", Configuration.CATEGORY_BLOCK, 121).getInt();
		int nickelOreBlockID = config.getBlock("Nickel Ore Block ID", Configuration.CATEGORY_BLOCK, 122).getInt();
		
		int blazeClumpID = config.getItem("Blaze Clump ID", Configuration.CATEGORY_ITEM, 1200).getInt();
		int blazeIngotID = config.getItem("Blaze Ingot ID", Configuration.CATEGORY_ITEM, 1201).getInt();
		int siliconID = config.getItem("Silicon ID", Configuration.CATEGORY_ITEM, 1202).getInt();
		
		config.save();
	}
	
	
	
	//The Mod//
	@Init
	public void load(FMLInitializationEvent event) {
        		
		//Defining Blocks//
		chromiumOre = new BlockChromiumOre(chromiumOreBlockID, 0).setBlockName("chromiumOreOre");
		magnesiumOre = new BlockMagnesiumOre(magnesiumOreBlockID, 1).setBlockName("magnesiumOre");
		nickelOre = new BlockNickelOre(nickelOreBlockID, 2).setBlockName("nickelOre");
		
		
		//Defining Items//
		blazeClump = new ItemBlazeClump(blazeClumpID).setItemName("blazeClump");
		blazeIngot = new ItemBlazeIngot(blazeIngotID).setItemName("blazeIngot");
		silicon = new ItemSilicon(siliconID).setItemName("silicon");
		
		
		//Registering Blocks//
		GameRegistry.registerBlock(chromiumOre);
		GameRegistry.registerBlock(magnesiumOre);
		GameRegistry.registerBlock(nickelOre);
		GameRegistry.registerWorldGenerator(new WorldGen());
		
		
		//Adding Recipes//
		GameRegistry.addShapelessRecipe(new ItemStack(this.blazeClump, 1), new Object[]{
			Item.blazeRod
		});
		
		
		//The Proxy//
		proxy.registerRenderThings();
		
		
		//Registering Names - These Are The ACTUAL Names//
		LanguageRegistry.addName(chromiumOre, "Chromium Ore");
		LanguageRegistry.addName(magnesiumOre, "Magnesium Ore");
		LanguageRegistry.addName(nickelOre, "Nickel Ore");
		
		LanguageRegistry.addName(blazeClump, "Blaze Clump");
		LanguageRegistry.addName(blazeIngot, "Blaze Ingot");
		LanguageRegistry.addName(silicon, "Silicon");

	}
       
}