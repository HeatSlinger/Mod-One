package ebt.common;

import java.util.Random;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}

	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) {
		for(int i = 0; i < 26; i++){
		int Xcoord = blockX + random.nextInt(16);
		int Zcoord = blockZ + random.nextInt(16);
		int Ycoord = 20 + random.nextInt(16);
		
		(new WorldGenMinable(EverythingButThe.chromiumOre.blockID, 5)).generate(world, random, Xcoord, Ycoord, Zcoord);
		(new WorldGenMinable(EverythingButThe.magnesiumOre.blockID, 4)).generate(world, random, Xcoord, Ycoord, Zcoord);
	}}

	private void generateNether(World world, Random random, int i, int j) {
		
	}

}
