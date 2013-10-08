package dragonsreign.item;

import java.util.ArrayList;

public class Inventory {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final int MAX_INVENTORY_SIZE = 25;

	// ===========================================================
	// Fields
	// ===========================================================

	private ArrayList<Item> mInventory = new ArrayList<Item>();

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// Get the number of items stored in the inventory
	public int getCurrentInventorySize() {
		return mInventory.size();
	}

	// Get the max amount of inventory slots
	public int getMaxInventorySize() {
		return MAX_INVENTORY_SIZE;
	}

	// Get an item stored in the inventory by its location
	public Item getItem(int pIndex) {
		return mInventory.get(pIndex);
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// Inserts an item in the first available inventory slot
	public boolean addItem(Item pItem) {
		boolean itemAdded = false;

		if (mInventory.size() < MAX_INVENTORY_SIZE) {
			mInventory.add(pItem);

			itemAdded = true;
		}

		return itemAdded;
	}

	// Remove an item from the inventory
	public void removeItem(Item pItem) {
		if (mInventory.contains(pItem)) {
			mInventory.remove(pItem);
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
