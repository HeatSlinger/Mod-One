package ebt.common;
 
import net.minecraft.src.Block;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
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
	public static Item ingotChromium;
	public static Item ingotMagnesium;	
	public static Item blazeClump;
	public static Item blazeIngot;
	public static Item silicon;
	
	public static Item blazeSword;
	
	
	//Declaring Armor//
	public static Item blazeHelmet;
	public static Item blazePlate;
	public static Item blazeLegs;
	public static Item blazeBoots;
	
	
	//Declaring Id's//
	public int oreChromiumBlockID = 250;
	public int oreMagnesiumBlockID = 251;
	
	public int ingotChromiumID = 1200;
	public int ingotMagnesiumID = 1201;
	public int blazeClumpID = 1202;
	public int blazeIngotID = 1203;
	public int siliconID = 1204;
	
	public int blazeSwordID = 1205;
	
	public int blazeHelmetID = 1206;
	public int blazePlateID = 1207;
	public int blazeLegsID = 1208;
	public int blazeBootsID = 1209;
	
	
	//Materials//
	static EnumArmorMaterial BlazeArmor = EnumHelper.addArmorMaterial("BLAZE", 21, new int[]{2, 6, 4, 3,}, 17);
	static EnumToolMaterial BlazeTool = EnumHelper.addToolMaterial("Blaze", 0, 400, 7F, 4, 14);
	
	
	//The Client and Common Proxy//
	@SidedProxy(clientSide = "ebt.client.ClientProxy", serverSide = "ebt.common.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void PreLoad(FMLPreInitializationEvent event) {		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		int oreoreChromiumBlockID = config.getBlock("Chromium Ore Block ID", Configuration.CATEGORY_BLOCK, 120).getInt();
		int oreMagnesiumBlockID = config.getBlock("Magnesium Ore Block ID", Configuration.CATEGORY_BLOCK, 121).getInt();
		
		int ingotChromiumID = config.getItem("Chromium Ingot ID", Configuration.CATEGORY_ITEM, 1200).getInt();
		int ingotMagnesiumID = config.getItem("Magnesium Ingot ID", Configuration.CATEGORY_ITEM, 1201).getInt();
		int blazeClumpID = config.getItem("Blaze Clump ID", Configuration.CATEGORY_ITEM, 1202).getInt();
		int blazeIngotID = config.getItem("Blaze Ingot ID", Configuration.CATEGORY_ITEM, 1203).getInt();
		int siliconID = config.getItem("Silicon ID", Configuration.CATEGORY_ITEM, 1204).getInt();
		
		int blazeSwordID = config.getItem("Blaze Sword ID",  Configuration.CATEGORY_ITEM, 1205).getInt();
		
		int blazeHelmetID = config.getItem("Blaze Helmet ID", Configuration.CATEGORY_ITEM, 1206).getInt();
		int blazePlateID = config.getItem("Blaze Platebody ID", Configuration.CATEGORY_ITEM, 1207).getInt();
		int blazeLegsID = config.getItem("Blaze Helmet ID", Configuration.CATEGORY_ITEM, 1208).getInt();
		int blazeBootsID = config.getItem("Blaze Helmet ID", Configuration.CATEGORY_ITEM, 1209).getInt();
		
		config.save();
	}
	
	
	
	//The Mod//
	@Init
	public void load(FMLInitializationEvent event) {
		//Defining Blocks//
		oreChromium = new BlockOreChromium(oreChromiumBlockID, 0).setBlockName("oreoreChromium");
		oreMagnesium = new BlockOreMagnesium(oreMagnesiumBlockID, 1).setBlockName("oreMagnesium");
		
		
		//Defining Items//
		ingotChromium = new ItemIngotChromium(ingotChromiumID) .setIconIndex(4) .setItemName("ingotChromium");
		ingotMagnesium = new ItemIngotMagnesium(ingotMagnesiumID) .setIconIndex(5) .setItemName("ingotMagnesium");
		blazeClump = new ItemBlazeClump(blazeClumpID) .setIconIndex(0) .setItemName("blazeClump");
		blazeIngot = new ItemBlazeIngot(blazeIngotID) .setIconIndex(1) .setItemName("blazeIngot");
		silicon = new ItemSilicon(siliconID) .setIconIndex(3) .setItemName("silicon");
		
		blazeSword = new ItemBlazeSword(4001, BlazeTool).setIconIndex(16).setItemName("blazeSword"); 
		
		
		//Defining Armor//
		int rendererBlaze = proxy.addArmor("blaze");
		blazeHelmet = new ItemBlazeArmor(blazeHelmetID, BlazeArmor, rendererBlaze, 0) .setIconIndex(0) .setItemName("blazeHelmet");
		blazePlate = new ItemBlazeArmor(blazePlateID, BlazeArmor, rendererBlaze, 1) .setIconIndex(0) .setItemName("blazePlate");
		blazeLegs = new ItemBlazeArmor(blazeLegsID, BlazeArmor, rendererBlaze, 2) .setIconIndex(0) .setItemName("blazeLegs");
		blazeBoots = new ItemBlazeArmor(blazeBootsID, BlazeArmor, rendererBlaze, 3) .setIconIndex(0) .setItemName("blazeBoots");
		
		//Registering Blocks//
		GameRegistry.registerBlock(oreChromium);
		GameRegistry.registerBlock(oreMagnesium);
		
		GameRegistry.registerWorldGenerator(new WorldGen());
		
		
		//Adding Recipes//
		GameRegistry.addRecipe(new ItemStack(this.blazeClump), new Object[]{
			"XX", "XX", 'X', Item.blazeRod
		});
		
		GameRegistry.addRecipe(new ItemStack(this.blazeHelmet), new Object[]{
			"XXX", "X X", 'X', blazeIngot
		});
		GameRegistry.addRecipe(new ItemStack(this.blazePlate), new Object[]{
			"X X", "XXX", "XXX", 'X', blazeIngot
		});
		GameRegistry.addRecipe(new ItemStack(this.blazeLegs), new Object[]{
			"XXX", "X X", "X X", 'X', blazeIngot
		});
		GameRegistry.addRecipe(new ItemStack(this.blazeBoots), new Object[]{
			"X X", "X X", 'X', blazeIngot
		});
		GameRegistry.addRecipe(new ItemStack(this.blazeSword), new Object[]{
			" X ", " X ", " Y ", 'X', blazeIngot, 'Y', Item.blazeRod
		});
		
		GameRegistry.addSmelting(blazeClump.shiftedIndex, new ItemStack(this.blazeIngot), .1F);
		GameRegistry.addSmelting(oreChromium.blockID, new ItemStack(this.ingotChromium), .1F);
		GameRegistry.addSmelting(oreMagnesium.blockID, new ItemStack(this.ingotMagnesium), .1F);
		
		
		//The Proxy//
		proxy.registerRenderThings();
		
		
		//Registering Names - These Are The ACTUAL Names//
		LanguageRegistry.addName(oreChromium, "Chromium Ore");
		LanguageRegistry.addName(oreMagnesium, "Magnesium Ore");
		
		LanguageRegistry.addName(ingotChromium, "Chromium Ingot");
		LanguageRegistry.addName(ingotMagnesium, "Magnesium Ingot");
		LanguageRegistry.addName(blazeClump, "Blaze Clump");
		LanguageRegistry.addName(blazeIngot, "Blaze Ingot");
		LanguageRegistry.addName(silicon, "Silicon");
		
		LanguageRegistry.addName(blazeSword, "Blaze Sword"); 
		
		LanguageRegistry.addName(blazeHelmet, "Blaze Hemlet");
		LanguageRegistry.addName(blazePlate, "Blaze Chestplate");
		LanguageRegistry.addName(blazeLegs, "Blaze Legs");
		LanguageRegistry.addName(blazeBoots, "Blaze Boots");

	}
       
}