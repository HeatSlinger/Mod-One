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
	public static Block oreChromium;
	public static Block oreMagnesium;
	
	
	//Declaring Items//
	public static Item blazeClump;
	public static Item blazeIngot;
	public static Item silicon;
	
	
	//Declaring Tools or Armor//
	public static Item blazeHelmet;
	public static Item blazePlate;
	public static Item blazeLegs;
	public static Item blazeBoots;
	
	
	//Declaring Id's//
	public int oreChromiumBlockID = 250;
	public int oreMagnesiumBlockID = 251;
	public int nickelOreBlockID = 252;
	
	public int blazeClumpID = 1200;
	public int blazeIngotID = 1201;
	public int siliconID = 1202;
	public int blazeHelmetID = 1203;
	public int blazePlateID = 1204;
	public int blazeLegsID = 1205;
	public int blazeBootsID = 1206;
	
	
	//The Client and Common Proxy//
	@SidedProxy(clientSide = "ebt.client.ClientProxy", serverSide = "ebt.common.CommonProxy")
	public static CommonProxy proxy;
	
	
	//Material//
	static EnumArmorMaterial EnumArmorMaterialBlaze = EnumHelper.addArmorMaterial("BlazeArmor", 20, new int[]{2, 6, 4, 3}, 17)
	
	
	@PreInit
	public void PreLoad(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		int oreoreChromiumBlockID = config.getBlock("Chromium Ore Block ID", Configuration.CATEGORY_BLOCK, 120).getInt();
		int oreMagnesiumBlockID = config.getBlock("Magnesium Ore Block ID", Configuration.CATEGORY_BLOCK, 121).getInt();
		
		int blazeClumpID = config.getItem("Blaze Clump ID", Configuration.CATEGORY_ITEM, 1200).getInt();
		int blazeIngotID = config.getItem("Blaze Ingot ID", Configuration.CATEGORY_ITEM, 1201).getInt();
		int siliconID = config.getItem("Silicon ID", Configuration.CATEGORY_ITEM, 1202).getInt();
		
		config.save();
	}
	
	
	
	//The Mod//
	@Init
	public void load(FMLInitializationEvent event) {
        		
		//Defining Blocks//
		oreChromium = new BlockOreChromium(oreChromiumBlockID, 0).setBlockName("oreoreChromium");
		oreMagnesium = new BlockOreMagnesium(oreMagnesiumBlockID, 1).setBlockName("oreMagnesium");
		
		
		//Defining Items//
		blazeClump = new ItemBlazeClump(blazeClumpID).setItemName("blazeClump");
		blazeIngot = new ItemBlazeIngot(blazeIngotID).setItemName("blazeIngot");
		silicon = new ItemSilicon(siliconID).setItemName("silicon");
		
		
		//Defining Tools or Armor//
		blazeHelmet = new ItemblazeHelmet(1203,EnumArmorMaterialBlaze,)
		
		
		//Registering Blocks//
		GameRegistry.registerBlock(oreChromium);
		GameRegistry.registerBlock(oreMagnesium);
		
		GameRegistry.registerWorldGenerator(new WorldGen());
		
		
		//Adding Recipes//
		GameRegistry.addShapelessRecipe(new ItemStack(this.blazeClump, 1), new Object[]{
			Item.blazeRod
		});
		
		
		//The Proxy//
		proxy.registerRenderThings();
		
		
		//Registering Names - These Are The ACTUAL Names//
		LanguageRegistry.addName(oreChromium, "Chromium Ore");
		LanguageRegistry.addName(oreMagnesium, "Magnesium Ore");
		
		LanguageRegistry.addName(blazeClump, "Blaze Clump");
		LanguageRegistry.addName(blazeIngot, "Blaze Ingot");
		LanguageRegistry.addName(silicon, "Silicon");

	}
       
}