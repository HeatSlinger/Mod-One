package ebt.common.block;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockOreMagnesium extends Block {
	public BlockOreMagnesium(int blockID, int par2) {
		super(blockID, par2, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
	}
	
	//This is the texture file//
	public String getTextureFile(){
		return "/ebt.client/resources/terrain.png";
	}
		
}
