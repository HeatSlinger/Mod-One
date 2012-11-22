package ebt.client;
 
import cpw.mods.fml.common.network.IGuiHandler;
import ebt.common.ContainerFancyChest;
import net.minecraft.src.*;
 
public class GuiHandler implements IGuiHandler{
 
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
       
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
               
		if(tile_entity instanceof TileFancy){
               
			return new ContainerFancyChest((TileFancy) tile_entity, player.inventory);
		}
               
               
		return null;
	}
       
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
       
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
               
               
		if(tile_entity instanceof TileFancy){
       
			return new GuiFancyChest(player.inventory, (TileFancy) tile_entity);
		}
       
		return null;
	}
}