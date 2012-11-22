package ebt.client;
 
import ebt.common.CommonProxy;
import net.minecraftforge.client.MinecraftForgeClient;
 
public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderThings() {
		MinecraftForgeClient.preloadTexture("/Tile.png");
	}

}