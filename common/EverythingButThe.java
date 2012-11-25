package ebt.common;
 
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityDamageSourceIndirect;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ebt.common.block.ModBlocks;
import ebt.common.core.CommonProxy;
import ebt.common.core.handlers.ConfigurationHandler;
import ebt.common.item.ItemBlazeArmor;
import ebt.common.item.ModItems;
import ebt.common.lib.ItemIds;


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
	@SidedProxy(clientSide = "ebt.client.core.ClientProxy", serverSide = "ebt.common.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void PreLoad(FMLPreInitializationEvent event) {		
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		
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
		blazeHelmet = new ItemBlazeArmor(ItemIds.BLAZE_HELMET, BlazeArmor, rendererBlaze, 0) .setIconIndex(17) .setItemName("blazeHelmet");
		blazePlate = new ItemBlazeArmor(ItemIds.BLAZE_CHEST, BlazeArmor, rendererBlaze, 1) .setIconIndex(18) .setItemName("blazePlate");
		blazeLegs = new ItemBlazeArmor(ItemIds.BLAZE_LEGS, BlazeArmor, rendererBlaze, 2) .setIconIndex(19) .setItemName("blazeLegs");
		blazeBoots = new ItemBlazeArmor(ItemIds.BLAZE_BOOTS, BlazeArmor, rendererBlaze, 3) .setIconIndex(20) .setItemName("blazeBoots");
		
		//Registering Blocks//
		GameRegistry.registerWorldGenerator(new WorldGen());
		
		
		//The Recipes//
		GameRegistry.addRecipe(new ItemStack(blazeHelmet), new Object[]{
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

		
		//The Proxy//
		proxy.registerRenderThings();
		
		
		//Registering Names - These Are The ACTUAL Names//
		LanguageRegistry.addName(blazeHelmet, "Blaze Hemlet");
		LanguageRegistry.addName(blazePlate, "Blaze Chestplate");
		LanguageRegistry.addName(blazeLegs, "Blaze Legs");
		LanguageRegistry.addName(blazeBoots, "Blaze Boots");
		
		
		//Rendering Registry//
		RenderingRegistry.registerEntityRenderingHandler(EntityPebble.class, new ebt.client.render.RenderPebble());
	}
}