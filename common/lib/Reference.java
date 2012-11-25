package ebt.common.lib;

public class Reference {
	
	public static final boolean DEBUG_MODE = false;
	
	public static final String MOD_ID = "EBT";
	public static final String MOD_NAME = "Everything But The";
	public static final String VERSION = "@VERSION@";
	public static final String CHANNEL_NAME = MOD_ID;
	public static final int SECOND_IN_TICKS = 20;
	public static final int SHIFTED_ID_RANGE_CORRECTION = 256;
    public static final String SERVER_PROXY_CLASS = "ebt.common.core.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "ebt.client.ClientProxy";

    public static final String ARMOR_SHEET_LOCATION = "/ebt.client/resources/";
    public static final String ITEM_SPRITE_SHEET = "/ebt.client/resources/items.png";
    public static final String BLOCK_SPRITE_SHEET = "/ebt.client/resources/terrain.png";
}
