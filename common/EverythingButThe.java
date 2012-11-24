package ebt.common;
 
import net.minecraft.src.Block;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
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
	
	
	//Declaring Armor//
	public static Item blazeHelmet;
	public static Item blazePlate;
	public static Item blazeLegs;
	public static Item blazeBoots;
	
	
	//Declaring Id's//
	public int oreChromiumBlockID = 250;
	public int oreMagnesiumBlockID = 251;
	
	public int blazeClumpID = 1200;
	public int blazeIngotID = 1201;
	public int siliconID = 1202;
	
	public int blazeHelmetID = 1203;
	public int blazePlateID = 1204;
	public int blazeLegsID = 1205;
	public int blazeBootsID = 1206;
	
	
	//Materials//
	static EnumArmorMaterial EnumArmorMaterialBlaze = EnumHelper.addArmorMaterial("BLAZE", 21, new int[]{2, 6, 4, 3,}, 17);
	
	
	
	
	//The Client and Common Proxy//
	@SidedProxy(clientSide = "ebt.client.ClientProxy", serverSide = "ebt.common.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void PreLoad(FMLPreInitializationEvent event) {
		proxy.texturePreloads();
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		int oreoreChromiumBlockID = config.getBlock("Chromium Ore Block ID", Configuration.CATEGORY_BLOCK, 120).getInt();
		int oreMagnesiumBlockID = config.getBlock("Magnesium Ore Block ID", Configuration.CATEGORY_BLOCK, 121).getInt();
		
		int blazeClumpID = config.getItem("Blaze Clump ID", Configuration.CATEGORY_ITEM, 1200).getInt();
		int blazeIngotID = config.getItem("Blaze Ingot ID", Configuration.CATEGORY_ITEM, 1201).getInt();
		int siliconID = config.getItem("Silicon ID", Configuration.CATEGORY_ITEM, 1202).getInt();
		
		int blazeHelmetID = config.getItem("Blaze Helmet ID", Configuration.CATEGORY_ITEM, 1202).getInt();
		int blazePlateID = config.getItem("Blaze Platebody ID", Configuration.CATEGORY_ITEM, 1203).getInt();
		int blazeLegsID = config.getItem("Blaze Helmet ID", Configuration.CATEGORY_ITEM, 1204).getInt();
		int blazeBootsID = config.getItem("Blaze Helmet ID", Configuration.CATEGORY_ITEM, 1205).getInt();
		
		config.save();
	}
	
	
	
	//The Mod//
	@Init
	public void load(FMLInitializationEvent event) {
		//Rendering BlazeEnum//
		int rendererBlaze = proxy.addArmor("blaze");
        		
		//Defining Blocks//
		oreChromium = new BlockOreChromium(oreChromiumBlockID, 0).setBlockName("oreoreChromium");
		oreMagnesium = new BlockOreMagnesium(oreMagnesiumBlockID, 1).setBlockName("oreMagnesium");
		
		
		//Defining Items//
		blazeClump = new ItemBlazeClump(blazeClumpID).setItemName("blazeClump");
		blazeIngot = new ItemBlazeIngot(blazeIngotID).setItemName("blazeIngot");
		silicon = new ItemSilicon(siliconID).setItemName("silicon");
		
		
		//Defining Armor//
		blazeHelmet = new ItemBlazeArmor(blazeHelmetID, EnumArmorMaterialBlaze, rendererBlaze, 0) .setIconIndex(32) .setItemName("blazeHelmet");
		blazePlate = new ItemBlazeArmor(blazePlateID, EnumArmorMaterialBlaze, rendererBlaze, 1) .setIconIndex(32) .setItemName("blazePlate");
		blazeLegs = new ItemBlazeArmor(blazeLegsID, EnumArmorMaterialBlaze, rendererBlaze, 2) .setIconIndex(32) .setItemName("blazeLegs");
		blazeBoots = new ItemBlazeArmor(blazeBootsID, EnumArmorMaterialBlaze, rendererBlaze, 3) .setIconIndex(32) .setItemName("blazeBoots");
		
		//Registering Blocks//
		GameRegistry.registerBlock(oreChromium);
		GameRegistry.registerBlock(oreMagnesium);
		
		GameRegistry.registerWorldGenerator(new WorldGen());
		
		
		//Adding Recipes//
		GameRegistry.addShapelessRecipe(new ItemStack(this.blazeClump, 1), new Object[]{
			new ItemStack(Item.blazeRod, 4)
		});
		
		GameRegistry.addRecipe(new ItemStack(this.blazeHelmet), new Object[]{
			"XXX", "X X", "   ", 'X', blazeIngot
		});
		GameRegistry.addRecipe(new ItemStack(this.blazePlate), new Object[]{
			"X X", "XXX", "XXX", 'X', blazeIngot
		});
		GameRegistry.addRecipe(new ItemStack(this.blazeLegs), new Object[]{
			"XXX", "X X", "X X", 'X', blazeIngot
		});
		GameRegistry.addRecipe(new ItemStack(this.blazeBoots), new Object[]{
			"   ", "X X", "X X", 'X', blazeIngot
		});
		
		GameRegistry.addSmelting(blazeClump.shiftedIndex, new ItemStack(this.blazeIngot), .1F);
		
		
		//The Proxy//
		proxy.registerRenderThings();
		
		
		//Registering Names - These Are The ACTUAL Names//
		LanguageRegistry.addName(oreChromium, "Chromium Ore");
		LanguageRegistry.addName(oreMagnesium, "Magnesium Ore");
		
		LanguageRegistry.addName(blazeClump, "Blaze Clump");
		LanguageRegistry.addName(blazeIngot, "Blaze Ingot");
		LanguageRegistry.addName(silicon, "Silicon");
		
		LanguageRegistry.addName(blazeHelmet, "Blaze Hemlet");
		LanguageRegistry.addName(blazePlate, "Blaze Chestplate");
		LanguageRegistry.addName(blazeLegs, "Blaze Legs");
		LanguageRegistry.addName(blazeBoots, "Blaze Boots");

	}
       
}