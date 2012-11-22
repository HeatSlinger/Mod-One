package ebt.client;
 
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;
 
public class TileFancy extends TileEntity implements IInventory{
	
	private ItemStack[] inventory;
	
	//How many item stacks the inventory has//
	public TileFancy(){
		this.inventory = new ItemStack[27];
	}
	
	//Gets the inventory length//
	@Override
	public int getSizeInventory(){
		return this.inventory.length;
	}
	
	//Gets the stack slot//
	@Override
	public ItemStack getStackInSlot(int slotIndex){
		return this.inventory[slotIndex];
	}
	
	//Set inventory slot contents and how many//
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack){
		this.inventory[slot] = stack;
               
		if(stack != null && stack.stackSize > getInventoryStackLimit()){
			stack.stackSize = getInventoryStackLimit();
		}
	}
       
	//Splitting stacks//
	@Override
	public ItemStack decrStackSize(int slotIndex, int amount){
       
		ItemStack stack = getStackInSlot(slotIndex);
               
		if(stack != null){
               
			if(stack.stackSize <= amount){
				setInventorySlotContents(slotIndex, null);
			}
			else{
				stack = stack.splitStack(amount);
				if(stack.stackSize == 0){
					setInventorySlotContents(slotIndex, null);
				}
			}
		}
       
       
		return stack;
	}
       
	//Gets stack in slots//
	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex){
       
		ItemStack stack = getStackInSlot(slotIndex);
               
		//If it's null, don't do anything//
		if(stack != null){
			setInventorySlotContents(slotIndex, null);
		}
               
               
		return stack;
	}
       
	//Get inventory stack limit//
	@Override
	public int getInventoryStackLimit(){
		return 64;
	}
       
	//Get it it's usable by player//
	@Override
	public boolean isUseableByPlayer(EntityPlayer player){
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
       
       
	@Override
	public void openChest() {}
	
	@Override
	public void closeChest() {}
       
	//NBT stuff//
	@Override
	public void readFromNBT(NBTTagCompound tagCompound){
		super.readFromNBT(tagCompound);
               
		NBTTagList tagList = tagCompound.getTagList("Inventory");
               
		for(int i = 0; i < tagList.tagCount(); i++){
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                       
			byte slot = tag.getByte("Slot");
                       
			if(slot >= 0 && slot < inventory.length){
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
    
	//Write to NBT stuff//
	@Override
	public void writeToNBT(NBTTagCompound tagCompound){
		super.writeToNBT(tagCompound);
               
		NBTTagList itemList = new NBTTagList();
               
		for(int i = 0; i < inventory.length; i++){
			ItemStack stack = inventory[i];
                       
			if(stack != null){
				NBTTagCompound tag = new NBTTagCompound();
                               
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
               
		tagCompound.setTag("Inventory", itemList);
	}
       
	//Get inventory name//
	@Override
	public String getInvName(){
		return "Fancy Chest";
	}
}