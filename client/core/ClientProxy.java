package ebt.client.core;
 
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import ebt.common.core.CommonProxy;
 
public class ClientProxy extends CommonProxy {
	//Where the textures getting registered are located//
	@Override
	public void registerRenderThings() {
		MinecraftForgeClient.preloadTexture("/ebt.client/resources/terrain.png");
	}

	@Override
	public int addArmor(String armorBlaze) {
		return RenderingRegistry.addNewArmourRendererPrefix(armorBlaze);
	}
	
}