package ebt.common;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockMagnesiumOre extends Block {
	public BlockMagnesiumOre(int blockID) {
		super(blockID, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(3.0F);
	}
	
	//This is the texture file//
	public String getTextureFile(){
		return "/Tile.png";
	}
		
}
