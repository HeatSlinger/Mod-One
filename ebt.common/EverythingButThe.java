package ebt;
 
import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
 
@Mod(modid = "mod", name = "Everything But The", version = "1.0")
 
@NetworkMod(clientSideRequired=true, serverSideRequired=false, clientPacketHandlerSpec = @SidedPacketHandler(channels = {"EverythingButThe" }, packetHandler = ClientPacketHandler.class),
serverPacketHandlerSpec =@SidedPacketHandler(channels = {"EverythingButThe" }, packetHandler = ServerPacketHandler.class))
 
public class EverythingButThe {
       
	@Instance
	//Declaring Instance//
	public static EverythingButThe instance = new EverythingButThe();
       
	//GUI Handler//
	private GuiHandler guiHandler = new GuiHandler();
	
	//Declaring Blocks//
	public static Block fancyStorage;
 
	//The Client and Common Proxy//
	@SidedProxy(clientSide = "tutorials.ClientProxy", serverSide = "tutorials.CommonProxy")
	public static CommonProxy proxy;
        
	//The Mod//
	@Init
	public void load(FMLInitializationEvent event){
        		
		//Defining Blocks//
		fancyStorage = new FancyStorage(243).setBlockName("blockTutorial");
               
		//Registering Tile Entities//
		GameRegistry.registerTileEntity(TileTutorial.class, "tileEntityTutorial");
                
		//Registering Blocks//
		GameRegistry.registerBlock(fancyStorage);
        	
		//Adding Recipes//
		GameRegistry.addRecipe(new ItemStack(this.fancyStorage, 1), new Object[]{
			"   ", " X ", "   ", Character.valueOf('X'), Block.obsidian
		});

		//The Proxy//
		proxy.registerRenderThings();
        	
		//Registering Names//
		LanguageRegistry.addName(fancyStorage, "Fancy Storage Unit");
                
                
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
	}
       
}