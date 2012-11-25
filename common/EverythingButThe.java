package ebt.common;
 
import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityDamageSourceIndirect;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.RenderArrow;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
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
import ebt.client.RenderPebble;
import ebt.common.block.ModBlocks;
import ebt.common.block.BlockOreChromium;
import ebt.common.block.BlockOreMagnesium;
import ebt.common.core.CommonProxy;
import ebt.common.item.ItemBlazeArmor;
import ebt.common.item.ItemBlazeSword;
import ebt.common.item.ItemIngotChromium;
import ebt.common.item.ItemIngotMagnesium;
import ebt.common.item.ItemPebble;
import ebt.common.item.ItemSilicon;
import ebt.common.item.ItemSlingshot;
import ebt.common.item.ModItems;


@Mod(modid = "mod", name = "Everything But The", version = "1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
 
public class EverythingButThe {
       
	@Instance
	//Declaring Instance//
	public static EverythingButThe instance = new EverythingButThe();
	
	//Declaring Armor//
	public static Item blazeHelmet;
	public static Item blazePlate;
	public static Item blazeLegs;
	public static Item blazeBoots;
	
	
	//Declaring Id's//	
	public int blazeHelmetID = 1206;
	public int blazePlateID = 1207;
	public int blazeLegsID = 1208;
	public int blazeBootsID = 1209;

	
	//Damage Addition//
    public static DamageSource causePebbleDamage(EntityPebble par0EntityArrow, Entity par1Entity) {
        return (new EntityDamageSourceIndirect("pebble", par0EntityArrow, par1Entity)).setProjectile();
    }
    
    
    //Enum Armor//
	static EnumArmorMaterial BlazeArmor = EnumHelper.addArmorMaterial("BLAZE", 21, new int[]{2, 6, 4, 3,}, 17);
	
	
	//The Client and Common Proxy//
	@SidedProxy(clientSide = "ebt.client.ClientProxy", serverSide = "ebt.common.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void PreLoad(FMLPreInitializationEvent event) {		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
/*		
		int oreoreChromiumBlockID = config.getBlock("Chromium Ore Block ID", Configuration.CATEGORY_BLOCK, 120).getInt();
		int oreMagnesiumBlockID = config.getBlock("Magnesium Ore Block ID", Configuration.CATEGORY_BLOCK, 121).getInt();
		
		int ingotChromiumID = config.getItem("Chromium Ingot ID", Configuration.CATEGORY_ITEM, 1200).getInt();
		int ingotMagnesiumID = config.getItem("Magnesium Ingot ID", Configuration.CATEGORY_ITEM, 1201).getInt();
		int blazeClumpID = config.getItem("Blaze Clump ID", Configuration.CATEGORY_ITEM, 1202).getInt();
		int blazeIngotID = config.getItem("Blaze Ingot ID", Configuration.CATEGORY_ITEM, 1203).getInt();
		int siliconID = config.getItem("Silicon ID", Configuration.CATEGORY_ITEM, 1204).getInt();
		
		int blazeSwordID = config.getItem("Blaze Sword ID",  Configuration.CATEGORY_ITEM, 1205).getInt();
		int slingshotID = config.getItem("Slingshot ID", Configuration.CATEGORY_ITEM, 1210).getInt();
		int pebbleID = config.getItem("Pebble ID", Configuration.CATEGORY_ITEM, 1211).getInt();
*/		
		int blazeHelmetID = config.getItem("Blaze Helmet ID", Configuration.CATEGORY_ITEM, 1206).getInt();
		int blazePlateID = config.getItem("Blaze Platebody ID", Configuration.CATEGORY_ITEM, 1207).getInt();
		int blazeLegsID = config.getItem("Blaze Helmet ID", Configuration.CATEGORY_ITEM, 1208).getInt();
		int blazeBootsID = config.getItem("Blaze Helmet ID", Configuration.CATEGORY_ITEM, 1209).getInt();
		
		config.save();
	}
	
	
	
	//The Mod//
	@Init
	public void load(FMLInitializationEvent event) {
		
		//Initialize Mod Blocks//
		ModBlocks.init();
		
		
		//Initialize Mod Items//
		ModItems.init();
		
		
		//Defining Armor//
		int rendererBlaze = proxy.addArmor("blaze");
		blazeHelmet = new ItemBlazeArmor(blazeHelmetID, BlazeArmor, rendererBlaze, 0) .setIconIndex(17) .setItemName("blazeHelmet");
		blazePlate = new ItemBlazeArmor(blazePlateID, BlazeArmor, rendererBlaze, 1) .setIconIndex(18) .setItemName("blazePlate");
		blazeLegs = new ItemBlazeArmor(blazeLegsID, BlazeArmor, rendererBlaze, 2) .setIconIndex(19) .setItemName("blazeLegs");
		blazeBoots = new ItemBlazeArmor(blazeBootsID, BlazeArmor, rendererBlaze, 3) .setIconIndex(20) .setItemName("blazeBoots");
		
		//Registering Blocks//
		GameRegistry.registerWorldGenerator(new WorldGen());
		
		
		//The Recipes//
/*		GameRegistry.addRecipe(new ItemStack(blazeHelmet), new Object[]{
			"XXX", "X X", 'X', ModItems.ingotBlaze
		});
		GameRegistry.addRecipe(new ItemStack(blazePlate), new Object[]{
			"X X", "XXX", "XXX", 'X', ModItems.ingotBlaze
		});
		GameRegistry.addRecipe(new ItemStack(blazeLegs), new Object[]{
			"XXX", "X X", "X X", 'X', ModItems.ingotBlaze
		});
		GameRegistry.addRecipe(new ItemStack(blazeBoots), new Object[]{
			"X X", "X X", 'X', ModItems.ingotBlaze
		});
*/		
		
		//The Proxy//
		proxy.registerRenderThings();
		
		
		//Registering Names - These Are The ACTUAL Names//
		LanguageRegistry.addName(blazeHelmet, "Blaze Hemlet");
		LanguageRegistry.addName(blazePlate, "Blaze Chestplate");
		LanguageRegistry.addName(blazeLegs, "Blaze Legs");
		LanguageRegistry.addName(blazeBoots, "Blaze Boots");
		
		
		//Rendering Registry//
		RenderingRegistry.registerEntityRenderingHandler(EntityPebble.class, new RenderPebble());
	}
}