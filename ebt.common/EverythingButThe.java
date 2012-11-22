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
	
	//Declaring Items//
	public static Item blazeClump;
	
	//Declaring Id's//
	public int chromiumOreBlockID = 250;
	public int magnesiumOreBlockID = 251;
	public int blazeClumpID = 1200;
	
	//The Client and Common Proxy//
	@SidedProxy(clientSide = "ebt.client.ClientProxy", serverSide = "ebt.common.CommonProxy")
	public static CommonProxy proxy;
	
	
	@PreInit
	public void PreLoad(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		int chromiumOreOreBlockID = config.getBlock("Chromium Ore Block ID", Configuration.CATEGORY_BLOCK, 120).getInt();
		int magnesiumOreBlockID = config.getBlock("Magnesium Ore Block ID", Configuration.CATEGORY_BLOCK, 121).getInt();
		
		config.save();
	}
	
	
	
	//The Mod//
	@Init
	public void load(FMLInitializationEvent event) {
        		
		//Defining Blocks//
		chromiumOre = new ChromiumOre(chromiumOreBlockID).setBlockName("chromiumOreOre");
		magnesiumOre = new MagnesiumOre(magnesiumOreBlockID).setBlockName("magnesiumOre");
		
		
		//Defining Items//
		blazeClump = new BlazeClump(blazeClumpID).setItemName("blazeClump");
		
		
		//Registering Blocks//
		GameRegistry.registerBlock(chromiumOre);
		GameRegistry.registerBlock(magnesiumOre);
		GameRegistry.registerWorldGenerator(new WorldGen());
		
		
		
		//Ore Registration//
		
		
		//Adding Recipes//
		GameRegistry.addRecipe(new ItemStack(this.blazeClump, 1), new Object[]{
			" X ", " X ", " X ", Character.valueOf('X'), Item.blazeRod
		});
		
		
		//The Proxy//
		proxy.registerRenderThings();
		
		
		//Registering Names//
		LanguageRegistry.addName(chromiumOre, "Chromium Ore");
		LanguageRegistry.addName(magnesiumOre, "Magnesium Ore");
		LanguageRegistry.addName(blazeClump, "Blaze Clump");

	}
       
}