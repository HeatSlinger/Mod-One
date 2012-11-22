package ebt.client;
 
import org.lwjgl.opengl.GL11;

import ebt.common.ContainerFancyChest;
import net.minecraft.src.*;
 
 
public class GuiFancyChest extends GuiContainer{
	public GuiFancyChest(InventoryPlayer player_inventory, TileFancy tile_entity){
		super(new ContainerFancyChest(tile_entity, player_inventory));
	}
       
	//Draws the GUI foreground//
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j){
       
		fontRenderer.drawString("Fancy Chest GUI", 6, 6, 0xffffff);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 , 0xffffff);
	}
       
	//Draws the GUI background//
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j){
       
		int picture = mc.renderEngine.getTexture("/terrain.png");
               
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
               
		this.mc.renderEngine.bindTexture(picture);

		int x = (width - xSize) / 2;

		int y = (height - ySize) / 2;
               
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}